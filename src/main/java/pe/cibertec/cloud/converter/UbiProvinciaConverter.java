package pe.cibertec.cloud.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.cloud.common.AbstractConverter;
import pe.cibertec.cloud.model.dto.UbiProvinciaDto;
import pe.cibertec.cloud.model.entity.UbiProvinciaEntity;
import pe.cibertec.cloud.service.UbiProvinciaService;

@Component
public class UbiProvinciaConverter extends AbstractConverter<UbiProvinciaEntity, UbiProvinciaDto> {

    @Autowired
    private UbiDepartamentoConverter ubiDepartamentoConverter;

    @Autowired
    private UbiProvinciaService ubiProvinciaService;

    @Override
    protected UbiProvinciaDto entityToDto(UbiProvinciaEntity entity) throws Exception {
        return UbiProvinciaDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .departamento(ubiDepartamentoConverter.toDto(entity.getDepartamento()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiProvinciaEntity dtoToEntity(UbiProvinciaDto dto) throws Exception {

        UbiProvinciaEntity entity;

        if (dto.getId() == null) {
            entity = new UbiProvinciaEntity();
        } else {
            entity = ubiProvinciaService.getById(dto.getId());
        }

        return entity;
    }

}
