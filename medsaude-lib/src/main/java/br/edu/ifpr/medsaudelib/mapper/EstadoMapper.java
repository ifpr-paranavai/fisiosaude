package br.edu.ifpr.medsaudelib.mapper;

import br.edu.ifpr.medsaudelib.dto.EstadoDTO;
import br.edu.ifpr.medsaudelib.entity.Estado;

import java.util.ArrayList;
import java.util.List;

public class EstadoMapper {

    public static EstadoDTO convertToVo(Estado entity) {

        EstadoDTO dto = null;
        if (entity != null) {
            dto = new EstadoDTO();
            dto.setId(entity.getId());
            dto.setNome(entity.getNome());
            dto.setSigla(entity.getSigla());
        }
        return dto;
    }

    public static List<EstadoDTO> convertToListVo(List<Estado> listEntity) {
        List<EstadoDTO> listVo = null;
        if (listEntity != null) {
            listVo = new ArrayList<>();
            for (Estado entity : listEntity) {
                listVo.add(convertToVo(entity));
            }
        }
        return listVo;
    }

    public static Estado convertToEntity(EstadoDTO dto) {

        Estado entity = null;
        if (dto != null) {
            entity = new Estado();
            entity.setId(dto.getId());
            entity.setNome(dto.getNome());
            entity.setSigla(dto.getSigla());
        }
        return entity;
    }

    public static List<Estado> convertToListEntity(List<EstadoDTO> listVo) {
        List<Estado> listEntity = null;
        if (listVo != null) {
            listEntity = new ArrayList<>();
            for (EstadoDTO vo : listVo) {
                listEntity.add(convertToEntity(vo));
            }
        }
        return listEntity;
    }

}
