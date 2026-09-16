package cr.ac.ucr.paraiso.ie.c4h845.quiz4.business;

import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.Cliente;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.ClienteRepository;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.Paquete;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.PaqueteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaqueteServiceTest {

    @Mock
    private PaqueteRepository paqueteRepository;

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private PaqueteService paqueteService;

    @Test
    void debeRegistrarPaqueteCuandoElPesoEsValido() {
        Paquete paquete = new Paquete();
        paquete.setCodigoRastreo("TRK-001");
        paquete.setDescripcion("Documentos");
        paquete.setPesoKg(10.0);

        Paquete paqueteGuardado = new Paquete(
                1L,
                "TRK-001",
                "Documentos",
                10.0,
                Paquete.Estado.REGISTRADO
        );

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(new Cliente()));
        when(paqueteRepository.save(paquete)).thenReturn(paqueteGuardado);

        Paquete resultado = paqueteService.registrarPaquete(paquete, 1L);

        assertNotNull(resultado);
        assertEquals(Paquete.Estado.REGISTRADO, paquete.getEstado());
        verify(clienteRepository).findById(1L);
        verify(paqueteRepository).save(paquete);
    }

    @Test
    void debeLanzarExcepcionCuandoElPesoSuperaTreintaKilogramos() {
        Paquete paquete = new Paquete();
        paquete.setPesoKg(30.1);

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(new Cliente()));

        assertThrows(
                PesoExcedidoException.class,
                () -> paqueteService.registrarPaquete(paquete, 1L)
        );

        verify(paqueteRepository, never()).save(any(Paquete.class));
    }
}
