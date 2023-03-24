package com.anr.springrabbitmqintegration;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.anr.springrabbitmqintegration.RabbitMqIntegrationConfig.topicExchangeName;

@RestController
@RequestMapping("/send")
public class SimpleMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/{message}")
    public String publishMessage(@PathVariable String message){
        rabbitTemplate.convertAndSend(topicExchangeName, "foo.bar.#", message);
        return "message sent successfully";
    }

}
