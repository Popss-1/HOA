package com.bigbrain.v1.DAOandRepositories;

import java.util.List;

import com.bigbrain.v1.models.Users;

public interface UsersDAO {
	
	int save(Users user);
	
	int update(Users users, int userIDPK);

	
	Users findByEmail(String email);

	Users findById(int userIdPk);

	
	List<Users> findAll();


	List<Users> findAllbYRole(String role);
	List<Users> findAllbYSubscriptionStatus(String subscriptionStatus);

}
