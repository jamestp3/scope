package com.Scope.scopeapi.repository.AssessmentRepo;

import com.mongodb.BasicDBObject;
import org.bson.BSONObject;

import java.util.List;

public interface CustomAssessmentRepository {

    List<BasicDBObject> findAllAssessments();
    List<BasicDBObject> findAssessmentByClass(String CRN);

}
