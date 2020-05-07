package com.Scope.scopeapi.repository.EnrollmentRepo;

import com.Scope.scopeapi.model.Enrollment;
import com.Scope.scopeapi.repository.CourseRepo.CustomCourseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,String>, CustomEnrollmentRepository {






    // Long deleteBynet_idAndCRN(String net_id, String CRN);
    @Modifying
    @Transactional
    @Query(value ="delete from Enrollment e WHERE e.CRN =:CRN and e.net_id =:NET")
    void deleteEnrollment(@Param("CRN") String CRN,@Param("NET") String netId);
}
