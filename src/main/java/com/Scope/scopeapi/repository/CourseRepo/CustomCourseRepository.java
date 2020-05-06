package com.Scope.scopeapi.repository.CourseRepo;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public interface CustomCourseRepository {


    JSONArray findAllCourses() throws IOException, JSONException;
    JSONArray findCourseByCRN(String id) throws JSONException;

}
