package com.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.join.model.User;
import com.join.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean isNewUserExists(String email) {
		return userRepository.findOneByEmail(email) != null;
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public String activateUser(Long id, String configurationId) {
		User user = userRepository.findOneById(id);
		if (user == null)
			return "Activation link expired, you should register again";
		if (user.isActivated() == true)
			return "You already activated account";
		if (!configurationId.equals(user.getConfigurationId()))
			return "You have wrong link";
		user.setActivated(true);
		userRepository.save(user);
		return "Gratulations! You activated account successfully " + user.isActivated();

	}

}
