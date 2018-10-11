package br.fafram.juridico.academico.controller;

import br.fafram.juridico.academico.dto.AdmDTO;
import br.fafram.juridico.academico.mapper.AdmMapper;
import br.fafram.juridico.academico.service.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admins")
public class AdmController {

  @Autowired
  private AdmService admService;

  @Autowired
  private AdmMapper admMapper;

  @PostMapping
  public AdmDTO saveAdm(@RequestParam String emailAdm, @RequestParam String curso) {
    return admMapper.toDTO(admService.save(emailAdm, curso));
  }

  @GetMapping
  public AdmDTO getAdm(@RequestParam String emailAdm) {
    return admMapper.toDTO(admService.getAdm(emailAdm));
  }
}
