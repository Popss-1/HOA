package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Bills;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillsRepository implements BillsDao{

    private final JdbcTemplate jdbc;

    public BillsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int save(Bills bill) {
        return jdbc.update(("INSERT INTO Bills(userIDFK, billDate, amountDue) VALUES(?, ?,?)" ),
        bill.getUserIDFK(), bill.getBillDate(), bill.getAmountDue());
    }

    @Override
    public int update(Bills bill, int billIDPK) {
        return jdbc.update(("UPDATE Bills SET userIDFK=?, BillDate=?, AmountDue=? WHERE billIDPK=?" ),
                bill.getUserIDFK(), bill.getBillDate(), bill.getAmountDue(), billIDPK);
    }

    @Override
    public List<Bills> findAll() {
        return jdbc.query(("SELECT billIDPK, userIDFK, billDate, amountDue FROM Bills"),
                new BeanPropertyRowMapper<Bills>(Bills.class));
    }

    @Override
    public List<Bills> findByUserID(int userIDFK) {
        return jdbc.query(("SELECT billIDPK, userIDFK, billDate, amountDue FROM Bills WHERE UserIdFK=?"),
                new BeanPropertyRowMapper<>(Bills.class), userIDFK);
    }

    @Override
    public int deleteById(int billIDPK) {
        return jdbc.update(("DELETE FROM bills WHERE BillIdPK=?"), billIDPK);
    }
}
