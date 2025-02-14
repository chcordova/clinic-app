package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.CuidadorEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface CuidadorRepository extends CrudRepository<CuidadorEntity, Long> {

/*    @Query("select c from CuidadorEntity c inner join c.pacientes p where p.id =:pacienteId")
    List<CuidadorEntity> findByPacienteId(@Param("pacienteId") Long pacienteId);*/

    List<CuidadorEntity> findCuidadorEntitiesByPaciente(PacienteEntity entity);

}
