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
@Table(name =  "admins")
public class Admin {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Integer id;

  @Column(name = "adm_email")
  private String emailAdm;

  @Column(name = "adm_curso")
  private String cursoAdm;

}
