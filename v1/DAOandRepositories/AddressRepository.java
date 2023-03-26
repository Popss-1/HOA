package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Addresses;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressRepository implements  AddressDao{

    private final JdbcTemplate jdbc;

    public AddressRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    @Override
    public int save(Addresses address) {
       return jdbc.update(("INSERT INTO Addresses(UserIDFK, AddressLine1, AddressLine2, City, StateCode, ZipCode) VALUES (?, ?, ?, ?, ?, ?)"),
               address.getUserIDFK(), address.getAddressLine1(), address.getAddressLine2(), address.getCity(), address.getStateCode(), address.getZipCode());
    }

    @Override
    public int update(Addresses address, int userIDFK) {
        return jdbc.update("UPDATE Addresses SET AddressLine1 =?, AddressLine2 =?, City=?, StateCode =?, ZipCode=? WHERE userIdFK=?",
                address.getAddressLine1(), address.getAddressLine2(), address.getCity(), address.getStateCode(), address.getZipCode(), userIDFK) ;
    }

    @Override
    public List<Addresses> findAll() {
        return jdbc.query(("SELECT UserIDFK, AddressIDPK, AddressLine1, AddressLine2, City, StateCode, ZipCode FROM Addresses"),
                new BeanPropertyRowMapper<Addresses>(Addresses.class));
    }

    @Override
    public Addresses findByUserID(int userIDFK){
        try{
            return (Addresses) jdbc.queryForObject("SELECT UserIDFK, AddressIDPK, AddressLine1, AddressLine2, City, StateCode, ZipCode FROM Addresses WHERE UserIdFK=?",
                    new Object[]{userIDFK},
                    new BeanPropertyRowMapper(Addresses.class));
        }
        catch(EmptyResultDataAccessException e){
            return null;
        }
        catch(DataAccessException e){
            System.err.println(e);
            return null;
        }
    }
}
