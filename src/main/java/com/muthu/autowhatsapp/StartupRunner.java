package com.muthu.autowhatsapp;

import com.muthu.autowhatsapp.service.BirthdayCheckerService;
import com.muthu.autowhatsapp.service.ExcelReaderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final ExcelReaderService excelReaderService;
    private final BirthdayCheckerService birthdayCheckerService;

    public StartupRunner(
            ExcelReaderService excelReaderService,
            BirthdayCheckerService birthdayCheckerService) {

        this.excelReaderService = excelReaderService;
        this.birthdayCheckerService = birthdayCheckerService;
    }

    @Override
    public void run(String... args) {

        var persons = excelReaderService.readExcel();

        var birthdays =
                birthdayCheckerService.findTodaysBirthdays(persons);

        if (birthdays.isEmpty()) {

            System.out.println("No birthdays today");

        } else {

            birthdays.forEach(person -> {

                String message =
                        "🎂 Happy Birthday " + person.getName()
                                + "! Wishing you a wonderful year ahead.";

                System.out.println(message);
            });
        }
    }
}
