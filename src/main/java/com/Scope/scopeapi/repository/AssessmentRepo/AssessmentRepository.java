package com.Scope.scopeapi.repository.AssessmentRepo;

import com.Scope.scopeapi.model.Assessment;
import org.bson.BSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AssessmentRepository extends MongoRepository<Assessment,String>, CustomAssessmentRepository  {


}

