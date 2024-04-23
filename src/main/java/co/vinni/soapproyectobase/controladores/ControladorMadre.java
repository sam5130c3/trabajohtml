package co.vinni.soapproyectobase.controladores;

import co.vinni.soapproyectobase.dto.MadreDto;
import co.vinni.soapproyectobase.servicios.ServicioMadre;
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
public class ControladorMadre {
    private static final Logger logger = LogManager.getLogger(ControladorMadre.class);

    @Autowired
    ServicioMadre servicioMadre;

    @GetMapping({  "/madre"})
    public String listarMadre(Model model){
        logger.info("Verificando ");
        model.addAttribute("madre", servicioMadre.obtenerMadre());
        return "madre";
    }
    @GetMapping("/madre/nuevo")
    public String mostrarFormulario(Model model){
        MadreDto madreDto = new MadreDto();
        model.addAttribute("madre", madreDto);
        return "crear_madre";
    }
    @PostMapping("/madre")
    public String registrarMadre(@ModelAttribute("madre") MadreDto madre) {
        servicioMadre.registrar(madre);
        return "redirect:/madre";
    }


    @GetMapping("/madre/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        MadreDto madreDto = new MadreDto();
        model.addAttribute("madre", servicioMadre.obtenerMadre(serial));
        return "editar_madre";
    }

    @PostMapping("/madre/{serial}")
    public String modificarMadre(@PathVariable long serial, @ModelAttribute( "madre") MadreDto madreDto, Model model){


        model.addAttribute("madre", servicioMadre.actualizar(madreDto));
        return "redirect:/madre";
    }
    @GetMapping("/madre/{serial}")
    public String eliminarMadre(@PathVariable long serial){

        servicioMadre.eliminar(serial);

        return "redirect:/madre";
    }
}
