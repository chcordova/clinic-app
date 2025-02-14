package pe.cibertec.cloud.service;

import pe.cibertec.cloud.model.entity.DiscapacidadEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

public interface DiscapacidadService extends CRUDService<DiscapacidadEntity> {

    List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity);

}
