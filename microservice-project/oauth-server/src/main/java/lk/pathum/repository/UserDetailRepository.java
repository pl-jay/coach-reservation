package lk.pathum.repository;


import lk.pathum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<User,Integer> {
    User findByUsername(String name);
}
