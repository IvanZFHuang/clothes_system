package org.javaboy.vhr.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.mapper.RecordMapper;
import org.javaboy.vhr.mapper.TopupMapper;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Record;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.model.Topup;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/7 22:36
 * @Version 1.0
 */
@Service
public class RecordService {
    @Resource
    private RecordMapper recordMapper;
    @Resource
    private TopupMapper topupMapper;

    public Map<String, Object> listRecord(String info, Integer pageNum, Integer pageSize) {
        Hr hr = HrUtils.getCurrentHr();
        List<Role> roles = hr.getRoles();
        List<String> listRoles = new ArrayList<>();
        for (Role role : roles) {
            listRoles.add(role.getNameZh());
        }

        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Record> records = null;
        if (listRoles.contains("系统管理员")) {
            records = recordMapper.listRecord(info, null);
        } else {
            records = recordMapper.listRecord(info, hr.getId());
        }

        PageInfo<Record> pageInfo = new PageInfo<>(records);
        map.put("obj", pageInfo.getTotal());
        map.put("obj1", pageInfo.getList());
        map.put("msg", "查询成功");
        return map;
    }

    public Map<String, Object> listTopUp(String info, Integer pageNum, Integer pageSize) {
        Hr hr = HrUtils.getCurrentHr();
        List<Role> roles = hr.getRoles();
        List<String> listRoles = new ArrayList<>();
        for (Role role : roles) {
            listRoles.add(role.getNameZh());
        }
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Topup> records = null;
        if (listRoles.contains("系统管理员")) {
            records = topupMapper.listTopUp(info, null);
        } else {
            records = topupMapper.listTopUp(info, hr.getId());
        }

        PageInfo<Topup> pageInfo = new PageInfo<>(records);
        map.put("obj", pageInfo.getTotal());
        map.put("obj1", pageInfo.getList());
        map.put("msg", "查询成功");
        return map;
    }
}
