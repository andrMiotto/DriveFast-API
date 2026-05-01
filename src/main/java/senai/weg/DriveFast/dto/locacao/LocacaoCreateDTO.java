package senai.weg.DriveFast.dto.locacao;

public record LocacaoCreateDTO(
        Long clienteId,
        Long veiculoId,
        Integer dias
) {

}
