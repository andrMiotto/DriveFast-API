package senai.weg.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.cliente.ClienteRequest;
import senai.weg.DriveFast.dto.cliente.ClienteResponse;
import senai.weg.DriveFast.projection.ClienteGastoProjection;
import senai.weg.DriveFast.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse create(ClienteRequest dto) {
        return null;
    }

    public List<ClienteResponse> listarTodos() {
        return null;
    }

    public ClienteResponse buscarPorId(Long id) {
        return null;
    }

    public ClienteResponse atualizar(Long id, ClienteRequest dto) {
        return null;
    }

    public void remover(Long id) {
    }

    public List<ClienteGastoProjection> relatorioGastos() {
        return null;
    }
}
