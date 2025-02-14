package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.EnfermedadEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface EnfermedadRepository extends CrudRepository<EnfermedadEntity, Long> {

    List<EnfermedadEntity> findEnfermedadEntitiesByPaciente(PacienteEntity entity);

}
