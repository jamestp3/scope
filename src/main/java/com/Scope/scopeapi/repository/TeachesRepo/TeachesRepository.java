package com.Scope.scopeapi.repository.TeachesRepo;

import com.Scope.scopeapi.model.Teaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TeachesRepository extends JpaRepository<Teaches,String> , CustomTeachesRepository{



    @Modifying
    @Transactional
    @Query("delete from Teaches e WHERE e.CRN =:CRN and e.net_id =:NET")
    void deleteTeaches(@Param("CRN") String CRN, @Param("NET") String netId);
}
