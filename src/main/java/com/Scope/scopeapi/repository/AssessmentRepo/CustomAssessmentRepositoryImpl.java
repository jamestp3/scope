package com.Scope.scopeapi.repository.AssessmentRepo;

import com.Scope.scopeapi.repository.InstructorRepo.InstructorRepository;
import com.Scope.scopeapi.repository.StudentRepo.StudentRepository;
import com.mongodb.BasicDBObject;

import com.mongodb.util.JSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomAssessmentRepositoryImpl implements CustomAssessmentRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InstructorRepository instructorRepository;

    public List<BasicDBObject> findAllAssessments(){
    List<BasicDBObject> result = mongoTemplate.findAll(BasicDBObject.class,"assessments");
    System.out.println(result);
        for(BasicDBObject b: result){
            b.remove("_id");
        }
    return result;
    }

    public List<BasicDBObject> findAssessmentByClass(String CRN){
        Query query = new Query();
        query.addCriteria(Criteria.where("CRN").is(CRN));


        List<BasicDBObject> result = mongoTemplate.find(query,BasicDBObject.class,"assessments");
  //      System.out.println(result);

        for(BasicDBObject b: result){
            b.remove("_id");
        }
        return result;
    }

    public List<BasicDBObject> findAssessmentByNetId(String netId) throws JSONException {
        JSONArray crnJSON = studentRepository.findStudentCRNs(netId);

        List<String> crns=  new ArrayList<String>();
        for (int i =0; i< crnJSON.length(); i++){
            JSONObject objectInArray = crnJSON.getJSONObject(i);
            crns.add(objectInArray.getString("CRN"));
        }

        List<BasicDBObject> result =new ArrayList<>();
        for (String s: crns) {
            Query query = new Query();
            query.addCriteria(Criteria.where("CRN").is(s));


            result.addAll( mongoTemplate.find(query,BasicDBObject.class,"assessments"));
            //  System.out.println(result);


        }
        for(BasicDBObject b: result){
            b.remove("_id");
        }
        //  System.out.println(crns);
        return result;
    }


    public List<BasicDBObject> findAssessmentByInstructorNetId(String netId) throws JSONException {
        JSONArray crnJSON = instructorRepository.findInstructorCRNs(netId);

        List<String> crns=  new ArrayList<String>();
        for (int i =0; i< crnJSON.length(); i++){
            JSONObject objectInArray = crnJSON.getJSONObject(i);
            crns.add(objectInArray.getString("CRN"));
        }

        List<BasicDBObject> result =new ArrayList<>();
        for (String s: crns) {
            Query query = new Query();
            query.addCriteria(Criteria.where("CRN").is(s));


            result.addAll( mongoTemplate.find(query,BasicDBObject.class,"assessments"));
            //  System.out.println(result);


        }
        for(BasicDBObject b: result){
            b.remove("_id");
        }
        //  System.out.println(crns);
        return result;
    }


    public void insertAssessment(BasicDBObject dbObject){
        mongoTemplate.save(dbObject, "assessments");
    }
}
