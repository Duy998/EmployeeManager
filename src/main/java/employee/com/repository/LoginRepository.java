package employee.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employee.com.entity.UserEntity;

public interface LoginRepository extends JpaRepository<UserEntity, Integer>{
	UserEntity findByEmailAndPassword(String email, String password);
}