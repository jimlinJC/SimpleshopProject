package com.example.order.controller;


import com.example.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceiveMessageListener {

    @Autowired
    OrderService orderService;

    /**
     * 監聽Queue中是否有資料，若有資料則進行消費。
     *
     * @param orderid
     */
    @RabbitListener(queues = {"tpu.queue"})
    public Integer receive(Integer orderid) {
        try {
            int state = orderService.checkout(orderid);
            if (state == 1)
                return 200;
            else if (state == 0)
                return 404;
            else {
                return 500;
            }
        } catch (Exception e) {
            return 500;
        }
    }

}