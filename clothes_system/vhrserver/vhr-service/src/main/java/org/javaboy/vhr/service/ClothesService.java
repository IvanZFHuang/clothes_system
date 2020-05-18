package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.*;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.utils.AjaxRusult;
import org.javaboy.vhr.utils.FormatDateUtil;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/18 14:23
 * @Version 1.0
 */
@Service
public class ClothesService {
    @Resource
    private ClothesMapper clothesMapper;
    @Resource
    private ClothesTypePriceMapper clothesTypePriceMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private RecordMapper recordMapper;
    @Resource
    private TakeClothesMapper takeClothesMapper;
    @Resource
    private RewashMapper rewashMapper;
    @Resource
    private RefoundMapper refoundMapper;

    /**
     * @return werw
     * @Date 2020/4/15 18:22
     * @Author jiangheng
     * @Description //TODO 获取洗衣详情
     **/
    public PageInfo<ClothesDetail> listClothes(String info, Integer pageNum, Integer pageSize) {
        Hr hr = HrUtils.getCurrentHr();
        List<Role> roles = hr.getRoles();
        List<String> listRoles = new ArrayList<>();
        for (Role role : roles) {
            listRoles.add(role.getNameZh());
        }

        PageHelper.startPage(pageNum, pageSize);
        List<ClothesDetail> clothesDetails = null;
        if (listRoles.contains("系统管理员")) {
            clothesDetails = clothesMapper.listClothes(info, null);
        } else {
            clothesDetails = clothesMapper.listClothes(info, hr.getId());
        }

        PageInfo<ClothesDetail> clothesDetailPageInfo = new PageInfo<>(clothesDetails);
        return clothesDetailPageInfo;
    }

    /**
     * @return
     * @Date 2020/4/19 12:59
     * @Author jiangheng
     * @Description //TODO 获取所有的衣服类型
     **/
    public List<ClothesTypePrice> listClothesTypePrice() {
        return clothesTypePriceMapper.listClothesTypePrice();
    }

    /**
     * @return
     * @Date 2020/4/19 13:13
     * @Author jiangheng
     * @Description //TODO 根据typeId 查询
     **/
    public ClothesTypePrice selectByPrimaryKey(Integer typeId) {
        return clothesTypePriceMapper.selectByPrimaryKey(typeId);
    }

    /**
     * @return
     * @Date 2020/4/19 23:06
     * @Author jiangheng
     * @Description //TODO 添加衣服
     **/
    @Transactional
    public Integer insertClothes(Clothes clothes) {
        String putTime = FormatDateUtil.formatDate(new Date());
        clothes.setUserId(HrUtils.getCurrentHr().getId());
        clothes.setPutClothesTime(putTime);
        clothes.setProgress("正在洗");

        int count = clothesMapper.insertSelective(clothes);
        if (count > 0) {
            Integer id = clothes.getClothesId();
            clothes.setClothesNum("#000" + id);
            clothesMapper.updateNum(id, clothes.getClothesNum());
        }
        return count;
    }

    /**
     * @return
     * @Date 2020/4/20 20:51
     * @Author jiangheng
     * @Description //TODO 添加非会员洗衣
     **/
    @Transactional
    public AjaxRusult insertNomemClothes(NomemClothes nomemClothes) {
        Customer customer = new Customer();
        customer.setCusName(nomemClothes.getCusName());
        customer.setCusPhone(nomemClothes.getCusPhone());
        customer.setCusEmail(nomemClothes.getCusEmail());
        //添加客户信息
        int count = customerMapper.insertSelective(customer);
        if (count > 0) {
            Clothes clothes = new Clothes();
            clothes.setProgress("正在洗");
            clothes.setUserId(HrUtils.getCurrentHr().getId());
            clothes.setPutClothesTime(FormatDateUtil.formatDate(new Date()));
            clothes.setClothesAdjunct(nomemClothes.getClothesAdjunct());
            clothes.setClothesBrand(nomemClothes.getClothesBrand());
            clothes.setClothesColor(nomemClothes.getClothesColor());
            clothes.setClothesFlow(nomemClothes.getClothesFlow());
            clothes.setCustomerId(customer.getCusId());
            clothes.setEmpId(nomemClothes.getEmpId());
            clothes.setPreTime(nomemClothes.getPreTime());
            clothes.setRealPrice(nomemClothes.getRealPrice());
            clothes.setTypeId(nomemClothes.getTypeId());
            int num = clothesMapper.insertSelective(clothes);
            if (num > 0) {
                Integer id = clothes.getClothesId();
                clothes.setClothesNum("#000" + id);
                clothesMapper.updateNum(id, clothes.getClothesNum());
            }
        }
        return AjaxRusult.ok().put("msg", "添加成功");
    }

