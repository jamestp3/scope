package com.Scope.scopeapi.repository.InstructorRepo;

import java.util.List;

public interface CustomInstructorRepository {

    List<String[]> findAllInstructors();
    List<String[]> findInstructorByNetId(String id);
}
