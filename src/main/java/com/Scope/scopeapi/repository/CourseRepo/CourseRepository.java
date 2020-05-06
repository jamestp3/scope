package com.Scope.scopeapi.repository.CourseRepo;


import com.Scope.scopeapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import java.lang.annotation.Native;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>, CustomCourseRepository {






}
