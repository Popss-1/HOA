package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Requests;

import java.util.List;

public interface RequestDao {

    int save(Requests request);
    int update(Requests request, int requestIdPK);

    Requests findById(int requestUserIdFk);
    int deleteById(int requestIdPK);

    List<Requests> findAllByUserIdFk(int requestUserIdFk);
    List<Requests> findAll();
    List<Requests> findAllByMaintenanceIdFk(int maintenanceIdFK);


}
