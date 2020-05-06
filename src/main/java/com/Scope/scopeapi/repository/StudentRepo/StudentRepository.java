package com.Scope.scopeapi.repository.StudentRepo;


import com.Scope.scopeapi.model.Student;
import com.Scope.scopeapi.repository.StudentRepo.CustomStudentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> ,CustomStudentRepository {





}
