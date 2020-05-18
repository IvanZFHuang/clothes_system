package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.MailSendLogMapper;
import org.javaboy.vhr.model.MailSendLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class MailSendLogService {
    @Resource
    MailSendLogMapper mailSendLogMapper;
    public Integer updateMailSendLogStatus(String msgId, Integer status) {
        return mailSendLogMapper.updateMailSendLogStatus(msgId, status);
    }

    public Integer insert(MailSendLog mailSendLog) {
        return mailSendLogMapper.insert(mailSendLog);
    }

    public List<MailSendLog> getMailSendLogsByStatus() {
        return mailSendLogMapper.getMailSendLogsByStatus();
    }

    public Integer updateCount(String msgId, Date date) {
        return mailSendLogMapper.updateCount(msgId,date);
    }
}
