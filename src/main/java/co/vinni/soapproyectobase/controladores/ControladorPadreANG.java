package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.dto.PadreDto;
import co.vinni.soapproyectobase.servicios.ServicioCiudadano;
import co.vinni.soapproyectobase.servicios.ServicioPadre;
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
@RequestMapping("/api/padre")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class ControladorPadreANG {
    private static final Logger logger = LogManager.getLogger(ControladorPadre.class);


    private ServicioPadre servicioPadre;

    @GetMapping("/")
    public ResponseEntity<List<PadreDto>> listarPadre(){

        return ResponseEntity.ok(servicioPadre.obtenerPadre());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<PadreDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioPadre.obtenerPadre(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PadreDto> crear(@Validated @RequestBody PadreDto entityDto) {
        entityDto = servicioPadre.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PadreDto> modificar(@Validated @RequestBody PadreDto entityDto) {
        entityDto = servicioPadre.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioPadre.eliminar(serial);
    }

}
