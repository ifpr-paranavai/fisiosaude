package br.edu.ifpr.medsaudelib.mapper;

import br.edu.ifpr.medsaudelib.dto.TipoServicoDTO;
import br.edu.ifpr.medsaudelib.dto.TipoServicoFisioterapeutaDTO;
import br.edu.ifpr.medsaudelib.entity.TipoServico;
import br.edu.ifpr.medsaudelib.entity.TipoServicoFisioterapeuta;

import java.util.ArrayList;
import java.util.List;

public class TipoServicoFisioterapeutaMapper {

    public static TipoServicoFisioterapeutaDTO convertToVo(TipoServicoFisioterapeuta entity) {

        TipoServicoFisioterapeutaDTO dto = null;
        if (entity != null) {
            dto = new TipoServicoFisioterapeutaDTO();
            dto.setId(entity.getId());
            dto.setTipoServico(TipoServicoMapper.convertToVo(entity.getTipoServico()));
            dto.setFisioterapeuta(FisioterapeutaMapper.convertToVo(entity.getFisioterapeuta()));
            dto.setStatus(entity.getStatus());
        }
        return dto;
    }

    public static List<TipoServicoFisioterapeutaDTO> convertToListVo(List<TipoServicoFisioterapeuta> listEntity) {
        List<TipoServicoFisioterapeutaDTO> listDTO = null;
        if (listEntity != null) {
            listDTO = new ArrayList<>();
            for (TipoServicoFisioterapeuta entity : listEntity) {
                listDTO.add(convertToVo(entity));
            }
        }
        return listDTO;
    }

    public static TipoServicoFisioterapeuta convertToEntity(TipoServicoFisioterapeutaDTO dto) {

        TipoServicoFisioterapeuta entity = null;
        if (dto != null) {
            entity = new TipoServicoFisioterapeuta();
            entity.setId(dto.getId());
            entity.setTipoServico(TipoServicoMapper.convertToEntity(dto.getTipoServico()));
            entity.setFisioterapeuta(FisioterapeutaMapper.convertToEntity(dto.getFisioterapeuta()));
            entity.setStatus(dto.getStatus());
        }

        return entity;
    }

    public static List<TipoServicoFisioterapeuta> convertToListEntity(List<TipoServicoFisioterapeutaDTO> listVo) {
        List<TipoServicoFisioterapeuta> listEntity = null;
        if (listVo != null) {
            listEntity = new ArrayList<>();
            for (TipoServicoFisioterapeutaDTO dto : listVo) {
                listEntity.add(convertToEntity(dto));
            }
        }
        return listEntity;
    }

}
