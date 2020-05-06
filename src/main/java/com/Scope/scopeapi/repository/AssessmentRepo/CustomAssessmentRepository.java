package com.Scope.scopeapi.repository.AssessmentRepo;

import com.mongodb.BasicDBObject;
import org.bson.BSONObject;
import org.json.JSONException;

import java.util.List;

public interface CustomAssessmentRepository {

    List<BasicDBObject> findAllAssessments();
    List<BasicDBObject> findAssessmentByClass(String CRN);
    List<BasicDBObject> findAssessmentByNetId(String netId) throws JSONException;

}
