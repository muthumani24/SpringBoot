package com.muthu.autowhatsapp.service;

import com.muthu.autowhatsapp.model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BirthdayCheckerService {

    public List<Person> findTodaysBirthdays(List<Person> persons) {

        List<Person> birthdayPersons = new ArrayList<>();

        LocalDate today = LocalDate.now();

        int currentDay = today.getDayOfMonth();
        int currentMonth = today.getMonthValue();

        for (Person person : persons) {

            String dob = person.getDob();

            try {

                String[] parts = dob.split("/");

                int month = Integer.parseInt(parts[0]);
                int day = Integer.parseInt(parts[1]);

                if (day == currentDay && month == currentMonth) {
                    birthdayPersons.add(person);
                }

            } catch (Exception e) {
               System.out.println("Invalid DOB format: [" + dob + "]");
            }
        }

        return birthdayPersons;
    }
}
