package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.EnfermedadEntity;
import pe.cibertec.cloud.model.entity.TratamientoEntity;

import java.util.List;

@Repository
public interface TratamientoRepository extends CrudRepository<TratamientoEntity, Long> {

    List<TratamientoEntity> findTratamientoEntitiesByEnfermedad(EnfermedadEntity entity);

}
