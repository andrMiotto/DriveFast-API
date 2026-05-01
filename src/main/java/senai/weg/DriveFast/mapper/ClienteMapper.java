package senai.weg.DriveFast.mapper;

import org.springframework.stereotype.Component;

import senai.weg.DriveFast.dto.cliente.ClienteCreateDTO;
import senai.weg.DriveFast.dto.cliente.ClienteResponseDTO;
import senai.weg.DriveFast.model.Cliente;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteCreateDTO dto) {
        return null;
    }

    public ClienteResponseDTO toResponseDTO(Cliente entity) {
        return null;
    }
}
