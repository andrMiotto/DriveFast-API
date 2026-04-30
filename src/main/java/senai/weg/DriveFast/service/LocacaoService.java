package senai.weg.DriveFast.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.locacao.LocacaoRequest;
import senai.weg.DriveFast.dto.locacao.LocacaoResponse;
import senai.weg.DriveFast.repository.ClienteRepository;
import senai.weg.DriveFast.repository.LocacaoRepository;
import senai.weg.DriveFast.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    public LocacaoResponse salvar(LocacaoRequest dto) {
        return null;
    }

    public List<LocacaoResponse> listarTodas() {
        return null;
    }

    public void encerrarLocacao(Long id) {
    }

    public List<LocacaoResponse> listarPorCliente(Long clienteId) {
        return null;
    }
}
