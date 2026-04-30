package senai.weg.DriveFast.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.MensagemDTO;
import senai.weg.DriveFast.dto.locacao.LocacaoRequest;
import senai.weg.DriveFast.dto.locacao.LocacaoResponse;
import senai.weg.DriveFast.service.LocacaoService;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<LocacaoResponse> realizarLocacao(@RequestBody LocacaoRequest dto) {
        LocacaoResponse response = locacaoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponse>> listar() {
        List<LocacaoResponse> response = locacaoService.listarTodas();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> devolverVeiculo(@PathVariable Long id) {
        locacaoService.encerrarLocacao(id);
        return ResponseEntity.ok(new MensagemDTO("Veiculo devolvido e locacao encerrada!"));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<LocacaoResponse>> listarPorCliente(@PathVariable Long clienteId) {
        List<LocacaoResponse> response = locacaoService.listarPorCliente(clienteId);
        return ResponseEntity.ok(response);
    }
}
