package com.Scope.scopeapi.repository.StudentRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.Query;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {


    @PersistenceContext
    EntityManager em;


  public JSONArray findAllStudents() throws JSONException {
    Query query = em.createNativeQuery("SELECT * FROM students");

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

   public JSONArray findStudentByNetId(String id) throws JSONException {
      Query query = em.createNativeQuery("SELECT * FROM students WHERE net_id =?");
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


public JSONArray findStudentClasses(String netid) throws JSONException {
    Query query = em.createNativeQuery("SELECT c.course_title,c.department,c.course_number,c.crn FROM students s " +
            "join enrollment e on s.net_id = e.net_id " +
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

    public JSONArray findStudentCRNs(String netid) throws JSONException {
        Query query = em.createNativeQuery("SELECT e.crn FROM students s " +
                "join enrollment e on s.net_id = e.net_id " +
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

}
