package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.UbiDistritoEntity;

@Repository
public interface UbiDistritoRepository extends CrudRepository<UbiDistritoEntity, Long> { }
