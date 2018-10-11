package br.fafram.juridico.academico.utils;

import br.fafram.juridico.academico.domain.Admin;

public class ExceptionAcademico {

  public static final NotFoundException ADMIN_NOT_FOUND = new NotFoundException(Admin.class);

}
