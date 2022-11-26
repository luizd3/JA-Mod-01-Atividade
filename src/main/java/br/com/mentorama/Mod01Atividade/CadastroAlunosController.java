package br.com.mentorama.Mod01Atividade;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class CadastroAlunosController {

    private final List<Aluno> listaAlunos;

    // Construtor para definir e inicializar a lista de alunos:
    public CadastroAlunosController() {
        this.listaAlunos = new ArrayList<>();
    }


    @GetMapping
    public List<Aluno> findAll() {
        return listaAlunos;
    }

    @PostMapping
    public String add(@RequestBody final Aluno novoAluno) {
        if (novoAluno.getId() == null) {
            novoAluno.setId(listaAlunos.size() + 1);
        }
        listaAlunos.add(novoAluno);
        return "Aluno cadastrado. ID: " + String.valueOf(novoAluno.getId());
    }

    @PutMapping
    public ResponseEntity update(@RequestBody final Aluno atualizaAluno) {
        listaAlunos.stream()
                .filter(aln -> aln.getId().equals(atualizaAluno.getId()))
                .forEach(aln -> {
                    aln.setNome(atualizaAluno.getNome());
                    aln.setIdade(atualizaAluno.getIdade());
                });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        listaAlunos.removeIf(aln -> aln.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
