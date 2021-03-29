package DG5.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DG5.com.entity.TechnicalEntity;

public interface TechnicalRepository extends JpaRepository<TechnicalEntity, Long> {

}
