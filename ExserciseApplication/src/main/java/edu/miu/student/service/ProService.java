package edu.miu.student.service;

import edu.miu.student.domain.Professor;

import java.util.List;
import java.util.Optional;

public interface ProService {
    void save(Professor professor);

    List<Professor> findAll();

    Professor findById(Long proid);
}
