package pe.cibertec.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.cloud.model.entity.ParentescoEntity;
import pe.cibertec.cloud.repository.ParentescoRepository;

import java.util.List;

@Service
@Transactional
public class ParentescoServiceImpl implements ParentescoService {

    @Autowired
    private ParentescoRepository parentescoRepository;

    @Override
    public List<ParentescoEntity> listAll() {
        return (List<ParentescoEntity>) parentescoRepository.findAll();
    }

    @Override
    public ParentescoEntity getById(Long id) {
        return parentescoRepository.findById(id).orElseThrow();
    }

    @Override
    public ParentescoEntity saveOrUpdate(ParentescoEntity entity) {
        return parentescoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        parentescoRepository.delete(this.getById(id));
    }
}
