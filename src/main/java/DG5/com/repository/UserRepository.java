package DG5.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DG5.com.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}
