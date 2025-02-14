package pe.cibertec.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.cloud.model.entity.Cie10CarpetaEntity;
import pe.cibertec.cloud.repository.Cie10CarpetaRepository;

import java.util.List;

@Service
@Transactional
public class Cie10CarpetaServiceImpl implements Cie10CarpetaService {

    @Autowired
    private Cie10CarpetaRepository cie10CarpetaRepository;

    @Override
    public List<Cie10CarpetaEntity> listAll() {
        return (List<Cie10CarpetaEntity>) cie10CarpetaRepository.findAll();
    }

    @Override
    public Cie10CarpetaEntity getById(Long id) {
        return cie10CarpetaRepository.findById(id).orElseThrow();
    }

    @Override
    public Cie10CarpetaEntity saveOrUpdate(Cie10CarpetaEntity entity) {
        return cie10CarpetaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cie10CarpetaRepository.delete(this.getById(id));
    }
}
