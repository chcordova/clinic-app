package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.OrphanetEntity;

@Repository
public interface OrphanetRepository extends CrudRepository<OrphanetEntity, Long> {
}
