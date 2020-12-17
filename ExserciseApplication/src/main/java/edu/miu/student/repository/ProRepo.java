package edu.miu.student.repository;


import edu.miu.student.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProRepo extends JpaRepository<Professor, Long>{

  // @Query("select p from Professor p where p.id=:proid")
    //Optional<Professor> findById(String proid);
}
