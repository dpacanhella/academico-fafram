package br.fafram.juridico.academico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

  private Integer id;
  private String codigoAluno;
  private String nomeAluno;
  private Integer qtdePresenca;

}
