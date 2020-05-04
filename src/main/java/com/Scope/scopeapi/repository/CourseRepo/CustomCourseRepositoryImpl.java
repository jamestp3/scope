package com.Scope.scopeapi.repository.CourseRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomCourseRepositoryImpl implements CustomCourseRepository {


    @PersistenceContext
    EntityManager em;


    public List<String[]> findAllCourses(){
        Query query = em.createNativeQuery("SELECT * FROM course");
        List<String[]> result = query.getResultList();
        return result;
    }

    public List<String[]> findCourseByCRN(String id){
        Query query = em.createNativeQuery("SELECT * FROM course WHERE CRN =?");
        query.setParameter(1,id);
        List<String[]> result = query.getResultList();
        return result;
    }
}
