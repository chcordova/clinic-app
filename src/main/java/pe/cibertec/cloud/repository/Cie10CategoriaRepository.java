package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.Cie10CategoriaEntity;

@Repository
public interface Cie10CategoriaRepository extends CrudRepository<Cie10CategoriaEntity, Long> {
}
