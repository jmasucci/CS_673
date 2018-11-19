package CS673.CS673.service;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
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
		// Hash password
		String hashed = BCrypt.hashpw(userRegistration.getPassword(), BCrypt.gensalt(12));
						
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
			if (BCrypt.checkpw(password, toConnect.getPassword()))
			{
				return toConnect;
			}
			else
			{
				throw new BadPasswordException("Wrong password");
			}
		}
	}
	
	@Override
	public User updateUser(ProfileDto profile) {
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
}
