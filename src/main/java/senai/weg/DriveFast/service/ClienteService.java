package senai.weg.DriveFast.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import senai.weg.DriveFast.dto.cliente.ClienteRequestDTO;
import senai.weg.DriveFast.dto.cliente.ClienteResponseDTO;
import senai.weg.DriveFast.dto.cliente.ClienteUpdateDTO;
import senai.weg.DriveFast.mapper.ClienteMapper;
import senai.weg.DriveFast.model.Cliente;
import senai.weg.DriveFast.projection.ClienteGastoProjection;
import senai.weg.DriveFast.repository.ClienteRepository;

@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public ClienteResponseDTO create(ClienteRequestDTO clienteRequest){
        Cliente cliente = mapper.toEntity(clienteRequest);
        Cliente clienteSaCliente = repository.save(cliente);
        ClienteResponseDTO clienteResponse = mapper.toResponseDTO(clienteSaCliente);

        return clienteResponse;
    }

    public ClienteResponseDTO findById(long id){
        Cliente cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("não tem um cliente com este id "));
        ClienteResponseDTO clienteResponse = mapper.toResponseDTO(cliente);

        return clienteResponse;
    }

    public List<ClienteResponseDTO> listAll(){
        List<Cliente> clientes = repository.findAll();
        List<ClienteResponseDTO> dto = new ArrayList<>();

        for(Cliente c: clientes){
            dto.add(mapper.toResponseDTO(c));
        }

        return dto;
    }

    public ClienteResponseDTO update(long id, ClienteUpdateDTO clienteRequest){
        Cliente cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("não tem um cliente com este id "));
        cliente.setNome(clienteRequest.nome());
        cliente.setEmail(clienteRequest.email());
        Cliente clienteSalvo = repository.save(cliente);
        ClienteResponseDTO clienteResponse = mapper.toResponseDTO(clienteSalvo);

        return clienteResponse;
    }

    public String delete(long id){
        repository.deleteById(id);
        return "Deletado!";
    }

    public List<ClienteGastoProjection> expenseReport() {
        return repository.buscarRelatorioGastos();
    }
}
