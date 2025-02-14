package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.UbiProvinciaEntity;

@Repository
public interface UbiProvinciaRepository extends CrudRepository<UbiProvinciaEntity, Long> {
}
