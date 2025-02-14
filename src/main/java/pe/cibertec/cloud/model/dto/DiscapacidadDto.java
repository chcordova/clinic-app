package pe.cibertec.cloud.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.cibertec.cloud.model.enums.EstadoEnum;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscapacidadDto implements Serializable {


    private Long id;
    private EstadoEnum limitacionFuncional;
    private String detallelimitacionfuncional;
    private EstadoEnum inscritoConadis;
    private String detalleObservaciones;
    private PacienteDto paciente;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}
