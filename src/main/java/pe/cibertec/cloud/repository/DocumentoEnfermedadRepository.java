package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.DocumentoEnfermedadEntity;

@Repository
public interface DocumentoEnfermedadRepository extends CrudRepository<DocumentoEnfermedadEntity, Long> { }
