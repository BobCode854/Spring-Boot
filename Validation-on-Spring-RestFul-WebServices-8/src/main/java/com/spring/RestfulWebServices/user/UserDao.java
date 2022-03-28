package com.spring.RestfulWebServices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> userList = new ArrayList<User>();
	public static int idCount = 3;
	static {
		userList.add(new User(1, "Karan", new Date()));
		userList.add(new User(2, "Karan", new Date()));
		userList.add(new User(3, "Karan", new Date()));
	}

	// save User
	public User save(User user) {
		System.out.println("User obj : " + user);
		if (user.getId() == null) {
			user.setId(++idCount);
		}
		userList.add(user);
		return user;
	}

	// fetch one user
	public User findOne(int id) {
		for (User user : userList) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	// fetch all user
	public List<User> findAll() {
		return userList;
	}

	public User deleteUserById(int id) {

		Iterator<User> itr = userList.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id) {
				itr.remove();
				return user;
			}
		}
		return null;
	}

}
