package com.bigbrain.v1.DAOandRepositories;

import com.bigbrain.v1.models.Payments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository implements PaymentDao {

    private JdbcTemplate jdbc;

    @Autowired
    public PaymentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int save(Payments payment) {
        return jdbc.update("INSERT INTO Payments(billidfk, creditcardnumber, cvv, expirationmonth, expirationyear, useridfk,  AmountPaid) VALUES  (?,?,?,?,?,?,?)",
                payment.getBillIDFK(), payment.getCreditCardNumber(), payment.getCVV(), payment.getExpirationMonth(), payment.getExpirationYear(), payment.getUserIdFk(),  payment.getAmountPaid());
    }
}
