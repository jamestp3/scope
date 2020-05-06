package com.Scope.scopeapi.repository.TeachesRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomTeachesRepositoryImpl implements CustomTeachesRepository {



    @PersistenceContext
    EntityManager em;

    public JSONArray findAllTeaches() throws JSONException {
        Query query = em.createNativeQuery("SELECT * FROM teaches");
        List<Object[]> list = query.getResultList();


        JSONArray json_arr=new JSONArray();
        for(Object[] s: list){
            JSONObject json_obj = new JSONObject();
            json_obj.put("NetId",(String) s[0]);
            json_obj.put("CRN",(String) s[1]);

            json_arr.put(json_obj);
        }
        return json_arr;
    }
}
