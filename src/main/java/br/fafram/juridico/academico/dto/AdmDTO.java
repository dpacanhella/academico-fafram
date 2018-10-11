package br.fafram.juridico.academico.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdmDTO {

  private Integer id;
  private String emailAdm;
  private String cursoAdm;

}
