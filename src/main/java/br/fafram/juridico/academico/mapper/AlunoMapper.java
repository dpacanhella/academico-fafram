package br.fafram.juridico.academico.mapper;

import br.fafram.juridico.academico.domain.Aluno;
import br.fafram.juridico.academico.dto.AlunoDTO;
import br.fafram.juridico.academico.utils.BaseMapper;
import br.fafram.juridico.academico.utils.MapperUtils;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper extends BaseMapper<Aluno, AlunoDTO> {

  private MapperUtils<Aluno, AlunoDTO> convert = new MapperUtils<Aluno, AlunoDTO>(Aluno.class, AlunoDTO.class);

  @Override
  public AlunoDTO toDTO(Aluno entity) {
    return convert.toDTO(entity);
  }

  @Override
  public Aluno toEntity(AlunoDTO dto) {
    return convert.toEntity(dto);
  }
}
