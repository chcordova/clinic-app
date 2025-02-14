package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.UbiDepartamentoEntity;

@Repository
public interface UbiDepartamentoRepository extends CrudRepository<UbiDepartamentoEntity, Long> { }
