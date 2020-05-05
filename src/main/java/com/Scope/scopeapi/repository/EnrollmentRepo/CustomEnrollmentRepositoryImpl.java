package com.Scope.scopeapi.repository.EnrollmentRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomEnrollmentRepositoryImpl implements CustomEnrollmentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<String[]> findAllEnrollments() {
        Query query = em.createNativeQuery("SELECT * FROM enrollment");
        List<String[]> result = query.getResultList();
        return result;
    }
}
