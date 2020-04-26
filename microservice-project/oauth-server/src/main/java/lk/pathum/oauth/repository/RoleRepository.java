package lk.pathum.oauth.repository;

import lk.pathum.oauth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
