package CS673.CS673.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageDto;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import CS673.CS673.code.LoginDto;
import CS673.CS673.code.ProfileDto;
import CS673.CS673.code.Search;
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
		
		user.setAge(profile.getAge());
		user.setCity(profile.getCity());
		user.setDescription(profile.getDescription());
		user.setDrinks(profile.getDrinks());
		user.setEthnicity(profile.getEthnicity());
		user.setGender(profile.getGender());
		user.setPets(profile.getPets());
		user.setPhysical(profile.getPhysical());
		user.setReligion(profile.getReligion());
		user.setRoomprice(profile.getRoomprice());
		user.setSmokes(profile.getSmokes());
		user.setRoommates(profile.getRoommates());
		return repository.save(user);
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
	public List<User>	makeSearch(Search search)
	{
		int ageMin, ageMax;
		String[] ages = search.getagerange().split("[-]");
		
		if (ages.length == 2)
		{
			ageMin = Integer.parseInt(ages[0]);
			ageMax = Integer.parseInt(ages[1]);
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			User user = getUser(username);
			return repository.research(search.getgender(),
						   			   search.getcity(),
						   			   search.getsmoking(),
						   			   search.getdrinking(),
						   			   search.getpets(),
						   			   ageMin,
						   			   ageMax,
						   			   search.getidealroomprice(),
						   			   search.getnumberofroommates(),
						   			   user.getId());
		}
		
		return null;
	}

	@Override
	public User getUser(String username) {
		return repository.findByEmail(username);
	}
	
	@Override
	public User getUser(Integer id) {
		Optional<User> user = repository.findById(id);
		if (user.isPresent())
			return user.get();
		return null;
	}
}
