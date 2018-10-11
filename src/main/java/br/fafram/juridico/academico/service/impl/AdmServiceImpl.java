package br.fafram.juridico.academico.service.impl;

import br.fafram.juridico.academico.domain.Admin;
import br.fafram.juridico.academico.repository.AdmRepository;
import br.fafram.juridico.academico.service.AdmService;
import br.fafram.juridico.academico.utils.ExceptionAcademico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmServiceImpl implements AdmService {

  @Autowired
  private AdmRepository admRepository;

  @Override
  public Admin save(String emailAdm, String curso) {
    Admin adm = new Admin();
    adm.setCursoAdm(curso);
    adm.setEmailAdm(emailAdm);
    return admRepository.save(adm);
  }

  @Override
  public Admin getAdm(String emailAdm) {
    Admin admin = admRepository.findByEmailAdm(emailAdm);

    if (admin != null) {
      Admin adm = new Admin();
      adm.setId(admin.getId());
      adm.setEmailAdm(admin.getEmailAdm());
      adm.setCursoAdm(admin.getCursoAdm());

      return adm;
    } else {
      throw ExceptionAcademico.ADMIN_NOT_FOUND;
    }
  }
}
