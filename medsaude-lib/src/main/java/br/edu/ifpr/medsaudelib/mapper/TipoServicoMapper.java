package br.edu.ifpr.medsaudelib.mapper;

import br.edu.ifpr.medsaudelib.dto.CidadeDTO;
import br.edu.ifpr.medsaudelib.dto.TipoServicoDTO;
import br.edu.ifpr.medsaudelib.entity.Cidade;
import br.edu.ifpr.medsaudelib.entity.TipoServico;

import java.util.ArrayList;
import java.util.List;

public class TipoServicoMapper {

    public static TipoServicoDTO convertToVo(TipoServico entity) {

        TipoServicoDTO dto = null;
        if (entity != null) {
            dto = new TipoServicoDTO();
            dto.setId(entity.getId());
            dto.setDescricao(entity.getDescricao());
            dto.setValorPorSessao(entity.getValorPorSessao());
            dto.setMaximoAlunosPorSessao(entity.getMaximoAlunosPorSessao());
            dto.setStatus(entity.getStatus());
        }
        return dto;
    }

    public static List<TipoServicoDTO> convertToListVo(List<TipoServico> listEntity) {
        List<TipoServicoDTO> listDTO = null;
        if (listEntity != null) {
            listDTO = new ArrayList<>();
            for (TipoServico entity : listEntity) {
                listDTO.add(convertToVo(entity));
            }
        }
        return listDTO;
    }

    public static TipoServico convertToEntity(TipoServicoDTO dto) {

        TipoServico entity = null;
        if (dto != null) {
            entity = new TipoServico();
            entity.setId(dto.getId());
            entity.setDescricao(dto.getDescricao());
            entity.setValorPorSessao(dto.getValorPorSessao());
            entity.setMaximoAlunosPorSessao(dto.getMaximoAlunosPorSessao());
            entity.setStatus(dto.getStatus());
        }
        return entity;
    }

    public static List<TipoServico> convertToListEntity(List<TipoServicoDTO> listVo) {
        List<TipoServico> listEntity = null;
        if (listVo != null) {
            listEntity = new ArrayList<>();
            for (TipoServicoDTO dto : listVo) {
                listEntity.add(convertToEntity(dto));
            }
        }
        return listEntity;
    }

}
