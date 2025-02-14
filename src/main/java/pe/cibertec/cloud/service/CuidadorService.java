package pe.cibertec.cloud.service;

import pe.cibertec.cloud.model.entity.CuidadorEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

public interface CuidadorService extends CRUDService<CuidadorEntity> {

    List<CuidadorEntity> findCuidadorEntitiesByPaciente(PacienteEntity entity);

}
