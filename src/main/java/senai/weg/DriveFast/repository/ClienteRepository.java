package senai.weg.DriveFast.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import senai.weg.DriveFast.model.Cliente;
import senai.weg.DriveFast.projection.ClienteGastoProjection;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = """
            SELECT c.nome AS nomeCliente, SUM(l.valor_total) AS totalGasto
            FROM cliente c
            JOIN locacao l ON l.cliente_id = c.id
            GROUP BY c.nome
            """, nativeQuery = true)
    List<ClienteGastoProjection> buscarRelatorioGastos();
}
