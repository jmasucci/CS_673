package CS673.CS673.service;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CS673.CS673.code.UserDto;
import CS673.CS673.error.EmailExistsException;
import CS673.CS673.persistance.dao.UserRepository;
import CS673.CS673.persistance.model.User;

@Service
@Transactional
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public User registerNewUserAccount(UserDto userRegistration) throws EmailExistsException {
		if (emailExist(userRegistration.getEmail())) {
			throw new EmailExistsException(
					"There is an account with that email adress: "
					+ userRegistration.getEmail());
		}
		// Hash password
		String hashed = BCrypt.hashpw(userRegistration.getPassword(), BCrypt.gensalt(12));
						
		// Create user entity
		User user = new User();
		user.setAge(userRegistration.getAge());
		user.setEmail(userRegistration.getEmail());
		user.setFirstName(userRegistration.getFirstName());
		user.setLastName(userRegistration.getLastName());
		user.setPassword(hashed);
				
		// Save entity in database
		return repository.save(user);
	}
	
	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
