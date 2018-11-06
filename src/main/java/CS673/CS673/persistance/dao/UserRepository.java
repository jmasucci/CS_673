package CS673.CS673.persistance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import CS673.CS673.persistance.model.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
}
