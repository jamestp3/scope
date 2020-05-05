package com.Scope.scopeapi.repository.StudentRepo;

import com.Scope.scopeapi.repository.StudentRepo.CustomStudentRepository;

import javax.persistence.Query;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomStudentRepositoryImpl implements CustomStudentRepository {


    @PersistenceContext
    EntityManager em;


  public List<String[]> findAllStudents(){
    Query query = em.createNativeQuery("SELECT * FROM students");
    List<String[]> result = query.getResultList();
    return result;
  }

   public List<String[]> findStudentByNetId(String id){
      Query query = em.createNativeQuery("SELECT * FROM students WHERE net_id =?");
      query.setParameter(1,id);
      List<String[]> result = query.getResultList();
      return result;
    }


public  List<String[]> findStudentClasses(String netid) {
    Query query = em.createNativeQuery("SELECT c.course_title,c.department,c.course_number,c.crn FROM students s " +
            "join enrollment e on s.net_id = e.net_id " +
            "join course c on c.crn = e.crn "+
            "WHERE s.net_id = ?"
    );
    query.setParameter(1,netid);
    List<String[]> result = query.getResultList();
    return result;
}
}
