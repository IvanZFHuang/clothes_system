package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.ChangeManageMapper;
import org.javaboy.vhr.mapper.EmployeeMapper;
import org.javaboy.vhr.model.ChangeManage;
import org.javaboy.vhr.model.RespBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/3/28 16:19
 * @Version 1.0
 */
@Service
public class ChangeManageService {

    @Resource
    private ChangeManageMapper changeManageMapper;
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * @return
     * @Date 2020/3/30 11:11
     * @Author jiangheng
     * @Description //TODO 修改员工的交接状态
     **/
    public RespBean updateIsover(Integer changId, Integer isOver) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateDate = simpleDateFormat.format(new Date());
        int count = changeManageMapper.updateIsOver(isOver, changId, updateDate);
        if (count > 0) {
            return RespBean.ok("修改成功", count);
        } else {
            return RespBean.error("修改失败");
        }
    }


    /**
     * @return 查询所有的交接信息
     * @Date 2020/3/31 13:43
     * @Author jiangheng
     * @Description //TODO
     **/
    public Map<String, Object> listChangemanage(Integer pageNum, Integer pageSize, String currnetDate, String workId) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChangeManage> changeManages = changeManageMapper.listChangemanage(currnetDate, workId);
        PageInfo<ChangeManage> pageInfo = new PageInfo<>(changeManages);
        Map<String, Object> map = new HashMap<>();
        map.put("obj", pageInfo.getList());
        map.put("obj1", pageInfo.getTotal());
        map.put("msg", "成功获取数据");
        return map;
    }

    /**
     * @return
     * @Date 2020/3/31 15:09
     * @Author jiangheng
     * @Description //TODO 添加交接信息
     **/
    public RespBean addChange(ChangeManage changeManage) {
        //根据workId 查询姓名
        String oparatorName = employeeMapper.getNameByWorkId(changeManage.getOparatorWorkid());
        String overName = employeeMapper.getNameByWorkId(changeManage.getOverWorkid());
        changeManage.setOparatorName(oparatorName);
        changeManage.setOverName(overName);
        int count = changeManageMapper.insertSelective(changeManage);
        if (count > 0) {
            return RespBean.ok("添策成功");
        } else {
            return RespBean.error("添加失败");
        }
    }
}
