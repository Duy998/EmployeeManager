package DG5.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DG5.com.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

}
