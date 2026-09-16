package cr.ac.ucr.paraiso.ie.c4h845.quiz4.data;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryClienteRepository implements ClienteRepository {
    private final Map<Long, Cliente> clientes = new ConcurrentHashMap<>();

    public InMemoryClienteRepository() {
        clientes.put(1L, new Cliente(1L, "1012345678", "Ana Mora"));
        clientes.put(2L, new Cliente(2L, "2056789012", "Luis Vega"));
    }

    @Override
    public Optional<Cliente> findById(long id) {
        return Optional.ofNullable(clientes.get(id));
    }
}
