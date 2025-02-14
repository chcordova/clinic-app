package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.MedicoEntity;

@Repository
public interface MedicoRepository extends CrudRepository<MedicoEntity, Long> { }
