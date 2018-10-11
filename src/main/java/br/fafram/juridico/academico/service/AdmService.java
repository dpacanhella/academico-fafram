package br.fafram.juridico.academico.service;

import br.fafram.juridico.academico.domain.Admin;

public interface AdmService {

  Admin save(String emailAdm, String curso);

  Admin getAdm(String emailAdm);
}
