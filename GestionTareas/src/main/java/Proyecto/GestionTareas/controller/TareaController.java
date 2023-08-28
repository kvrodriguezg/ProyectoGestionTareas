package Proyecto.GestionTareas.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import Proyecto.GestionTareas.model.entity.Tarea;
import Proyecto.GestionTareas.model.entity.Usuario;
import Proyecto.GestionTareas.model.repository.IUsuarioRepository;
import Proyecto.GestionTareas.model.service.TareaService;
import Proyecto.GestionTareas.model.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TareaController {

    @Autowired
    private TareaService tareaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
	@Autowired
	private IUsuarioRepository user;

    @GetMapping("/tareas")
    public ModelAndView mostrarTareas() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        
        List<Tarea> tareas = null;
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Administrativo"))) {
            tareas = tareaService.findAll();
        } else if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Usuario"))) {
            tareas = tareaService.findAllByUsuarioUsername(auth.getName());
        }
        
        ModelAndView modelAndView = new ModelAndView("tareas");
        modelAndView.addObject("tareas", tareas);
        return modelAndView;
    }

	//Retornamos vista para crear tarea.
    @RequestMapping(path = "/crear_tarea", method = RequestMethod.GET)
    public ModelAndView mostrarCrearTarea() {
    	
		//Creamos ArrayList y le asignamos objetos mediante el método obtenerClientes.
    	ArrayList<Usuario> listaUsuarios = new ArrayList<>(usuarioService.findAll().size());
    	listaUsuarios.addAll(usuarioService.findAll());
		
		//Asignamos el atributo.
        ModelAndView modelAndView = new ModelAndView("crear_tarea");
        modelAndView.addObject("usuarios", listaUsuarios);
        return modelAndView;
    }
    
	@PostMapping(value= "/tareaCreada")
    public ModelAndView mostrarTareaCreada(@RequestParam String nombre, @RequestParam String descripcion, @RequestParam String fecha, @RequestParam int usuario_id) {
		
			Usuario usuario = user.findById(usuario_id).orElse(null);
			
			//Obtenemos datos de creación de tarea.	
		    if (usuario != null) {
		        Tarea nuevaTarea = new Tarea();
		        nuevaTarea.setNombre(nombre);
		        nuevaTarea.setDescripcion(descripcion);
		        nuevaTarea.setFecha(fecha);
		        nuevaTarea.setUsuario(usuario);

		        tareaService.crearTarea(nuevaTarea);
		    }

		    return new ModelAndView("tarea_creada");
    }
}
