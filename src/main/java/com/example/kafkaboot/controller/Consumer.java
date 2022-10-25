package com.example.kafkaboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.kafkaboot.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class Consumer {

    @KafkaListener(topics = "register")
    public void consume(String message) {
        System.out.println("接收到消息：" + message);
        User user = JSON.parseObject(message, User.class);
        System.out.println("正在为 " + user.getName() + " 办理开通业务...");
        System.out.println("开通成功");

    }

}
