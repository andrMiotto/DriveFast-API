package senai.weg.DriveFast.mapper;

import org.springframework.stereotype.Component;

import senai.weg.DriveFast.dto.cliente.ClienteRequest;
import senai.weg.DriveFast.dto.cliente.ClienteResponse;
import senai.weg.DriveFast.model.Cliente;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequest dto) {
        return null;
    }

    public ClienteResponse toResponseDTO(Cliente entity) {
        return null;
    }
}
