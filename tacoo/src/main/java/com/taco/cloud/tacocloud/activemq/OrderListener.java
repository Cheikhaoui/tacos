package com.taco.cloud.tacocloud.activemq;

import com.taco.cloud.tacocloud.domain.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

    @JmsListener(destination = "taco.order.queue")
    public void receive(Order order){
        System.out.println("we receive an order :=)");
        System.out.println(order.getDeliveryState());
    }


}
