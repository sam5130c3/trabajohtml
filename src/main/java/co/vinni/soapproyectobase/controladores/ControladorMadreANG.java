package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.MadreDto;
import co.vinni.soapproyectobase.servicios.ServicioMadre;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/madre")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ControladorMadreANG {
    private static final Logger logger = LogManager.getLogger(ControladorCiudadano.class);


    private ServicioMadre servicioMadre;

    @GetMapping("/")
    public ResponseEntity<List<MadreDto>> listarMadre(){

        return ResponseEntity.ok(servicioMadre.obtenerMadre());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<MadreDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioMadre.obtenerMadre(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MadreDto> crear(@Validated @RequestBody MadreDto entityDto) {
        entityDto = servicioMadre.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MadreDto> modificar(@Validated @RequestBody MadreDto entityDto) {
        entityDto = servicioMadre.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioMadre.eliminar(serial);
    }
}
