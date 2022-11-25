package br.com.mentorama.Mod01Atividade;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class CadastroAlunosController {

    private final String message = "Olá Mundo";

    @GetMapping
    public String olaMundo() {
        return message;
    }

}
