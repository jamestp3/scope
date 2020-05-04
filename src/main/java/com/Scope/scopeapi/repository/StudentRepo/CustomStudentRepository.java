package com.Scope.scopeapi.repository.StudentRepo;

import com.Scope.scopeapi.model.Student;

import java.util.List;

public interface CustomStudentRepository {

    List<String[]> findAllStudents();
    List<String[]> findStudentByNetId(String id);

}
