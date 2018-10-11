package br.fafram.juridico.academico.repository;

import br.fafram.juridico.academico.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepository extends JpaRepository<Admin, Integer> {

  Admin findByEmailAdm(String emailAdm);
}
