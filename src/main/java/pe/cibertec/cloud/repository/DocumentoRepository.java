package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.DocumentoEntity;

@Repository
public interface DocumentoRepository extends CrudRepository<DocumentoEntity, Long> { }
