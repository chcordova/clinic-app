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
public class IpressDto implements Serializable {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private UbiDistritoDto distrito;
    private String telefono;
    private String ruc;

    private EstadoEnum estado;
    private String fecRegistro;
    private String fecModificacion;

}
