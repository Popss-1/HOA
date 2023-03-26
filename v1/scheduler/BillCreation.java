package com.bigbrain.v1.scheduler;

import com.bigbrain.v1.models.Bills;
import com.bigbrain.v1.models.Users;
import com.bigbrain.v1.DAOandRepositories.BillsRepository;
import com.bigbrain.v1.DAOandRepositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class BillCreation {

    private BillsRepository billsRepository;

    private UsersRepository usersRepository;

    @Autowired
    public BillCreation(BillsRepository billsRepository, UsersRepository usersRepository) {
        this.billsRepository = billsRepository;
        this.usersRepository = usersRepository;
    }

    // runs at midnight on the 21st of every month and create a bill for every valid user
    @Scheduled(cron = "0 0 0 21 * ?")
    public void billCreationTask() {
        // code to be executed on the 21st of every month
        List<Users>billableUsers = usersRepository.findAllbYSubscriptionStatus("Valid");
        LocalDate localDate = LocalDate.now();
        Date dateNow = Date.valueOf(localDate);
        for ( Users user : billableUsers){
            // only generate bills for users that have been a user for >= 1 month
            if ( dateNow.getMonth() - user.getRegistrationDate().getMonth() >= 1 ) {
                Bills bill = new Bills(user.getUserIdPK(), Date.valueOf(localDate.plusDays(7)), 100);
                billsRepository.save(bill);
                user.setSubscriptionStatus(Users.SubscriptionStatues.Expired.toString());
                usersRepository.update(user, user.getUserIdPK());
            }
        }
    }


}
