package employee.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import employee.com.entity.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

	PositionEntity findByName(String name);

}
