package br.fafram.juridico.academico.service;

import br.fafram.juridico.academico.domain.Aluno;
import java.util.List;
import java.util.Optional;

public interface AlunoService {

  Optional<Aluno> getAluno(String id);

  Aluno save(String codigoAluno, String nomeAluno);

  List<Aluno> getAll();

  List<Aluno> getAprovados(Integer qtdePresenca);
}
