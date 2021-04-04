package employee.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employee.com.entity.UserEntity;
import employee.com.repository.custom.UserRepositoryCustom;

public interface UserRepository extends JpaRepository<UserEntity, Long>,UserRepositoryCustom{
	UserEntity findByEmail(String email);
}
