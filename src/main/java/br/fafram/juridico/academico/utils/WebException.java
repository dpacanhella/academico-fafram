package br.fafram.juridico.academico.utils;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class WebException extends RuntimeException {

  private static final long serialVersionUID = 3406636182783807331L;

  private final HttpStatus status;
  private final String message;

  public HttpStatus getStatus() {
    return status;
  }

  @Override
  public String getMessage() {
    return message;
  }

}