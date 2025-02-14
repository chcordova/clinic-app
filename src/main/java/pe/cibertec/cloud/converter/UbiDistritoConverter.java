package pe.cibertec.cloud.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.cloud.common.AbstractConverter;
import pe.cibertec.cloud.model.dto.UbiDistritoDto;
import pe.cibertec.cloud.model.entity.UbiDistritoEntity;
import pe.cibertec.cloud.service.UbiDistritoService;

@Component
public class UbiDistritoConverter extends AbstractConverter<UbiDistritoEntity, UbiDistritoDto> {

    @Autowired
    private UbiProvinciaConverter ubiProvinciaConverter;

    @Autowired
    private UbiDistritoService ubiDistritoService;

    @Override
    protected UbiDistritoDto entityToDto(UbiDistritoEntity entity) throws Exception {
        return UbiDistritoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .provincia(ubiProvinciaConverter.toDto(entity.getProvincia()))
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiDistritoEntity dtoToEntity(UbiDistritoDto dto) throws Exception {

        UbiDistritoEntity entity;

        if (dto.getId() == null) {
            entity = new UbiDistritoEntity();
        } else {
            entity = ubiDistritoService.getById(dto.getId());
        }

        return entity;
    }

}
