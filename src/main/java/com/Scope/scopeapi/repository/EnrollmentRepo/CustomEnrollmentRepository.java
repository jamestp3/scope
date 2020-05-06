package com.Scope.scopeapi.repository.EnrollmentRepo;

import org.json.JSONArray;
import org.json.JSONException;

public interface CustomEnrollmentRepository {
    JSONArray findAllEnrollments() throws JSONException;
    }
