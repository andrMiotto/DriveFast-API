package senai.weg.DriveFast.mapper;

import org.springframework.stereotype.Component;

import senai.weg.DriveFast.dto.cliente.ClienteRequestDTO;
import senai.weg.DriveFast.dto.cliente.ClienteResponseDTO;
import senai.weg.DriveFast.model.Cliente;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        cliente.setCnh(dto.cnh());
        cliente.setEmail(dto.email());
        return cliente;
    }

    public ClienteResponseDTO toResponseDTO(Cliente entity) {
        return new ClienteResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCnh(),
                entity.getEmail()
        );
    }

}