    /**
     * @return
     * @Date 2020/4/21 15:32
     * @Author jiangheng
     * @Description //TODO 会员付款
     **/
    @Transactional
    public AjaxRusult updateClothes(Map<String, Object> map) {
        Integer clothesId = (Integer) map.get("clothesId");
        int cusId = (Integer) map.get("cusId");
        int memberId = (Integer) map.get("memberId");
        double realPrice = Double.valueOf((double) map.get("realPrice"));
        String clothesType = (String) map.get("clothesTypeName");
        Double balance = Double.valueOf((Double) map.get("balance"));
        //修改状态
        clothesMapper.updateIsPay(clothesId);
        //修改余额
        memberMapper.updateBalance(memberId, balance - realPrice);
        //添加消费记录
        Record record = new Record();

        record.setRecordDetail(clothesType);
        record.setRecordTime(FormatDateUtil.formatDate(new Date()));
        record.setClothesId(clothesId);
        record.setRecordMoney(realPrice);
        record.setCusId(cusId);
        record.setMemId(memberId);
        record.setUserId(HrUtils.getCurrentHr().getId());
        recordMapper.insertSelective(record);
        return AjaxRusult.ok().put("msg", "付费成功");
    }

    /**
     * @return
     * @Date 2020/4/23 11:17
     * @Author jiangheng
     * @Description //TODO 取衣
     **/
    @Transactional
    public AjaxRusult takeClothes(Integer clothesId) {
        String date = FormatDateUtil.formatDate(new Date());
        TakeClothes takeClothes = new TakeClothes();
        takeClothes.setClothesId(clothesId);
        takeClothes.setTakeTime(date);
        takeClothesMapper.insertSelective(takeClothes);
        //修改洗衣进度，修改是否取衣
        clothesMapper.updateTakeClothes(clothesId, date, "已取衣");
        return AjaxRusult.ok().put("msg", "取衣成功");
    }

    /**
     * @return
     * @Date 2020/4/23 13:44
     * @Author jiangheng
     * @Description //TODO 已洗完
     **/

    public AjaxRusult completed(Integer clothesId) {
        clothesMapper.updateStates("已洗完", clothesId);
        return AjaxRusult.ok();
    }

    /**
     * @return
     * @Date 2020/4/23 14:31
     * @Author jiangheng
     * @Description //TODO 重洗
     **/
    @Transactional
    public AjaxRusult rewash(Rewash rewash) {
        //修改时间
        clothesMapper.updateTime(rewash.getClothesId(), rewash.getPreTime(), FormatDateUtil.formatDate(new Date()));
//       修改状态
        clothesMapper.updateStates("已重洗", rewash.getClothesId());
        rewash.setPreTime("");
        rewashMapper.insertSelective(rewash);
        return AjaxRusult.ok().put("msg", "衣服正在重洗，为您带来不便请谅解");
    }

    @Transactional
    public AjaxRusult refound(Refound refound) {
        clothesMapper.updateStates("已赔偿", refound.getClothesId());
        refound.setTime(FormatDateUtil.formatDate(new Date()));
        refoundMapper.insertSelective(refound);
        return AjaxRusult.ok().put("msg", "衣服已赔偿，为您带来不便请谅解");
    }

    /**
     * @return
     * @Date 2020/4/23 17:15
     * @Author jiangheng
     * @Description //TODO 获取正在洗的衣服和未领取的衣服
     **/
    public List<ClothesDetail> listClothesPro() {
        return clothesMapper.listClothesPro();
    }
}
