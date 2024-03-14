package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.servicios.ServicioCiudadano;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
public class ControladorCiudadano {
    private static final Logger logger = LogManager.getLogger(ControladorCiudadano.class);

    @Autowired
    ServicioCiudadano servicioCiudadano;

    @GetMapping({  "/ciudadano"})
    public String listarCiudadano(Model model){
        logger.info("Verificando ");
        model.addAttribute("ciudadano", servicioCiudadano.obtenerCiudadano());
        return "ciudadano";
    }
    @GetMapping("/ciudadano/nuevo")
    public String mostrarFormulario(Model model){
        CiudadanoDto ciudadanoDto = new CiudadanoDto();
        model.addAttribute("ciudadano", ciudadanoDto);
        return "crear_ciudadano";
    }
    @PostMapping("/ciudadano")
    public String registrarCiudadano(@ModelAttribute("ciudadano") CiudadanoDto ciudadano) {
        servicioCiudadano.registrar(ciudadano);
        return "redirect:/ciudadano";
    }


    @GetMapping("/ciudadano/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        CiudadanoDto ciudadanoDto = new CiudadanoDto();
        model.addAttribute("ciudadano", servicioCiudadano.obtenerCiudadano(serial));
        return "editar_ciudadano";
    }

    @PostMapping("/ciudadano/{serial}")
    public String modificarCiudadano(@PathVariable long serial, @ModelAttribute( "ciudadano") CiudadanoDto ciudadanoDto, Model model){


        model.addAttribute("ciudadano", servicioCiudadano.actualizar(ciudadanoDto));
        return "redirect:/ciudadano";
    }
    @GetMapping("/ciudadano/{serial}")
    public String eliminarCiudadano(@PathVariable long serial){

        servicioCiudadano.eliminar(serial);

        return "redirect:/ciudadano";
    }
}
