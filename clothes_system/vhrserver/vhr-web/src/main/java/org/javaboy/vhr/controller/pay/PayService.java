package org.javaboy.vhr.controller.pay;

import com.alipay.api.AlipayApiException;
import org.javaboy.vhr.mapper.ClothesMapper;
import org.javaboy.vhr.mapper.MemberMapper;
import org.javaboy.vhr.mapper.RecordMapper;
import org.javaboy.vhr.mapper.TopupMapper;
import org.javaboy.vhr.model.AlipayBean;
import org.javaboy.vhr.model.AlipayBeanMem;
import org.javaboy.vhr.model.Record;
import org.javaboy.vhr.model.Topup;
import org.javaboy.vhr.util.AlipayUtil;
import org.javaboy.vhr.utils.FormatDateUtil;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description: @Company：众阳健康 @Author: jiangheng @Date: 2020/4/8 17:43 @Version 1.0
 */
@Service(value = "alipayOrderService")
public class PayService {
    @Resource
    private RecordMapper recordMapper;
    @Resource
    private ClothesMapper clothesMapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private TopupMapper topupMapper;

    @Transactional
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        String form = AlipayUtil.connect(alipayBean);
        Record record = new Record();
        record.setCusId(alipayBean.getCusId());
        record.setClothesId(alipayBean.getClothesId());
        record.setRecordMoney(Double.parseDouble(alipayBean.getTotal_amount()));
        record.setRecordTime(FormatDateUtil.formatDate(new Date()));
        record.setRecordDetail(alipayBean.getSubject());
        record.setUserId(HrUtils.getCurrentHr().getId());
        recordMapper.insertSelective(record);
        //修改衣服是否付费
        clothesMapper.updateIsPay(alipayBean.getClothesId());
        return form;
    }

    @Transactional
    public String upmoney(AlipayBeanMem alipayBeanMem) throws AlipayApiException {
        String form = AlipayUtil.connectMem(alipayBeanMem);
        //修改余额
        memberMapper.updateBalance(alipayBeanMem.getMemberId(), Double.parseDouble(alipayBeanMem.getTotal_amount()) + alipayBeanMem.getBalance());
        //修改会员类型
        memberMapper.updateType(alipayBeanMem.getTypeId(), alipayBeanMem.getMemberId());
        Topup topup = new Topup();
        //插入充值记录
        topup.setCusId(alipayBeanMem.getCusId());
        topup.setMemberId(alipayBeanMem.getMemberId());
        topup.setTopupMoney(Double.parseDouble(alipayBeanMem.getTotal_amount()));
        topup.setTopupTime(FormatDateUtil.formatDate(new Date()));
        topup.setUserId(HrUtils.getCurrentHr().getId());
        topupMapper.insertSelective(topup);
        return form;
    }
}
