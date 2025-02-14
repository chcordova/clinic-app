package pe.cibertec.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.cibertec.cloud.model.entity.PacienteEntity;
import pe.cibertec.cloud.repository.PacienteRepository;

import java.util.List;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<PacienteEntity> listAll() {
        return (List<PacienteEntity>) pacienteRepository.findAll();
    }

    @Override
    public PacienteEntity getById(Long id) {
        return pacienteRepository.findById(id).orElseThrow();
    }

    @Override
    public PacienteEntity saveOrUpdate(PacienteEntity entity) {
        return pacienteRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        pacienteRepository.delete(this.getById(id));
    }

    @Override
    public PacienteEntity findPacienteEntityByNroDocumento(String nroDocuemento) {
        return pacienteRepository.findPacienteEntityByNroDocumento(nroDocuemento);
    }
}
