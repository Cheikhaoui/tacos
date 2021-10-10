package com.taco.cloud.tacocloud.activemq;

import com.taco.cloud.tacocloud.domain.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service
public class OrderMessage {
    private final JmsTemplate template;

    public OrderMessage(JmsTemplate template) {
        this.template = template;
    }

    public void sendMessage(Order order){
        template.send(session -> {
            Message message = session.createObjectMessage(order);
            message.setStringProperty("X_ORDER_ORIGIN","WEB");
            return message;
        });
    }
}
