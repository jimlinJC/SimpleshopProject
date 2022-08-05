package com.example.order.controller;



import com.example.order.model.MessageResponse;
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
     * @param orderid
     */
    @RabbitListener(queues={"tpu.queue"})
    public MessageResponse receive(Integer orderid) {
        try {
            int state = orderService.checkout(orderid);
            if(state==1)
                return new MessageResponse(200,"checkouted");
            else if(state==0)
                return new MessageResponse(404,"order id not found");
            else {
                return new MessageResponse(500,"order was checked out ");
            }
        } catch (Exception e) {
            return new MessageResponse(500,"no inventory");
        }
    }

}