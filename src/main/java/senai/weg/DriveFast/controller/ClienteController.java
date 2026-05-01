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
import senai.weg.DriveFast.dto.cliente.ClienteCreateDTO;
import senai.weg.DriveFast.dto.cliente.ClienteResponseDTO;
import senai.weg.DriveFast.dto.cliente.ClienteUpdateDTO;
import senai.weg.DriveFast.projection.ClienteGastoProjection;
import senai.weg.DriveFast.service.ClienteService;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteCreateDTO dto) {
        ClienteResponseDTO response = clienteService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listAll() {
        List<ClienteResponseDTO> response = clienteService.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id) {
        ClienteResponseDTO response = clienteService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> update(@PathVariable Long id, @RequestBody ClienteUpdateDTO dto) {
        ClienteResponseDTO response = clienteService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.ok(new MensagemDTO("Cliente removido com sucesso!"));
    }

    @GetMapping("/relatorio-gastos")
    public ResponseEntity<List<ClienteGastoProjection>> expenseReport() {
        List<ClienteGastoProjection> response = clienteService.expenseReport();
        return ResponseEntity.ok(response);
    }
}
