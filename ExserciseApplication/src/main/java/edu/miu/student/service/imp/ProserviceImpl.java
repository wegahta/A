package edu.miu.student.service.imp;

//import edu.miu.student.service.ProService;

import edu.miu.student.domain.Professor;
import edu.miu.student.repository.ProRepo;
import edu.miu.student.service.ProService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProserviceImpl implements ProService {
    @Autowired
    ProRepo proRepo;
    @Override
    public void save(Professor professor) {
        proRepo.save(professor);

    }

    @Override
    public List<Professor> findAll() {
        return proRepo.findAll();
    }

    @Override
    public Professor findById(Long proid) {
        return proRepo.findById(proid).orElse(null);
    }
}
