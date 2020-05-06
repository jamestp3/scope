package com.Scope.scopeapi.repository.StudentRepo;

import org.json.JSONArray;
import org.json.JSONException;

public interface CustomStudentRepository {

    JSONArray findAllStudents() throws JSONException;
    JSONArray findStudentByNetId(String id) throws JSONException;
    JSONArray findStudentClasses(String netId) throws JSONException;
}
