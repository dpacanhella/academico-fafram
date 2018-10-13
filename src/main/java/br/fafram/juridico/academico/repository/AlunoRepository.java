package br.fafram.juridico.academico.repository;

import br.fafram.juridico.academico.domain.Aluno;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

  Optional<Aluno> findByCodigoAluno(String codigoAluno);

  List<Aluno> findByQtdePresencaGreaterThanEqual(Integer qtdePresenca);
}
