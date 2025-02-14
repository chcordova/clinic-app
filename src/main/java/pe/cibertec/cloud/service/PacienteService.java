package pe.cibertec.cloud.service;

import pe.cibertec.cloud.model.entity.PacienteEntity;

public interface PacienteService extends CRUDService<PacienteEntity> {

    PacienteEntity findPacienteEntityByNroDocumento(String nroDocuemento);
}
