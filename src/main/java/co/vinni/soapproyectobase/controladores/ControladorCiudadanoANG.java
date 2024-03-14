package co.vinni.soapproyectobase.controladores;


import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.servicios.ServicioCiudadano;
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
@RequestMapping("/api/ciudadano")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class ControladorCiudadanoANG {
    private static final Logger logger = LogManager.getLogger(ControladorCiudadano.class);


    private ServicioCiudadano servicioCiudadano;

    @GetMapping("/")
    public ResponseEntity<List<CiudadanoDto>> listarCiudadano(){

        return ResponseEntity.ok(servicioCiudadano.obtenerCiudadano());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<CiudadanoDto> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicioCiudadano.obtenerCiudadano(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CiudadanoDto> crear(@Validated @RequestBody CiudadanoDto entityDto) {
        entityDto = servicioCiudadano.registrar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CiudadanoDto> modificar(@Validated @RequestBody CiudadanoDto entityDto) {
        entityDto = servicioCiudadano.actualizar(entityDto);

        return new ResponseEntity<>(entityDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicioCiudadano.eliminar(serial);
    }

}
