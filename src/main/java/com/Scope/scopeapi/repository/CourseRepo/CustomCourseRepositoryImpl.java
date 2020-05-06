package com.Scope.scopeapi.repository.CourseRepo;

import com.fasterxml.jackson.databind.util.JSONPObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomCourseRepositoryImpl implements CustomCourseRepository {


    @PersistenceContext
    EntityManager em;


    public List<Map> findAllCourses(){
        Query query = em.createNativeQuery("SELECT * FROM course");
        List<String[]> result = query.getResultList();

        Map map;
        List<Map> mapList = new ArrayList<Map>();
        for (String[] s: result) {
            map  = new HashMap<>();
        for(int i =0; i<s.length/2;i++){                       //no good :(
            map.put(s[i],s[i+1]);
        }
            mapList.add(map);
        }

        return mapList;
    }

    public List<String[]> findCourseByCRN(String id){
        Query query = em.createNativeQuery("SELECT * FROM course WHERE CRN =?");
        query.setParameter(1,id);
        List<String[]> result = query.getResultList();
        return result;
    }
}
