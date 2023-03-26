package com.bigbrain.v1.DAOandRepositories;
import java.util.Date;
import java.util.List;
import com.bigbrain.v1.models.Incidents;

public interface IncidentDao {

    int save(Incidents incident);

    List<Incidents>findAll();

    List<Incidents>findAllByID(int userIDFK);
    List<Incidents>findByDateBetween(Date firstDayOfLastMonth,  Date lastDayOfLastMonth);

    Incidents findIncidentByPK(int incidentIDPK);

    int deleteById(int incidentIDPK);

    int deleteByStatus(String incidentStatus);

    int deleteByDate(Date incidentDate);

    int updateById(Incidents incident, int incidentIDPK);



}
