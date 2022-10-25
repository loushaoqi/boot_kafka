package com.example.kafkaboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.kafkaboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    KafkaTemplate<String,String> kafka;

    @RequestMapping("register")
    public String register(User user){
        String message = JSON.toJSONString(user);
        System.out.println("接收用户消息:"+message);
        kafka.send("register",message);
        return "OK";
    }


}
