package edu.miu.student.formater;

import edu.miu.student.domain.Phone;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class PhoneFormater implements Formatter<Phone> {

    @Override
    public Phone parse(String s, Locale locale) throws ParseException {
        Phone phone = new Phone();
        String[] temp = s.split("-");
        phone.setAreacode(temp[0]);
        phone.setPrefix(temp[1]);
        phone.setSufix(temp[2]);
        return phone;
    }


    @Override
    public String print(Phone phone, Locale locale) {
        return null;
    }
}
