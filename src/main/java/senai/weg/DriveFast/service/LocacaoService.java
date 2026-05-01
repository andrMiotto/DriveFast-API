package senai.weg.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.locacao.LocacaoCreateDTO;
import senai.weg.DriveFast.dto.locacao.LocacaoResponseDTO;
import senai.weg.DriveFast.repository.ClienteRepository;
import senai.weg.DriveFast.repository.LocacaoRepository;
import senai.weg.DriveFast.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    public LocacaoResponseDTO create(LocacaoCreateDTO dto) {
        return null;
    }

    public List<LocacaoResponseDTO> listAll() {
        return null;
    }

    public void endRental(Long id) {
    }

    public List<LocacaoResponseDTO> listByClient(Long clienteId) {
        return null;
    }
}
