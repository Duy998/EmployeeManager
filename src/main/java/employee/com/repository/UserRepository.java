package employee.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employee.com.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
}
