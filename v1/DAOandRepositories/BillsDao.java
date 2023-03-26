package com.bigbrain.v1.DAOandRepositories;
import com.bigbrain.v1.models.Bills;

import java.util.List;

public interface BillsDao {

    int save(Bills bill);
    int update(Bills bill, int billIDPK);
    List<Bills> findAll();
    List<Bills> findByUserID(int userIDFK);
    int deleteById(int billIDPK);

}
