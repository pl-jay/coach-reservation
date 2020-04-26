package lk.pathum.oauth.repository;


import lk.pathum.oauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//import javax.jws.soap.SOAPBinding;


public interface UserDetailRepository extends JpaRepository<User,Integer> {
    User findByUsername(String name);
}
