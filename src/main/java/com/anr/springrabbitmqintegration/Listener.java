package com.anr.springrabbitmqintegration;

import org.springframework.stereotype.Component;

@Component
public class Listener {

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }


}
