package br.edu.ifpr.medsaudelib.mapper;

import br.edu.ifpr.medsaudelib.dto.CidadeDTO;
import br.edu.ifpr.medsaudelib.entity.Cidade;

import java.util.ArrayList;
import java.util.List;

public class CidadeMapper {

    public static CidadeDTO convertToVo(Cidade entity) {

        CidadeDTO dto = null;
        if (entity != null) {
            dto = new CidadeDTO();
            dto.setId(entity.getId());
            dto.setNome(entity.getNome());
            dto.setEstado(EstadoMapper.convertToVo(entity.getEstado()));
        }
        return dto;
    }

    public static List<CidadeDTO> convertToListVo(List<Cidade> listEntity) {
        List<CidadeDTO> listDTO = null;
        if (listEntity != null) {
            listDTO = new ArrayList<>();
            for (Cidade entity : listEntity) {
                listDTO.add(convertToVo(entity));
            }
        }
        return listDTO;
    }

    public static Cidade convertToEntity(CidadeDTO dto) {

        Cidade entity = null;
        if (dto != null) {
            entity = new Cidade();
            entity.setId(dto.getId());
            entity.setNome(dto.getNome());
            entity.setEstado(EstadoMapper.convertToEntity(dto.getEstado()));
        }
        return entity;
    }

    public static List<Cidade> convertToListEntity(List<CidadeDTO> listVo) {
        List<Cidade> listEntity = null;
        if (listVo != null) {
            listEntity = new ArrayList<>();
            for (CidadeDTO dto : listVo) {
                listEntity.add(convertToEntity(dto));
            }
        }
        return listEntity;
    }

}
