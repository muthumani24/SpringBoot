package com.muthu.autowhatsapp.service;

import org.springframework.stereotype.Service;

@Service
public class WhatsAppService {

    public void sendMessage(String message) {

        System.out.println("Sending WhatsApp Message:");
        System.out.println(message);
    }
}
