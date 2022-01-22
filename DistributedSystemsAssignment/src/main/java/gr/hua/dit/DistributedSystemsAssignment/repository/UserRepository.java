package gr.hua.dit.DistributedSystemsAssignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import gr.hua.dit.DistributedSystemsAssignment.entity.User;


@RepositoryRestResource(path="users")
public interface UserRepository extends JpaRepository<User,Integer> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);
	
	User findByUsername(String username);
	
}
