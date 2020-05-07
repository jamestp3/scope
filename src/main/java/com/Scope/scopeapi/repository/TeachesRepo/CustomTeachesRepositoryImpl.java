package com.Scope.scopeapi.repository.TeachesRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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


    void createTeaches(@Param("CRN") String CRN, @Param("NET") String netId){
        Query query =em.createNativeQuery("INSERT INTO Teaches VALUES (=:CRN ,=:NET)");
    }


    void updateTeaches(@Param("CRN") String CRN, @Param("NET") String netId){
        Query query =em.createNativeQuery("UPDATE Teachers SET net_id = :NET, CRN = :CNR");
    }


    void deleteTeaches(@Param("CRN") String CRN, @Param("NET") String netId){
        Query query =em.createNativeQuery("delete from Teaches e WHERE e.CRN =:CRN and e.net_id =:NET");
    }


}
