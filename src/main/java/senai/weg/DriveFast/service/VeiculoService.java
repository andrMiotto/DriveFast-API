package senai.weg.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.veiculo.VeiculoRequest;
import senai.weg.DriveFast.dto.veiculo.VeiculoResponse;
import senai.weg.DriveFast.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoResponse create(VeiculoRequest dto) {
        return null;
    }

    public List<VeiculoResponse> listarTodos() {
        return null;
    }

    public VeiculoResponse buscarPorId(Long id) {
        return null;
    }

    public VeiculoResponse atualizar(Long id, VeiculoRequest dto) {
        return null;
    }

    public void remover(Long id) {
    }

    public List<VeiculoResponse> listarDisponiveis() {
        return null;
    }
}
