package senai.weg.DriveFast.mapper;

import org.springframework.stereotype.Component;

import senai.weg.DriveFast.dto.veiculo.VeiculoRequestDTO;
import senai.weg.DriveFast.dto.veiculo.VeiculoResponseDTO;
import senai.weg.DriveFast.model.Veiculo;

@Component
public class VeiculoMapper {

    public Veiculo toEntity(VeiculoRequestDTO dto) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca(dto.marca());
        veiculo.setModelo(dto.modelo());
        veiculo.setPlaca(dto.placa());
        veiculo.setValorDiaria(dto.valorDiaria());
        veiculo.setDisponivel(true);
        return veiculo;
    }

    public VeiculoResponseDTO toResponseDTO(Veiculo entity) {
        return new VeiculoResponseDTO(
                entity.getId(),
                entity.getMarca(),
                entity.getModelo(),
                entity.getPlaca(),
                entity.getValorDiaria(),
                entity.getDisponivel()
        );
    }
}
