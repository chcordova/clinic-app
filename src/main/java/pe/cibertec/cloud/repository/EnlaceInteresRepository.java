package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.EnlaceInteresEntity;

@Repository
public interface EnlaceInteresRepository extends CrudRepository<EnlaceInteresEntity, Long> { }
