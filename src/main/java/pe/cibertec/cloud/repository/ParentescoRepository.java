package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.ParentescoEntity;

@Repository
public interface ParentescoRepository extends CrudRepository<ParentescoEntity, Long> {
}
