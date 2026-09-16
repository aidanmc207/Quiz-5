package cr.ac.ucr.paraiso.ie.c4h845.quiz4.data;

import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> findById(long id);
}
