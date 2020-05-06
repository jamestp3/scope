package com.Scope.scopeapi.repository.CourseRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;


public class CustomCourseRepositoryImpl implements CustomCourseRepository {


    @PersistenceContext
    EntityManager em;


    public JSONArray findAllCourses() throws IOException, JSONException {
        List<Object[]> list= em.createNativeQuery("SELECT * FROM course").getResultList();

        JSONArray json_arr=new JSONArray();
        for(Object[] s: list){
            JSONObject json_obj = new JSONObject();
            json_obj.put("CRN",(String) s[0]);
            json_obj.put("Department",(String) s[1]);
            json_obj.put("Course_Title",(String) s[2]);
            json_obj.put("Course_Number",(String) s[3]);
            json_arr.put(json_obj);
        }
        return json_arr;
    }

    public JSONArray findCourseByCRN(String id) throws JSONException {
        Query query = em.createNativeQuery("SELECT * FROM course WHERE CRN =?");
        query.setParameter(1,id);
        List<Object[]> list = query.getResultList();


        JSONArray json_arr=new JSONArray();
        for(Object[] s: list){
            JSONObject json_obj = new JSONObject();
            json_obj.put("CRN",(String) s[0]);
            json_obj.put("Department",(String) s[1]);
            json_obj.put("Course_Title",(String) s[2]);
            json_obj.put("Course_Number",(String) s[3]);
            json_arr.put(json_obj);
        }
        return json_arr;
    }
}
