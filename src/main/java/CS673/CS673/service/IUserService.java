package CS673.CS673.service;

import CS673.CS673.code.LoginDto;
import CS673.CS673.code.ProfileDto;
import CS673.CS673.code.UserDto;
import CS673.CS673.error.BadPasswordException;
import CS673.CS673.error.EmailExistsException;
import CS673.CS673.error.UserNotExistsException;
import CS673.CS673.persistance.model.User;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
	User logUser(LoginDto user) throws UserNotExistsException, BadPasswordException;
	User updateUser(ProfileDto profile);
}
