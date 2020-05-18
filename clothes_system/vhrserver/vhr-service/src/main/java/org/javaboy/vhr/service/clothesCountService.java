package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.*;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.utils.HrUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: wangshichao
 * @Date: 2020/4/22 14:01
 * @Version 1.0
 */
@Service
public class ClothesCountService {

    @Resource
    private clothesCountMapper clothesCountMapper;
    @Resource
    private TakeClothesCountMapper takeClothesCountMapper;
    @Resource
    private TurnoverMapper turnoverMapper;
    @Resource
    private RefoundCountMapper refoundCountMapper;
    @Resource
    private RewashCountMapper rewashCountMapper;

    /**
     * @return
     * @Date 2020/4/26 10:01
     * @Author jiangheng
     * @Description //TODO 收衣的数量
     **/
    public List<cloCount> listClothes() {
        Hr hr = HrUtils.getCurrentHr();
        return clothesCountMapper.listClothes(hr.getId());
    }

    /**
     * @return
     * @Date 2020/4/26 10:02
     * @Author jiangheng
     * @Description //TODO 取衣的数量
     **/
    public List<TakeClothesCount> list() {
        Hr hr = HrUtils.getCurrentHr();
        return takeClothesCountMapper.listTcCount(hr.getId());

    }

    /**
     * @return
     * @Date 2020/4/26 10:59
     * @Author jiangheng
     * @Description //TODO 查询营业额
     **/
    public List<Turnover> listTurnover() {
        Hr hr = HrUtils.getCurrentHr();
        return turnoverMapper.listTurnover(hr.getId());
    }

    /**
     * @return
     * @Date 2020/4/26 13:53
     * @Author jiangheng
     * @Description //TODO 获取每个店的每天营业额的对比图
     **/

    public Map<String, Object> listIntervalTurn() {
        List<Turnover> first = turnoverMapper.listTurnover(5);
        List<Turnover> second = turnoverMapper.listTurnover(10);
        List<Turnover> third = turnoverMapper.listTurnover(11);
        List<Turnover> fourth = turnoverMapper.listTurnover(12);
        Map<String, Object> map = new HashMap<>();
        map.put("first", first);
        map.put("second", second);
        map.put("third", third);
        map.put("fourth", fourth);
        return map;
    }

    /**
     * @return
     * @Date 2020/4/26 15:25
     * @Author jiangheng
     * @Description //TODO 洗衣情况数量的反馈
     **/
    public Map<String, Object> listServicefall() {
        Hr hr = HrUtils.getCurrentHr();
        Map<String, Object> map = new HashMap<>();
        List<TakeClothesCount> takeClothesCounts = takeClothesCountMapper.list(hr.getId());
        List<cloCount> cloCountlist = clothesCountMapper.listClothe(hr.getId());
        List<RefoundCount> refoundCounts = refoundCountMapper.listCount(hr.getId());
        List<RewashCount> rewashCountlist = rewashCountMapper.listCount(hr.getId());
        map.put("first", takeClothesCounts);
        map.put("second", cloCountlist);
        map.put("third", refoundCounts);
        map.put("fourth", rewashCountlist);
        return map;
    }
}
