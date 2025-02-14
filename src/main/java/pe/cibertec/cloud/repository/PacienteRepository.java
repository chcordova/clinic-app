package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.PacienteEntity;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> {

    PacienteEntity findPacienteEntityByNroDocumento(String nroDocumento);

}
