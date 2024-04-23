package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.CiudadanoDto;
import co.vinni.soapproyectobase.dto.PadreDto;
import co.vinni.soapproyectobase.servicios.ServicioCiudadano;
import co.vinni.soapproyectobase.servicios.ServicioPadre;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class ControladorPadre {
    private static final Logger logger = LogManager.getLogger(ControladorPadre.class);

    @Autowired
    ServicioPadre servicioPadre;

    @GetMapping({  "/padre"})
    public String listarPadre(Model model){
        logger.info("Verificando ");
        model.addAttribute("padre", servicioPadre.obtenerPadre());
        return "padre";
    }
    @GetMapping("/padre/nuevo")
    public String mostrarFormulario(Model model){
        PadreDto padreDto = new PadreDto();
        model.addAttribute("padre", padreDto);
        return "crear_padre";
    }
    @PostMapping("/padre")
    public String registrarPadre(@ModelAttribute("padre") PadreDto padre) {
        servicioPadre.registrar(padre);
        return "redirect:/padre";
    }


    @GetMapping("/padre/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        PadreDto padreDto = new PadreDto();
        model.addAttribute("padre", servicioPadre.obtenerPadre(serial));
        return "editar_padre";
    }

    @PostMapping("/padre/{serial}")
    public String modificarPadre(@PathVariable long serial, @ModelAttribute( "padre") PadreDto padreDto, Model model){


        model.addAttribute("padre", servicioPadre.actualizar(padreDto));
        return "redirect:/padre";
    }
    @GetMapping("/padre/{serial}")
    public String eliminarPadre(@PathVariable long serial){

        servicioPadre.eliminar(serial);

        return "redirect:/padre";
    }
}
