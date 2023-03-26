package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Addresses;

import java.util.List;

public interface AddressDao {

    int save(Addresses address);

    int update(Addresses address, int userIDFK);
    List<Addresses> findAll();
    Addresses findByUserID(int userIDFK);

}
