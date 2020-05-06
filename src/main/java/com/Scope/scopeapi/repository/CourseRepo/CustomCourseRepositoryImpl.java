package com.Scope.scopeapi.repository.CourseRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
    public JSONArray findCourseByNetId(String id) throws JSONException {
        Query query = em.createNativeQuery("SELECT * FROM course c JOIN enrollment WHERE CRN =?");
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



    void createCourse(@Param("CRN") String CRN, @Param("Dept") String dept, @Param("title") String title, @Param("num") String num){
        Query query = em.createNativeQuery("INSERT INTO Course VALUES (:CRN ,:Dept, :title, :num)");
    }


    void updateCourse(@Param("CRN") String CRN, @Param("Dept") String dept,@Param("title") String title,@Param("num") String num){
        Query query = em.createNativeQuery("INSERT INTO Course VALUES (:CRN ,:Dept, :title, :num)");
    }


    void deleteCourse(@Param("CRN") String CRN){
        Query query = em.createNativeQuery("delete from Course  WHERE  CRN==CRN");
    }
}
