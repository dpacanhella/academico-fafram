package br.fafram.juridico.academico.controller;

import br.fafram.juridico.academico.domain.Aluno;
import br.fafram.juridico.academico.dto.AlunoDTO;
import br.fafram.juridico.academico.mapper.AlunoMapper;
import br.fafram.juridico.academico.service.AlunoService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alunos")
public class AlunoController {

  private static final String FILE_NAME = "aprovados.pdf";

  @Autowired
  private AlunoService alunoService;

  @Autowired
  private AlunoMapper alunoMapper;

  @PostMapping("/aplicar-presenca")
  @Transactional
  public AlunoDTO salveOrUpdateAluno(
      @RequestParam(required = false) String codigoAluno,
      @RequestParam(required = false) String nomeAluno) {
    Optional<Aluno> aluno = alunoService.getAluno(codigoAluno);

    if (aluno.isPresent()) {
      aluno.get().marcarPresenca();
    } else {
      alunoService.save(codigoAluno, nomeAluno);
    }

    return new AlunoDTO();
  }

  @GetMapping("/todos-participantes")
  public List<AlunoDTO> participantes() throws IOException {
    List<Aluno> alunos = alunoService.getAll();

    Collections.sort(alunos, new Comparator<Aluno>() {
      @Override
      public int compare(Aluno o1, Aluno o2) {
        return - o1.getQtdePresenca().compareTo(o2.getQtdePresenca());
      }
    });

    return alunoMapper.toListDTO(alunos);
  }

//  @GetMapping("/gerarPDF")
//  public ResponseEntity<byte[]> retornaAprovados(@RequestParam Integer qtdePresenca)
//      throws IOException, DocumentException {
//    List<AlunoDTO> alunos = alunoMapper.toListDTO(alunoService.getAprovados(qtdePresenca));
//
//    Document document = new Document();
//    ByteArrayOutputStream stream = new ByteArrayOutputStream();
//    PdfWriter.getInstance(document, stream);
//    document.open();
//
//    Paragraph p = new Paragraph();
//    p.add("Aprovados que tiveram igual/acima de " + qtdePresenca + " presenças");
//    p.setAlignment(Element.ALIGN_CENTER);
//    Font font = new Font();
//    font.setSize(30);
//    font.setStyle(3);
//    p.setFont(font);
//    document.add(p);
//
//    pularLinha(document);
//
//    for (AlunoDTO al: alunos) {
//      Paragraph p2 = new Paragraph();
//      p2.add(al.getCodigoAluno() + "   -  " + al.getNomeAluno());
//      document.add(p2);
//    }
//
//    document.close();
//
//    HttpHeaders headers = new HttpHeaders();
//    headers.add("content-disposition", "attachment; filename=" + FILE_NAME);
//    headers.add("Content-Type","pdf");
//    headers.setContentType(MediaType.parseMediaType("application/pdf"));
//    String filename = FILE_NAME;
//    headers.setContentDispositionFormData(filename, filename);
//    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//    ResponseEntity<byte[]> response = new ResponseEntity<>(stream.toByteArray(), headers, HttpStatus.OK);
//
//
//
//    return response;
//  }


  @GetMapping("/gerarPDF")
  public List<AlunoDTO> retornaAprovados(@RequestParam Integer qtdePresenca) throws IOException {
    return alunoMapper.toListDTO(alunoService.getAprovados(qtdePresenca));
  }

  private void pularLinha(Document document) throws DocumentException {
    Paragraph pularLinha = new Paragraph();
    pularLinha.add("");
    document.add(pularLinha);
  }


}
