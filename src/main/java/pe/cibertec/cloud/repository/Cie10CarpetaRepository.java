package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.Cie10CarpetaEntity;

@Repository
public interface Cie10CarpetaRepository extends CrudRepository<Cie10CarpetaEntity, Long> {
}
