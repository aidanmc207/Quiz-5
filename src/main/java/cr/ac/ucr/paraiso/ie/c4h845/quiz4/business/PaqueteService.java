package cr.ac.ucr.paraiso.ie.c4h845.quiz4.business;

import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.Cliente;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.ClienteRepository;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.Paquete;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.PaqueteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;
    private final ClienteRepository clienteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository, ClienteRepository clienteRepository) {
        this.paqueteRepository = paqueteRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Paquete registrarPaquete(Paquete paquete, long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ClienteNoEncontradoException(
                        "Cliente no encontrado con id: " + clienteId));

        if (paquete.getPesoKg() > 30.0) {
            throw new PesoExcedidoException("El peso del paquete excede el límite permitido (30.0 kg).");
        }

        paquete.setEstado(Paquete.Estado.REGISTRADO);
        return paqueteRepository.save(paquete);
    }
}
