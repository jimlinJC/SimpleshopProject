package com.example.order.controller;

import com.example.order.model.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1")
public class SendMessageController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "/put_product", method = RequestMethod.POST)
	public ResponseEntity putMessage(@RequestBody Product product) {
		rabbitTemplate.setReceiveTimeout(1000000L);
		rabbitTemplate.setReplyTimeout(1000000L);
		try{
			Product newProduct = (Product) rabbitTemplate.convertSendAndReceive("tpu.queue", product);
			System.out.println(newProduct);

			if(!newProduct.getName().equals("null"))
				return ResponseEntity.ok(newProduct);
			else{
				return ResponseEntity.badRequest().build();
			}
		}catch(Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
}