package senai.weg.DriveFast.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.MensagemDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoRequest;
import senai.weg.DriveFast.dto.veiculo.VeiculoResponse;
import senai.weg.DriveFast.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponse> cadastrar(@RequestBody VeiculoRequest dto) {
        VeiculoResponse response = veiculoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> listar() {
        List<VeiculoResponse> response = veiculoService.listarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> buscarPorId(@PathVariable Long id) {
        VeiculoResponse response = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse> atualizar(@PathVariable Long id, @RequestBody VeiculoRequest dto) {
        VeiculoResponse response = veiculoService.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> remover(@PathVariable Long id) {
        veiculoService.remover(id);
        return ResponseEntity.ok(new MensagemDTO("Veiculo removido com sucesso!"));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponse>> listarDisponiveis() {
        List<VeiculoResponse> response = veiculoService.listarDisponiveis();
        return ResponseEntity.ok(response);
    }
}
