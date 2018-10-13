package br.fafram.juridico.academico.service.impl;

import br.fafram.juridico.academico.domain.Aluno;
import br.fafram.juridico.academico.repository.AlunoRepository;
import br.fafram.juridico.academico.service.AlunoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoServiceImpl implements AlunoService {

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Optional<Aluno> getAluno(String codigoAluno) {
    return alunoRepository.findByCodigoAluno(codigoAluno);
  }

  @Override
  public Aluno save(String codigoAluno, String nomeAluno) {
    Aluno aluno = new Aluno();
    aluno.setCodigoAluno(codigoAluno);
    aluno.setNomeAluno(nomeAluno);
    return alunoRepository.save(aluno);
  }

  @Override
  public List<Aluno> getAll() {
    return alunoRepository.findAll();
  }

  @Override
  public List<Aluno> getAprovados(Integer qtdePresenca) {
    return alunoRepository.findByQtdePresencaGreaterThanEqual(qtdePresenca);
  }

}
