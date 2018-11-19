package CS673.CS673.service;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import CS673.CS673.code.LoginDto;
import CS673.CS673.code.ProfileDto;
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
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
		
		// Hash password
		String hashed = encoder.encode(userRegistration.getPassword());
						
		// Create user entity
		User user = new User();
		user.setAge(userRegistration.getAge());
		user.setEmail(userRegistration.getEmail());
		user.setCity(userRegistration.getCity());
		user.setDescription(userRegistration.getDescription());
		user.setDrinks(userRegistration.getDrinks());
		user.setEthnicity(userRegistration.getEthnicity());
		user.setFullname(userRegistration.getFullname());
		user.setGender(userRegistration.getGender());
		user.setPets(userRegistration.getPets());
		user.setPhysical(userRegistration.getPhysical());
		user.setReligion(userRegistration.getReligion());
		user.setRoomprice(userRegistration.getRoomprice());
		user.setSmokes(userRegistration.getSmokes());
		user.setRoommates(userRegistration.getRoommates());
		user.setPassword(hashed);
		
		// Save entity in database
		return repository.save(user);
	}
	
	@Override
	public User updateUser(User user, ProfileDto profile) {
		return null;
	}
	
	@Override
	public UserDto createRegistration() {
		return new UserDto();
	}
	
	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

	@Override
	public User getUser(String username) {
		return repository.findByEmail(username);
	}
}
