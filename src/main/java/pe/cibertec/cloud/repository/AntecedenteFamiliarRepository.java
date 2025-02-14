package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface AntecedenteFamiliarRepository extends CrudRepository<AntecedenteFamiliarEntity, Long> {

    List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPaciente(PacienteEntity entity);

}
