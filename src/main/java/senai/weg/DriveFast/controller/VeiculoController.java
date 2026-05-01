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
import senai.weg.DriveFast.dto.veiculo.VeiculoCreateDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoResponseDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoUpdateDTO;
import senai.weg.DriveFast.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> create(@RequestBody VeiculoCreateDTO dto) {
        VeiculoResponseDTO response = veiculoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listAll() {
        List<VeiculoResponseDTO> response = veiculoService.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> findById(@PathVariable Long id) {
        VeiculoResponseDTO response = veiculoService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> update(@PathVariable Long id, @RequestBody VeiculoUpdateDTO dto) {
        VeiculoResponseDTO response = veiculoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> delete(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.ok(new MensagemDTO("Veiculo removido com sucesso!"));
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<VeiculoResponseDTO>> listAvailable() {
        List<VeiculoResponseDTO> response = veiculoService.listAvailable();
        return ResponseEntity.ok(response);
    }
}
