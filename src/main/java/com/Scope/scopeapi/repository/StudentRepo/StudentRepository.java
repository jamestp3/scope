package com.Scope.scopeapi.repository.StudentRepo;


import com.Scope.scopeapi.model.Student;
import com.Scope.scopeapi.repository.StudentRepo.CustomStudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> ,CustomStudentRepository {

}
