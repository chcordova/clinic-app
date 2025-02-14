package pe.cibertec.cloud.service;

import pe.cibertec.cloud.model.entity.EnfermedadEntity;
import pe.cibertec.cloud.model.entity.TratamientoEntity;

import java.util.List;

public interface TratamientoService extends CRUDService<TratamientoEntity> {

    List<TratamientoEntity> findTratamientoEntitiesByEnfermedad(EnfermedadEntity entity);

}
