package pe.cibertec.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.cloud.model.entity.IpressEntity;

@Repository
public interface IpressRepository extends CrudRepository<IpressEntity, Long> { }
