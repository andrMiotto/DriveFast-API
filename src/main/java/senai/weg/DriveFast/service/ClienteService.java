package senai.weg.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.cliente.ClienteCreateDTO;
import senai.weg.DriveFast.dto.cliente.ClienteResponseDTO;
import senai.weg.DriveFast.dto.cliente.ClienteUpdateDTO;
import senai.weg.DriveFast.projection.ClienteGastoProjection;
import senai.weg.DriveFast.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponseDTO create(ClienteCreateDTO dto) {
        return null;
    }

    public List<ClienteResponseDTO> listAll() {
        return null;
    }

    public ClienteResponseDTO findById(Long id) {
        return null;
    }

    public ClienteResponseDTO update(Long id, ClienteUpdateDTO dto) {
        return null;
    }

    public void delete(Long id) {
    }

    public List<ClienteGastoProjection> expenseReport() {
        return null;
    }
}
