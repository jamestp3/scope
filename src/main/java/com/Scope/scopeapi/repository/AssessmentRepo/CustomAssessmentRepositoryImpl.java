package com.Scope.scopeapi.repository.AssessmentRepo;

import com.mongodb.BasicDBObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class CustomAssessmentRepositoryImpl implements CustomAssessmentRepository{

    @Autowired
    MongoTemplate mongoTemplate;


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
        System.out.println(result);

        for(BasicDBObject b: result){
            b.remove("_id");
        }
        return result;
    }

}
