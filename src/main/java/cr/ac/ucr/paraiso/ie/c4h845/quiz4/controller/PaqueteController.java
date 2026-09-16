package cr.ac.ucr.paraiso.ie.c4h845.quiz4.controller;

import cr.ac.ucr.paraiso.ie.c4h845.quiz4.business.PaqueteService;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.controller.dto.PaqueteRequestDto;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.controller.dto.PaqueteResponseDto;
import cr.ac.ucr.paraiso.ie.c4h845.quiz4.data.Paquete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class PaqueteController {

    private final PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @PostMapping("/paquetes")
    @Operation(summary = "Registrar un paquete", description = "Crea un paquete validando cliente y peso.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paquete creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado"),
            @ApiResponse(responseCode = "409", description = "Peso excedido")
    })
    public ResponseEntity<PaqueteResponseDto> registrarPaquete(@Valid @RequestBody PaqueteRequestDto requestDto) {
        Paquete paquete = new Paquete();
        paquete.setCodigoRastreo(requestDto.getCodigoRastreo());
        paquete.setDescripcion(requestDto.getDescripcion());
        paquete.setPesoKg(requestDto.getPesoKg());

        Paquete creado = paqueteService.registrarPaquete(paquete, requestDto.getClienteId());

        PaqueteResponseDto response = new PaqueteResponseDto(
                creado.getId(),
                creado.getCodigoRastreo(),
                creado.getDescripcion(),
                creado.getPesoKg(),
                creado.getEstado() != null ? creado.getEstado().name() : null
        );

        return ResponseEntity
                .created(URI.create("/api/v1/paquetes/" + creado.getId()))
                .body(response);
    }

    @GetMapping("/paquetes/{id}")
    @Operation(summary = "Obtener paquete por id", description = "Consulta un paquete por su identificador.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paquete encontrado"),
            @ApiResponse(responseCode = "404", description = "Paquete no encontrado")
    })
    public ResponseEntity<String> obtenerPaquete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Endpoint de consulta por id: " + id);
    }
}
