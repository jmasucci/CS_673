package CS673.CS673.persistance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import CS673.CS673.persistance.model.User;

//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);
	
	@Query("from User where gender=:gender and city=:city and smokes=:smoking and drinks=:drinking and pets=:pets and age>=:agemin and age<=:agemax and roomprice=:idealroomprice and roommates=:numberofroommates and id!=:connectedid")
	List<User> research(@Param("gender") String gender,
						@Param("city") String city,
						@Param("smoking") String smoking,
						@Param("drinking") String drinking,
						@Param("pets") String pets,
						@Param("agemin") Integer agemin,
						@Param("agemax") Integer agemax,
						@Param("idealroomprice") String idealroomprice,
						@Param("numberofroommates") String numberofroommates,
						@Param("connectedid") Integer connectedid);
	
}
