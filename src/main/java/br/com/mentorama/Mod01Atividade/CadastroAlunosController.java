package br.com.mentorama.Mod01Atividade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class CadastroAlunosController {

    private final List<Aluno> listaAlunos;

    // Construtor para definir e inicializar a lista de alunos:
    public CadastroAlunosController() {
        this.listaAlunos = new ArrayList<>();
        this.listaAlunos.add(new Aluno(1, "João",30));
        this.listaAlunos.add(new Aluno(2, "Maria",45));
        this.listaAlunos.add(new Aluno(3, "José",58));
    }


    @GetMapping
    public List<Aluno> findAll() {
        return listaAlunos;
    }

}
