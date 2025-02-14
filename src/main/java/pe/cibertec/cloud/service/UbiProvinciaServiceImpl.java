package pe.cibertec.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.cloud.model.entity.UbiProvinciaEntity;
import pe.cibertec.cloud.repository.UbiProvinciaRepository;

import java.util.List;

@Service
@Transactional
public class UbiProvinciaServiceImpl implements UbiProvinciaService {

    @Autowired
    private UbiProvinciaRepository ubiProvinciaRepository;

    @Override
    public List<UbiProvinciaEntity> listAll() {
        return (List<UbiProvinciaEntity>) ubiProvinciaRepository.findAll();
    }

    @Override
    public UbiProvinciaEntity getById(Long id) {
        return ubiProvinciaRepository.findById(id).orElseThrow();
    }

    @Override
    public UbiProvinciaEntity saveOrUpdate(UbiProvinciaEntity entity) {
        return ubiProvinciaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        ubiProvinciaRepository.delete(this.getById(id));
    }

}
