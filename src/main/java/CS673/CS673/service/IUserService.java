package CS673.CS673.service;

import CS673.CS673.code.UserDto;
import CS673.CS673.error.EmailExistsException;
import CS673.CS673.persistance.model.User;

public interface IUserService {
	User registerNewUserAccount(UserDto accountDto) throws EmailExistsException;
}
