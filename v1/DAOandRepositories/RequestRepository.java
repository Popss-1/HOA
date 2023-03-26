package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Requests;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepository implements RequestDao{

    private final JdbcTemplate jdbc;

    public RequestRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int save(Requests request) {
        return jdbc.update("INSERT INTO Requests(requestuseridfk, title, description, priority, status, addressidfk, maintenanceIdFK) VALUES (?,?,?,?,?,?,?)",
                request.getRequestUserIDFK(),
                request.getTitle(),
                request.getDescription(),
                request.getPriority(),
                request.getStatus(),
                request.getAddressIDFK(),
                request.getMaintenanceIdFK());
    }

    @Override
    public int update(Requests request, int requestIdPK) {
        try{
            return jdbc.update("UPDATE Requests SET title=?, Description=?, priority=?, status=?, maintenanceIdFK=? WHERE requestIdPK=? ",
                    request.getTitle(),
                    request.getDescription(),
                    request.getPriority(),
                    request.getStatus(),
                    request.getMaintenanceIdFK(),
                    requestIdPK);
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
    public Requests findById(int requestIDPK){
        try{
            return (Requests)jdbc.queryForObject("SELECT RequestIdPK, RequestUserIdFK, title, Description, priority, status, requestdate, AddressIdFK, maintenanceIdFK FROM Requests WHERE requestIDPK=?", new Object[]{requestIDPK},
                    new BeanPropertyRowMapper(Requests.class));
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
    public int deleteById(int requestIdPK) {
        try{
            return jdbc.update("DELETE FROM Requests WHERE requestIdPK=?", requestIdPK);
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
    public List<Requests> findAllByUserIdFk(int requestUserIdFk) {
        try{
            return jdbc.query("SELECT RequestIdPK, RequestUserIdFK, title, Description, priority, status, requestdate, AddressIdFK, maintenanceIdFK FROM Requests WHERE RequestUserIdFK=?",
                    new BeanPropertyRowMapper<>(Requests.class), requestUserIdFk);
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
    public List<Requests> findAll() {
        return jdbc.query("SELECT * FROM Requests", new BeanPropertyRowMapper<>(Requests.class));
    }

    @Override
    public List<Requests> findAllByMaintenanceIdFk(int maintenanceIdFK) {
        return jdbc.query("SELECT RequestIdPK, RequestUserIdFK, title, Description, priority, status, requestdate, AddressIdFK, maintenanceIdFK FROM Requests WHERE maintenanceIdFK=?",
                new BeanPropertyRowMapper<>(Requests.class),
                maintenanceIdFK);
    }
}
