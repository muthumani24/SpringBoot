package com.muthu.autowhatsapp.service;

import com.muthu.autowhatsapp.model.Person;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelReaderService {

    public List<Person> readExcel() {

        List<Person> persons = new ArrayList<>();

        try {

            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("birthdays.xlsx");

            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

              Row row = sheet.getRow(i);

                DataFormatter formatter = new DataFormatter();

                String name = formatter.formatCellValue(row.getCell(1));
                String dob = formatter.formatCellValue(row.getCell(2));

                if (name == null || name.trim().isEmpty()
                       || dob == null || dob.trim().isEmpty()) {
                continue;
}

                persons.add(new Person(name, dob));
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }
}
