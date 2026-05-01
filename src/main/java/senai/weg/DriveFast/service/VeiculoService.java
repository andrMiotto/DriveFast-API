package senai.weg.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.veiculo.VeiculoCreateDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoResponseDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoUpdateDTO;
import senai.weg.DriveFast.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoResponseDTO create(VeiculoCreateDTO dto) {
        return null;
    }

    public List<VeiculoResponseDTO> listAll() {
        return null;
    }

    public VeiculoResponseDTO findById(Long id) {
        return null;
    }

    public VeiculoResponseDTO update(Long id, VeiculoUpdateDTO dto) {
        return null;
    }

    public void delete(Long id) {
    }

    public List<VeiculoResponseDTO> listAvailable() {
        return null;
    }
}
