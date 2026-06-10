package com.muthu.autowhatsapp.service;

import com.muthu.autowhatsapp.model.Person;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String generateBirthdayMessage(Person person) {

        return "🎂 Happy Birthday " + person.getName()
                + "! Wishing you a wonderful year ahead.";
    }
}
