package com.bigbrain.v1.DAOandRepositories;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bigbrain.v1.models.Users;

@Repository
public class UsersRepository implements UsersDAO{
	
//	public UsersRepository(JdbcTemplate jdbc) {
//		this.jdbc = jdbc;
//	}
	/*
	 * @Autowired - Used to make jdbcTemplate obj available to this class
	 * JdbcTemplate - Used to interact with sql server
	 */
	private final JdbcTemplate jdbc;

	public UsersRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public int save(Users user) {
		return jdbc.update("INSERT INTO users (Email, FirstName, LastName, SubscriptionStatus, SubscriptionExpirationDate, Role, PhoneNumber) VALUES(?,?,?,?,?,?,?)",
				user.getEmail(), user.getFirstName(), user.getLastName(), user.getSubscriptionStatus(), user.getSubscriptionExpirationDate(), user.getRole(), user.getPhoneNumber()) ;
	}

	@Override
	public int update(Users user, int userIDPK) {
		return jdbc.update("UPDATE users SET email =?, subscriptionStatus =?, SubscriptionExpirationDate=?, PhoneNumber =? WHERE userIDPK=?",
				new Object[] { user.getEmail(), user.getSubscriptionStatus(), user.getSubscriptionExpirationDate(), user.getPhoneNumber(), userIDPK}) ;
	}



	@Override
	public Users findByEmail(String email) {
		try {
			Users user = (Users) jdbc.queryForObject("SELECT UserIdPK, email, firstName, lastName, phoneNumber, subscriptionstatus, SubscriptionExpirationDate, Role FROM Users WHERE email =?", new Object[]{email}, new BeanPropertyRowMapper(Users.class));
			return user;
		}
		// No user found
		catch(EmptyResultDataAccessException e){
			return null;
		}
		catch(DataAccessException e){
			System.err.println(e);
			return null;
		}
	}

	@Override
	public Users findById(int userIdPk) {
		try {
			Users user = (Users) jdbc.queryForObject("SELECT UserIdPK, email, firstName, lastName, phoneNumber, subscriptionstatus, SubscriptionExpirationDate, Role FROM Users WHERE UserIDPk =?", new Object[]{userIdPk}, new BeanPropertyRowMapper(Users.class));
			return user;
		}
		// No user found
		catch(EmptyResultDataAccessException e){
			return null;
		}
		catch(DataAccessException e){
			System.err.println(e);
			return null;
		}
	}

	@Override
	public List<Users> findAll() {
		try {
			return jdbc.query("SELECT userIDPK, email, firstName, lastName, phoneNumber, subscriptionstatus, SubscriptionExpirationDate, Role FROM Users", new BeanPropertyRowMapper<Users>(Users.class));
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
	public List<Users> findAllbYRole(String role) {
		List<Users> users = jdbc.query("SELECT userIDPK, email, firstName, lastName, phoneNumber, subscriptionstatus, SubscriptionExpirationDate, Role FROM Users WHERE role =?", new BeanPropertyRowMapper<Users>(Users.class));
		return users;
	}

	@Override
	public List<Users> findAllbYSubscriptionStatus(String subscriptionStatus) {
		List<Users> users = jdbc.query("SELECT userIDPK, email, firstName, lastName, phoneNumber, subscriptionstatus, SubscriptionExpirationDate, Role FROM Users WHERE subscriptionStatus =?", new BeanPropertyRowMapper<Users>(Users.class));
		return users;
	}

}
