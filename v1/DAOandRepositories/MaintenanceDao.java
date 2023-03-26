package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Maintenances;

import java.util.List;

public interface MaintenanceDao {

    int updateAvailability(int maintenanceIdPk, Maintenances maintenance);
    List<Maintenances> findAll();

    int getMaintenanceIdPk(int userIdFK);

}
