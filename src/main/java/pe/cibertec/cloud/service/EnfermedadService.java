package pe.cibertec.cloud.service;

import pe.cibertec.cloud.model.entity.EnfermedadEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

public interface EnfermedadService extends CRUDService<EnfermedadEntity> {

    List<EnfermedadEntity> findEnfermedadEntitiesByPaciente(PacienteEntity entity);

}
