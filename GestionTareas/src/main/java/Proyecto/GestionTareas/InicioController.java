package Proyecto.GestionTareas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

    /**
     * Maneja las solicitudes que se le hacen a la raíz del sitio
     * 
     * @return un objeto {@link ModelAndView} con la respuesta al cliente
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView mostrarInicio() {
        return new ModelAndView("inicio");
    }
    
    @RequestMapping(path = "/inicio", method = RequestMethod.GET)
    public ModelAndView mostrarInicio2() {
        return new ModelAndView("inicio");
    }

}
