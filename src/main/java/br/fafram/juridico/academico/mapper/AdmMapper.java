package br.fafram.juridico.academico.mapper;

import br.fafram.juridico.academico.domain.Admin;
import br.fafram.juridico.academico.dto.AdmDTO;
import br.fafram.juridico.academico.utils.BaseMapper;
import br.fafram.juridico.academico.utils.MapperUtils;
import org.springframework.stereotype.Component;

@Component
public class AdmMapper extends BaseMapper<Admin, AdmDTO> {

  private MapperUtils<Admin, AdmDTO> convert = new MapperUtils<Admin, AdmDTO>(Admin.class, AdmDTO.class);

  @Override
  public AdmDTO toDTO(Admin entity) {
    return convert.toDTO(entity);
  }

  @Override
  public Admin toEntity(AdmDTO dto) {
    return convert.toEntity(dto);
  }
}
