package br.fafram.juridico.academico.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name =  "alunos")
public class Aluno {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer id;

  @Column(name = "aluno_codigo")
  private String codigoAluno;

  @Column(name = "aluno_nome")
  private String nomeAluno;

  @Column(name = "aluno_qtde_presenca")
  private Integer qtdePresenca = 1;

  public void marcarPresenca() {
    this.qtdePresenca++;
  }
}
