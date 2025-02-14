package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.DiscapacidadEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface DiscapacidadRepository extends CrudRepository<DiscapacidadEntity, Long> {

    List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity);

}
