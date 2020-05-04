package com.Scope.scopeapi.repository.InstructorRepo;


import com.Scope.scopeapi.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String>, CustomInstructorRepository {
}
