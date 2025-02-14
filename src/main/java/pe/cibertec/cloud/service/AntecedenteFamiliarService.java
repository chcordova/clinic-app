package pe.cibertec.cloud.service;

import pe.cibertec.cloud.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.cloud.model.entity.PacienteEntity;

import java.util.List;

public interface AntecedenteFamiliarService extends CRUDService<AntecedenteFamiliarEntity> {

    List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPaciente(PacienteEntity entity);

}
