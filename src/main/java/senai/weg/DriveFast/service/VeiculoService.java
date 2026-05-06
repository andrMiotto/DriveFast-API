package senai.weg.DriveFast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.veiculo.VeiculoRequestDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoResponseDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoUpdateDTO;
import senai.weg.DriveFast.mapper.VeiculoMapper;
import senai.weg.DriveFast.model.Veiculo;
import senai.weg.DriveFast.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoMapper mapper;
    private final VeiculoRepository repository;


    public VeiculoResponseDTO create(VeiculoRequestDTO veiculoRequest){
        Veiculo veiculo = mapper.toEntity(veiculoRequest);
        Veiculo veiculoSalvo = repository.save(veiculo);
        VeiculoResponseDTO veiculoResponse = mapper.toResponseDTO(veiculoSalvo);

        return veiculoResponse;
    }

    public VeiculoResponseDTO findById(long id){
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new RuntimeException());
        VeiculoResponseDTO veiculoResponse = mapper.toResponseDTO(veiculo);
        return veiculoResponse;
    }

    public List<VeiculoResponseDTO> listAll(){
        List<Veiculo> veiculos = repository.findAll();
        List<VeiculoResponseDTO> veiculoResponses = new ArrayList<>();

        for(Veiculo v: veiculos){
            veiculoResponses.add(mapper.toResponseDTO(v));
        }

        return veiculoResponses;
    }

    public VeiculoResponseDTO update(long id, VeiculoUpdateDTO veiculoRequest){
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new RuntimeException());
        veiculo.setValorDiaria(veiculoRequest.valorDiaria());
        Veiculo veiculoSalvo = repository.save(veiculo);

        VeiculoResponseDTO veiculoResponse = mapper.toResponseDTO(veiculoSalvo);

        return veiculoResponse;
    }

    public String delete(long id){
        repository.deleteById(id);
        return "Deletado";
    }

    public List<VeiculoResponseDTO> listAvailable() {
        List<Veiculo> veiculos = repository.findByDisponivel(true);
        List<VeiculoResponseDTO> veiculoResponses = new ArrayList<>();

        for(Veiculo v: veiculos){
            veiculoResponses.add(mapper.toResponseDTO(v));
        }

        return veiculoResponses;
    }
}
