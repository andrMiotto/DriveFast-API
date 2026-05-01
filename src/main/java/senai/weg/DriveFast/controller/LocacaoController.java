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
import senai.weg.DriveFast.dto.locacao.LocacaoCreateDTO;
import senai.weg.DriveFast.dto.locacao.LocacaoResponseDTO;
import senai.weg.DriveFast.service.LocacaoService;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService locacaoService;

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> create(@RequestBody LocacaoCreateDTO dto) {
        LocacaoResponseDTO response = locacaoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listAll() {
        List<LocacaoResponseDTO> response = locacaoService.listAll();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> returnVehicle(@PathVariable Long id) {
        locacaoService.endRental(id);
        return ResponseEntity.ok(new MensagemDTO("Veiculo devolvido e locacao encerrada!"));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<LocacaoResponseDTO>> listByClient(@PathVariable Long clienteId) {
        List<LocacaoResponseDTO> response = locacaoService.listByClient(clienteId);
        return ResponseEntity.ok(response);
    }
}
