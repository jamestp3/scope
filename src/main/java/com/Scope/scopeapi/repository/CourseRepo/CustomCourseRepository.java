package com.Scope.scopeapi.repository.CourseRepo;

import java.util.List;
import java.util.Map;

public interface CustomCourseRepository {


    List<Map> findAllCourses();
    List<String[]> findCourseByCRN(String id);

}
