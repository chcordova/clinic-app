package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.Cie10BloqueEntity;

@Repository
public interface Cie10BloqueRepository extends CrudRepository<Cie10BloqueEntity, Long> {
}
