package cr.ac.ucr.paraiso.ie.c4h845.quiz4.data;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryPaqueteRepository implements PaqueteRepository {
    private final Map<Long, Paquete> paquetes = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(1L);

    @Override
    public Paquete save(Paquete paquete) {
        if (paquete.getId() == 0) {
            long id = sequence.getAndIncrement();
            paquete.setId(id);
        }
        paquetes.put(paquete.getId(), paquete);
        return paquete;
    }
}
