package com.Scope.scopeapi.repository.InstructorRepo;

import org.json.JSONArray;
import org.json.JSONException;

public interface CustomInstructorRepository {

    JSONArray findAllInstructors() throws JSONException;
    JSONArray findInstructorByNetId(String id) throws JSONException;
    JSONArray findInstructorClasses(String netid) throws JSONException;
     JSONArray findInstructorCRNs(String netid) throws JSONException;
}
