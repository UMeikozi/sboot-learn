package com.yhx.quickmail.controller;

import com.yhx.quickmail.config.MailUtil;
import com.yhx.quickmail.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shipeng.yu
 * @time: 2017年03月01日 7:53 PM
 * @version: 1.0
 * @since: 1.0
 * @description:
 */
@RestController
public class MailController {

    @Autowired
    @Qualifier("javaMailSender")
    JavaMailSender javaMailSender;

    @Autowired
    MailUtil mailUtil;

    /**
     * 发送邮件
     *
     * @throws Exception
     */
    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    public void sendSimpleMail(User user) throws Exception {
        user.setEmail("adobe1874@126.com");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("用户登录提醒");
        message.setText("你的到来让我很高兴,谢谢");
//            mailUtil.sendSimpleMail(javaMailSender, message);
        mailUtil.sendTemplateMail(javaMailSender, user.getEmail(), user.getUsername());
    }
}
