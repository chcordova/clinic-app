package pe.cibertec.cloud.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.cibertec.cloud.converter.AntecedenteFamiliarConverter;
import pe.cibertec.cloud.converter.CuidadorConverter;
import pe.cibertec.cloud.converter.DiscapacidadConverter;
import pe.cibertec.cloud.converter.DocumentoConverter;
import pe.cibertec.cloud.converter.EnfermedadConverter;
import pe.cibertec.cloud.converter.IpressConverter;
import pe.cibertec.cloud.converter.MedicoConverter;
import pe.cibertec.cloud.converter.PacienteConverter;
import pe.cibertec.cloud.converter.UbiDistritoConverter;
import pe.cibertec.cloud.model.dto.PacienteDto;
import pe.cibertec.cloud.model.entity.PacienteEntity;
import pe.cibertec.cloud.model.enums.EstadoEnum;
import pe.cibertec.cloud.model.enums.GeneroEnum;
import pe.cibertec.cloud.model.enums.NacionalidadEnum;
import pe.cibertec.cloud.model.enums.PerfilEnum;
import pe.cibertec.cloud.service.AntecedenteFamiliarService;
import pe.cibertec.cloud.service.CuidadorService;
import pe.cibertec.cloud.service.DiscapacidadService;
import pe.cibertec.cloud.service.DocumentoService;
import pe.cibertec.cloud.service.EnfermedadService;
import pe.cibertec.cloud.service.IpressService;
import pe.cibertec.cloud.service.MedicoService;
import pe.cibertec.cloud.service.PacienteService;
import pe.cibertec.cloud.service.UbiDistritoService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter pacienteConverter;

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoConverter medicoConverter;

    @Autowired
    private IpressService ipressService;
    @Autowired
    private IpressConverter ipressConverter;

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private UbiDistritoService ubiDistritoService;
    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;

    @Autowired
    private AntecedenteFamiliarConverter antecedenteFamiliarConverter;
    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;

    @Autowired
    private CuidadorService cuidadorService;
    @Autowired
    private CuidadorConverter cuidadorConverter;

    @Autowired
    private DiscapacidadService discapacidadService;
    @Autowired
    private DiscapacidadConverter discapacidadConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(@RequestParam(value = "search", required = false) String search, Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Búsqueda");

        if (StringUtils.isNotBlank(search)) {

            List<PacienteDto> pacientes = new ArrayList<>();

            PacienteEntity entity = pacienteService.findPacienteEntityByNroDocumento(search);

            if (entity != null) {
                pacientes.add(pacienteConverter.toDto(entity));
            }

            if (pacientes.size() > 0) {
                model.addAttribute("pacientes", pacientes);
                model.addAttribute("success", String.format("Se encontró paciente con el documento nro %s", search));
            } else {
                model.addAttribute("warning", String.format("No se encontró paciente con el documento nro %s", search));
            }

        }

        return "paciente/listar";
    }

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Mostrar");
        model.addAttribute("paciente", pacienteConverter.toDto(pacienteService.getById(id)));
        return "paciente/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("nacionalidadEnum", NacionalidadEnum.values());
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("distritos", ubiDistritoConverter.toListDto(ubiDistritoService.listAll()));
        model.addAttribute("medicos", medicoConverter.toListDto(medicoService.listAll()));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));

        model.addAttribute("paciente", pacienteConverter.toDto(pacienteService.getById(id)));
        return "paciente/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Nuevo");
        model.addAttribute("paciente", PacienteDto.builder()
                .condicion(EstadoEnum.ACTIVO)
                .genero(GeneroEnum.OTRO)
                .documento(documentoConverter.toDto(documentoService.getById(1L)))
                .origenNacionalidad(NacionalidadEnum.NACIONAL)
                .medico(medicoConverter.toDto(medicoService.getById(1L)))
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .perfil(PerfilEnum.PACIENTE)
                .build());

        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("nacionalidadEnum", NacionalidadEnum.values());
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("distritos", ubiDistritoConverter.toListDto(ubiDistritoService.listAll()));
        model.addAttribute("medicos", medicoConverter.toListDto(medicoService.listAll()));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));

        return "paciente/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(PacienteDto dto, Model model) throws Exception {

        PacienteEntity newEntity = pacienteService.saveOrUpdate(pacienteConverter.toEntity(dto));
        List<PacienteDto> entities = new ArrayList<>();

        if (newEntity != null) {
            entities.add(pacienteConverter.toDto(newEntity));
        }

        if (entities.size() > 0) {
            model.addAttribute("pacientes", entities);
            model.addAttribute("success", "El registro de paciente se realizó con éxito.");
        } else {
            model.addAttribute("warning", "Ocurrió un error al registrar el paciente.");
        }

        return "paciente/listar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {
        pacienteService.delete(id);
        return "redirect:/paciente/";
    }

    @RequestMapping(value = "/{id}/enfermedad", method = RequestMethod.GET)
    public String listarEnfermedades(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Búsqueda");

        PacienteEntity entity = pacienteService.getById(id);

        model.addAttribute("paciente", pacienteConverter.toDto(entity));
        model.addAttribute("enfermedades", enfermedadConverter.toListDto(enfermedadService.findEnfermedadEntitiesByPaciente(entity)));

        return "enfermedad/listar";
    }

    @RequestMapping(value = "/{id}/antecedentefamiliar", method = RequestMethod.GET)
    public String listarAntecedentesFamiliares(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Búsqueda");

        PacienteEntity entity = pacienteService.getById(id);
        model.addAttribute("paciente", pacienteConverter.toDto(entity));
        model.addAttribute("antecedentesFamiliares", antecedenteFamiliarConverter.toListDto(antecedenteFamiliarService.findAntecedenteFamiliarEntitiesByPaciente(entity)));

        return "antecedentefamiliar/listar";
    }

    @RequestMapping(value = "/{id}/cuidador", method = RequestMethod.GET)
    public String listarCuidadoreses(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Cuidador");
        model.addAttribute("opcion", "Búsqueda");

        PacienteEntity entity = pacienteService.getById(id);
        model.addAttribute("paciente", pacienteConverter.toDto(entity));
        model.addAttribute("cuidadores", cuidadorConverter.toListDto(cuidadorService.findCuidadorEntitiesByPaciente(entity)));

        return "cuidador/listar";
    }

    @RequestMapping(value = "/{id}/discapacidad", method = RequestMethod.GET)
    public String listarDiscapacidades(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Discapacidad");
        model.addAttribute("opcion", "Búsqueda");

        PacienteEntity entity = pacienteService.getById(id);
        model.addAttribute("paciente", pacienteConverter.toDto(entity));
        model.addAttribute("discapacidades", discapacidadConverter.toListDto(discapacidadService.findDiscapacidadEntitiesByPaciente(entity)));

        return "discapacidad/listar";
    }


}
