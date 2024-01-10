package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.consulta.DadosCancelamentoConsulta;
import med.voll.api.dto.medico.DadosCadastroMedico;
import med.voll.api.dto.medico.DadosDetalhamentoMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import med.voll.api.service.AgendaDeConsultas;

@RestController
@RequestMapping("/api/v1/consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agendaDeConsultas;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(
            @RequestBody @Valid DadosCadastroMedico dados
    ) {
        return null;
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMedico> deletar(
            @RequestBody @Valid DadosCancelamentoConsulta dados
    ) {
        agendaDeConsultas.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
