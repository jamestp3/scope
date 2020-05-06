package com.Scope.scopeapi.repository.InstructorRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomInstructorRepositoryImpl implements CustomInstructorRepository {


    @PersistenceContext
    EntityManager em;


    public JSONArray findAllInstructors() throws JSONException {
        Query query = em.createNativeQuery("SELECT * FROM instructors");
        List<Object[]> list = query.getResultList();


        JSONArray json_arr=new JSONArray();
        for(Object[] s: list){
            JSONObject json_obj = new JSONObject();
            json_obj.put("NetID",(String) s[0]);
            json_obj.put("FirstName",(String) s[1]);
            json_obj.put("LastName",(String) s[2]);
            json_arr.put(json_obj);
        }
        return json_arr;
    }
    public JSONArray findInstructorByNetId(String id) throws JSONException {
        Query query = em.createNativeQuery("SELECT * FROM instructors WHERE net_id = ?");
        query.setParameter(1,id);
        List<Object[]> list = query.getResultList();


        JSONArray json_arr=new JSONArray();
        for(Object[] s: list){
            JSONObject json_obj = new JSONObject();
            json_obj.put("NetID",(String) s[0]);
            json_obj.put("FirstName",(String) s[1]);
            json_obj.put("LastName",(String) s[2]);
            json_arr.put(json_obj);
        }
        return json_arr;
    }


    public JSONArray findInstructorClasses(String netid) throws JSONException {
        Query query = em.createNativeQuery("SELECT c.course_title,c.department,c.course_number,c.crn FROM instructors s " +
                "join teaches e on s.net_id = e.net_id " +
                "join course c on c.crn = e.crn "+
                "WHERE s.net_id = ?"
        );
        query.setParameter(1,netid);
        List<Object[]> list = query.getResultList();


        JSONArray json_arr=new JSONArray();
        for(Object[] s: list){
            JSONObject json_obj = new JSONObject();
            json_obj.put("CourseTitle",(String) s[0]);
            json_obj.put("Department",(String) s[1]);
            json_obj.put("CourseNumber",(String) s[2]);
            json_obj.put("CRN",(String) s[3]);
            json_arr.put(json_obj);
        }
        return json_arr;
    }

    public JSONArray findInstructorCRNs(String netid) throws JSONException {
        Query query = em.createNativeQuery("SELECT e.crn FROM instructors s " +
                "join teaches e on s.net_id = e.net_id " +
                "WHERE s.net_id = ?"
        );
        query.setParameter(1,netid);
        List<String> list = query.getResultList();


        JSONArray json_arr=new JSONArray();
        for(String s: list){
            JSONObject json_obj = new JSONObject();

            json_obj.put("CRN",(String) s);//[0]);
            json_arr.put(json_obj);
        }
        return json_arr;
    }



    void createInstructors(@Param("FirstName") String FirstName, @Param("LastName") String LastName, @Param("NET") String netId){
        Query query = em.createNativeQuery("INSERT INTO Instructors VALUES (:NET,:FirstName,:LastName)");
    }

    void updateInstructors(@Param("FirstName") String FirstName,@Param("LastName") String LastName, @Param("NET") String netId){
        Query query = em.createNativeQuery("UPDATE Instructor SET net_id = :NET, LastName = :LastName, FirstName=:FirstName");
    }


    void deleteInstructors(@Param("NET") String netId){
        Query query = em.createNativeQuery("delete from Instructor e WHERE net_id=:NET");
    }

}
