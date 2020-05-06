package com.Scope.scopeapi.repository.InstructorRepo;


import com.Scope.scopeapi.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String>, CustomInstructorRepository {




}
