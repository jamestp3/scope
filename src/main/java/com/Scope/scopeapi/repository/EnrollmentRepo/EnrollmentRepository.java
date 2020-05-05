package com.Scope.scopeapi.repository.EnrollmentRepo;

import com.Scope.scopeapi.model.Enrollment;
import com.Scope.scopeapi.repository.CourseRepo.CustomCourseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,String>, CustomEnrollmentRepository {
}
