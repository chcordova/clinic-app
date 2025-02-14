package pe.cibertec.cloud.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.cibertec.cloud.common.AbstractConverter;
import pe.cibertec.cloud.model.dto.UbiDepartamentoDto;
import pe.cibertec.cloud.model.entity.UbiDepartamentoEntity;
import pe.cibertec.cloud.service.UbiDepartamentoService;

@Component
public class UbiDepartamentoConverter extends AbstractConverter<UbiDepartamentoEntity, UbiDepartamentoDto> {

    @Autowired
    private UbiDepartamentoService ubiDepartamentoService;

    @Override
    protected UbiDepartamentoDto entityToDto(UbiDepartamentoEntity entity) throws Exception {
        return UbiDepartamentoDto.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .codigo(entity.getCodigo())
                .build();
    }

    @Override
    protected UbiDepartamentoEntity dtoToEntity(UbiDepartamentoDto dto) throws Exception {

        UbiDepartamentoEntity entity;

        if (dto.getId() == null) {
            entity = new UbiDepartamentoEntity();
        }else {
            entity = ubiDepartamentoService.getById(dto.getId());
        }

        return entity;
    }

}
