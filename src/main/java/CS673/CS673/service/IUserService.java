package CS673.CS673.service;

import java.util.List;

import CS673.CS673.code.LoginDto;
import CS673.CS673.code.ProfileDto;
import CS673.CS673.code.Search;
import CS673.CS673.code.UserDto;
import CS673.CS673.error.BadPasswordException;
import CS673.CS673.error.EmailExistsException;
import CS673.CS673.error.UserNotExistsException;
import CS673.CS673.persistance.model.User;

public interface IUserService {
	User 		registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
	User 		updateUser(User user, ProfileDto profile);
	User 		getUser(String username);
	UserDto 	createRegistration();
	List<User>	makeSearch(Search search);
}
