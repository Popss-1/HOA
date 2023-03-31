package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Incidents;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class IncidentRepository implements IncidentDao{

    private final JdbcTemplate jdbc;
    public IncidentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int save(Incidents incident) {
        return jdbc.update("INSERT INTO Incidents(category, Description, UserIDFK, ReportedByPhoneNumber, status, Latitude, longitude, Title, IncidentDate, Image) Values(?,?,?,?,?,?,?,?,?,?)",
                incident.getCategory(), incident.getDescription(), incident.getUserIDFK(), incident.getReportedByPhoneNumber(), incident.getStatus(), incident.getLatitude(),
                incident.getLongitude(), incident.getTitle(), incident.getIncidentDate(), incident.getImage());
    }

    @Override
    public List<Incidents> findAll() {
            return jdbc.query("SELECT IncidentIdPK,category, Description, UserIDFK, ReportedByPhoneNumber, status, Latitude, longitude, Title, IncidentDate, Image FROM Incidents ",
                    new BeanPropertyRowMapper<>(Incidents.class));
    }

    @Override
    public List<Incidents> findAllByID(int userIDFK) {

            return jdbc.query("SELECT IncidentIdPK,category, Description, UserIDFK, ReportedByPhoneNumber, Status, Latitude, longitude, Title, IncidentDate, Image FROM Incidents WHERE UserIDFK=?",
                    new BeanPropertyRowMapper<>(Incidents.class), userIDFK);

    }

    @Override
    public List<Incidents> findByDateBetween(Date firstDayOfLastMonth, Date lastDayOfLastMonth) {
            return jdbc.query("SELECT IncidentIdPK, category, Description, UserIDFK, ReportedByPhoneNumber, Status, Latitude, Longitude, Title, IncidentDate, Image FROM Incidents WHERE IncidentDate BETWEEN ? AND ?",
                    new BeanPropertyRowMapper<>(Incidents.class),
                    firstDayOfLastMonth,
                    lastDayOfLastMonth);

    }

    @Override
    public Incidents findIncidentByPK(int incidentIDPK){

            return (Incidents) jdbc.queryForObject("SELECT IncidentIdPK,category, Description, UserIDFK, ReportedByPhoneNumber, Status, Latitude, longitude, Title, IncidentDate, Image FROM Incidents WHERE incidentIDPK=?",new Object[]{incidentIDPK}, new BeanPropertyRowMapper(Incidents.class));

    }

    @Override
    public int deleteById(int incidentIDPK) {
            return jdbc.update("DELETE FROM Incidents WHERE IncidentIdPK=?", incidentIDPK);
    }

    @Override
    public int deleteByStatus(String incidentStatus) {

            return jdbc.update("DELETE FROM Incidents WHERE Status=?");
    }

    @Override
    public int deleteByDate(Date incidentDate) {
            return jdbc.update("DELETE FROM Incidents WHERE IncidentDate=?");

    }

    @Override
    public int updateById(Incidents incident, int incidentIDPK) {

        return jdbc.update("UPDATE Incidents SET Category=?, Description=?, ReportedByPhoneNumber=?, Status=?, Latitude=?, longitude=?, Title=?, Image=? WHERE IncidentIdPK=? ",
                incident.getCategory(),
                incident.getDescription(),
                incident.getReportedByPhoneNumber(),
                incident.getStatus(),
                incident.getLatitude(),
                incident.getLongitude(),
                incident.getTitle(),
                incident.getImage(),
                incidentIDPK);
    }

}
