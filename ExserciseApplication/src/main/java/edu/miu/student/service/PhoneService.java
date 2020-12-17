package edu.miu.student.service;

import edu.miu.student.domain.Phone;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PhoneService {
    List<Phone> findAll();
}
