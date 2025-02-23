package pe.cibertec.cloud.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbiProvinciaDto implements Serializable {

    private Long id;
    private String nombre;
    private UbiDepartamentoDto departamento;
    private String codigo;

}
