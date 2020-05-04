package com.Scope.scopeapi.repository.CourseRepo;

import java.util.List;

public interface CustomCourseRepository {


    List<String[]> findAllCourses();
    List<String[]> findCourseByCRN(String id);

}
