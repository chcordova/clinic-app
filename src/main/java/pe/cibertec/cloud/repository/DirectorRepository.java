package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.DirectorEntity;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorEntity, Long> { }
