package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Incidents;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
        return jdbc.update("INSERT INTO Incidents(category, Description, UserIDFK, ReportedByPhoneNumber, status, Latitude, longitude, Title, IncidentDate) Values(?,?,?,?,?,?,?,?,?)",
                incident.getCategory(), incident.getDescription(), incident.getUserIDFK(), incident.getReportedByPhoneNumber(), incident.getStatus(), incident.getLatitude(),
                incident.getLongitude(), incident.getTitle(), incident.getIncidentDate());
    }

    @Override
    public List<Incidents> findAll() {
        try{
            return jdbc.query("SELECT IncidentIdPK,category, Description, UserIDFK, ReportedByPhoneNumber, status, Latitude, longitude, Title, IncidentDate FROM Incidents ",
                    new BeanPropertyRowMapper<>(Incidents.class));
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Incidents> findAllByID(int userIDFK) {
        try{
            return jdbc.query("SELECT IncidentIdPK,category, Description, UserIDFK, ReportedByPhoneNumber, Status, Latitude, longitude, Title, IncidentDate FROM Incidents WHERE UserIDFK=?",
                    new BeanPropertyRowMapper<>(Incidents.class), userIDFK);
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return null;
        }
    }

    @Override
    public List<Incidents> findByDateBetween(Date firstDayOfLastMonth, Date lastDayOfLastMonth) {
        try {
            return jdbc.query("SELECT IncidentIdPK, category, Description, UserIDFK, ReportedByPhoneNumber, Status, Latitude, Longitude, Title, IncidentDate FROM Incidents WHERE IncidentDate BETWEEN ? AND ?",
                    new BeanPropertyRowMapper<>(Incidents.class),
                    firstDayOfLastMonth,
                    lastDayOfLastMonth);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (DataAccessException e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public Incidents findIncidentByPK(int incidentIDPK){
        try{
            Incidents incident = (Incidents) jdbc.queryForObject("SELECT IncidentIdPK,category, Description, UserIDFK, ReportedByPhoneNumber, Status, Latitude, longitude, Title, IncidentDate FROM Incidents WHERE incidentIDPK=?",new Object[]{incidentIDPK}, new BeanPropertyRowMapper(Incidents.class));
            return incident;
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return null;
        }
    }

    @Override
    public int deleteById(int incidentIDPK) {
        try{
            return jdbc.update("DELETE FROM Incidents WHERE IncidentIdPK=?", incidentIDPK);
        }
        catch(EmptyResultDataAccessException e){
            return 0;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return 0;
        }
    }

    @Override
    public int deleteByStatus(String incidentStatus) {
        try{
            return jdbc.update("DELETE FROM Incidents WHERE IncidentStatus=?");
        }
        catch(EmptyResultDataAccessException e){
            return 0;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return 0;
        }
    }

    @Override
    public int deleteByDate(Date incidentDate) {
        try{
            return jdbc.update("DELETE FROM Incidents WHERE IncidentDate=?");
        }
        catch(EmptyResultDataAccessException e){
            return 0;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return 0;
        }
    }

    @Override
    public int updateById(Incidents incident, int incidentIDPK) {
        try{
            return jdbc.update("UPDATE Incidents SET IncidentCategory=?, Description=?, ReportedByPhoneNumber=?, IncidentStatus=?, Latitude=?, longitude=?, Title=? WHERE IncidentIdPK=? ",
                    incident.getCategory(),
                    incident.getDescription(),
                    incident.getReportedByPhoneNumber(),
                    incident.getStatus(),
                    incident.getLatitude(),
                    incident.getLongitude(),
                    incident.getTitle(),
                    incidentIDPK);
        }
        catch(EmptyResultDataAccessException e){
            return 0;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return 0;
        }
    }
}
