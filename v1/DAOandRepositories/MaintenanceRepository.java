package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Incidents;
import com.bigbrain.v1.models.Maintenances;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaintenanceRepository implements MaintenanceDao{

    private JdbcTemplate jdbc;

    @Autowired
    public MaintenanceRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public int updateAvailability(int maintenanceIdPk, Maintenances maintenance) {
        return jdbc.update("UPDATE Maintenances SET Availability = ?",
                maintenance.getAvailability(),
                maintenanceIdPk);
    }

    @Override
    public List<Maintenances> findAll() {
        return jdbc.query("SELECT MaintenanceIdPK, userIdFk, numberOfRequests, availability, firstName FROM Maintenances", new BeanPropertyRowMapper<>(Maintenances.class));
    }

    @Override
    public int getMaintenanceIdPk(int userIdFK) {
        Maintenances maintenance = (Maintenances) jdbc.queryForObject("Select MaintenanceIdPk FROM Maintenances WHERE UserIdFK = ?",
                new Object[]{userIdFK},
                new BeanPropertyRowMapper(Maintenances.class));
        return maintenance.getMaintenanceIdPk();
    }
}
