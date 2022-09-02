package br.edu.ifpr.medsaudelib.mapper;

import br.edu.ifpr.medsaudelib.dto.UsuarioDTO;
import br.edu.ifpr.medsaudelib.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static UsuarioDTO convertToVo(Usuario entity) {

        UsuarioDTO dto = null;
        if (entity != null) {
            dto = new UsuarioDTO();
            dto.setId(entity.getId());
            dto.setNome(entity.getNome());
            dto.setTelefone(entity.getTelefone());
            dto.setCpf(entity.getCpf());
            dto.setDataNascimento(entity.getDataNascimento());
            dto.setCidade(CidadeMapper.convertToVo(entity.getCidade()));
            dto.setLogradouro(entity.getLogradouro());
            dto.setNumero(entity.getNumero());
            dto.setComplemento(entity.getComplemento());
            dto.setBairro(entity.getBairro());
            dto.setSenha(entity.getSenha());
            dto.setEmail(entity.getEmail());
            dto.setStatus(entity.getStatus());

        }
        return dto;
    }

    public static List<UsuarioDTO> convertToListVo(List<Usuario> listEntity) {
        List<UsuarioDTO> listVo = null;
        if (listEntity != null) {
            listVo = new ArrayList<>();
            for (Usuario entity : listEntity) {
                listVo.add(convertToVo(entity));
            }
        }
        return listVo;
    }

    public static Usuario convertToEntity(UsuarioDTO dto) {

        Usuario entity = null;
        if (dto != null) {
            entity = new Usuario();

            entity.setId(dto.getId());
            entity.setNome(dto.getNome());
            entity.setTelefone(dto.getTelefone());
            entity.setCpf(dto.getCpf());
            entity.setDataNascimento(dto.getDataNascimento());
            entity.setCidade(CidadeMapper.convertToEntity(dto.getCidade()));
            entity.setLogradouro(dto.getLogradouro());
            entity.setNumero(dto.getNumero());
            entity.setComplemento(dto.getComplemento());
            entity.setBairro(dto.getBairro());
            entity.setSenha(dto.getSenha());
            entity.setEmail(dto.getEmail());
            entity.setStatus(dto.getStatus());
        }
        return entity;
    }

    public static List<Usuario> convertToListEntity(List<UsuarioDTO> listVo) {
        List<Usuario> listEntity = null;
        if (listVo != null) {
            listEntity = new ArrayList<>();
            for (UsuarioDTO vo : listVo) {
                listEntity.add(convertToEntity(vo));
            }
        }
        return listEntity;
    }

}
