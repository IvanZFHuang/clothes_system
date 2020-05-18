package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.MsgContentMapper;
import org.javaboy.vhr.model.MsgContent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/4/24 18:13
 * @Version 1.0
 */
@Service
public class MsgContentService {
    @Resource
    private MsgContentMapper msgContentMapper;

    public List<MsgContent> listMsgContent() {
        return msgContentMapper.listMsgContent();
    }
}
