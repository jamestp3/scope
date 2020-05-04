package com.Scope.scopeapi.repository.CourseRepo;


import com.Scope.scopeapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>, CustomCourseRepository {
}
