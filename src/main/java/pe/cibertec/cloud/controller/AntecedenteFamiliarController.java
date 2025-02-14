package pe.cibertec.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.cloud.converter.AntecedenteFamiliarConverter;
import pe.cibertec.cloud.converter.DocumentoConverter;
import pe.cibertec.cloud.converter.PacienteConverter;
import pe.cibertec.cloud.converter.ParentescoConverter;
import pe.cibertec.cloud.model.dto.AntecedenteFamiliarDto;
import pe.cibertec.cloud.model.dto.PacienteDto;
import pe.cibertec.cloud.model.entity.AntecedenteFamiliarEntity;
import pe.cibertec.cloud.model.enums.EstadoEnum;
import pe.cibertec.cloud.model.enums.GeneroEnum;
import pe.cibertec.cloud.model.enums.PerfilEnum;
import pe.cibertec.cloud.service.AntecedenteFamiliarService;
import pe.cibertec.cloud.service.DocumentoService;
import pe.cibertec.cloud.service.PacienteService;
import pe.cibertec.cloud.service.ParentescoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/antecedentefamiliar")
public class AntecedenteFamiliarController {

    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;
    @Autowired
    private AntecedenteFamiliarConverter antecedenteFamiliarConverter;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter pacienteConverter;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private ParentescoService parentescoService;
    @Autowired
    private ParentescoConverter parentescoConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Mostrar");

        model.addAttribute("antecedenteFamiliar", antecedenteFamiliarConverter.toDto(antecedenteFamiliarService.getById(id)));

        return "antecedentefamiliar/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("antecedenteFamiliar", antecedenteFamiliarConverter.toDto(antecedenteFamiliarService.getById(id)));

        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));

        return "antecedentefamiliar/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(@RequestParam(value = "pacienteId") Long pacienteId, Model model) throws Exception {
        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Nuevo");

        PacienteDto pacienteDto = pacienteConverter.toDto(pacienteService.getById(pacienteId));

        model.addAttribute("antecedenteFamiliar", AntecedenteFamiliarDto.builder()
                .condicion(EstadoEnum.ACTIVO)
                .mismaEnfermedad(EstadoEnum.ACTIVO)
                .genero(GeneroEnum.OTRO)
                .documento(documentoConverter.toDto(documentoService.getById(1L)))
                .parentesco(parentescoConverter.toDto(parentescoService.getById(1L)))
                .paciente(pacienteDto)
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .perfil(PerfilEnum.ANTECEDENTE_FAMILIAR)
                .build());

        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));

        return "antecedentefamiliar/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(AntecedenteFamiliarDto dto, Model model) throws Exception {

        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Búsqueda");

        AntecedenteFamiliarEntity newEntity = antecedenteFamiliarService.saveOrUpdate(antecedenteFamiliarConverter.toEntity(dto));

        if(newEntity != null){
            model.addAttribute("paciente", antecedenteFamiliarConverter.toDto(newEntity).getPaciente());
            model.addAttribute("antecedentesFamiliares", antecedenteFamiliarConverter.toListDto(antecedenteFamiliarService.findAntecedenteFamiliarEntitiesByPaciente(newEntity.getPaciente())));
            model.addAttribute("success", "El registro de Antecedente Familiar se realizó con éxito.");
        }else {
            model.addAttribute("warning", "Ocurrió un error al registrar el Antecedente Familiar.");
        }

        return "antecedentefamiliar/listar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        AntecedenteFamiliarEntity entity = antecedenteFamiliarService.getById(id);
        antecedenteFamiliarService.delete(id);

        return String.format("redirect:/paciente/%s/antecedentefamiliar", antecedenteFamiliarConverter.toDto(entity).getPaciente().getId());
    }

}
