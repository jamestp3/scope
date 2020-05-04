package com.Scope.scopeapi.repository.InstructorRepo;

import com.Scope.scopeapi.repository.CourseRepo.CustomCourseRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomInstructorRepositoryImpl implements CustomInstructorRepository {


    @PersistenceContext
    EntityManager em;


    public List<String[]> findAllInstructors(){
        Query query = em.createNativeQuery("SELECT * FROM instructors");
        List<String[]> result = query.getResultList();
        return result;
    }
    public List<String[]> findInstructorByNetId(String id){
        Query query = em.createNativeQuery("SELECT * FROM instructors WHERE net_id = ?");
        query.setParameter(1,id);
        List<String[]> result = query.getResultList();
        return result;
    }

}
