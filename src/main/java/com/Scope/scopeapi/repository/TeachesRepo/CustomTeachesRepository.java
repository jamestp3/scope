package com.Scope.scopeapi.repository.TeachesRepo;

import org.json.JSONArray;
import org.json.JSONException;

public interface CustomTeachesRepository {
    JSONArray findAllTeaches() throws JSONException;
}
