package senai.weg.DriveFast.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.locacao.LocacaoCreateDTO;
import senai.weg.DriveFast.dto.locacao.LocacaoResponseDTO;
import senai.weg.DriveFast.model.Cliente;
import senai.weg.DriveFast.model.Locacao;
import senai.weg.DriveFast.model.Veiculo;
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
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId())
                .orElseThrow(() -> new RuntimeException("Veiculo nao encontrado"));

        if (Boolean.FALSE.equals(veiculo.getDisponivel())) {
            throw new RuntimeException("Veiculo indisponivel para locacao");
        }

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setDias(dto.dias());
        locacao.setValorTotal(veiculo.getValorDiaria().multiply(BigDecimal.valueOf(dto.dias())));

        veiculo.setDisponivel(false);
        veiculoRepository.save(veiculo);

        Locacao locacaoSalva = locacaoRepository.save(locacao);
        return toResponseDTO(locacaoSalva);
    }

    public List<LocacaoResponseDTO> listAll() {
        List<Locacao> locacoes = locacaoRepository.findAll();
        List<LocacaoResponseDTO> response = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            response.add(toResponseDTO(locacao));
        }

        return response;
    }

    public void endRental(Long id) {
        Locacao locacao = locacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locacao nao encontrada"));

        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setDisponivel(true);
        veiculoRepository.save(veiculo);

        locacaoRepository.delete(locacao);
    }

    public List<LocacaoResponseDTO> listByClient(Long clienteId) {
        List<Locacao> locacoes = locacaoRepository.buscarPorClienteId(clienteId);
        List<LocacaoResponseDTO> response = new ArrayList<>();

        for (Locacao locacao : locacoes) {
            response.add(toResponseDTO(locacao));
        }

        return response;
    }

    private LocacaoResponseDTO toResponseDTO(Locacao locacao) {
        return new LocacaoResponseDTO(
                locacao.getId(),
                locacao.getDias(),
                locacao.getValorTotal(),
                locacao.getCliente().getNome(),
                locacao.getVeiculo().getModelo()
        );
    }
}
