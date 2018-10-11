package br.fafram.juridico.academico.utils;

import org.springframework.http.HttpStatus;

public class NotFoundException extends WebException {

  private static final long serialVersionUID = 2799179465862669781L;

  public NotFoundException(Class<?> clazz) {
    super(HttpStatus.NOT_FOUND, "exception." + clazz.getSimpleName() + ".notFound");
  }

}