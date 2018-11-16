package CS673.CS673.service;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CS673.CS673.code.LoginDto;
import CS673.CS673.code.UserDto;
import CS673.CS673.error.BadPasswordException;
import CS673.CS673.error.EmailExistsException;
import CS673.CS673.error.UserNotExistsException;
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
	
	@Override
	public User logUser(LoginDto user) throws UserNotExistsException, BadPasswordException {
		String email = user.getEmail();
		String password = user.getPassword();
		
		User toConnect = repository.findByEmail(email);
		if (toConnect == null)
		{
			throw new UserNotExistsException("There is no user " + email);
		}
		else
		{
			if (BCrypt.checkpw(email, toConnect.getPassword()))
			{
				return toConnect;
			}
			else
			{
				throw new BadPasswordException("Wrong password");
			}
		}
	}
	
	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
