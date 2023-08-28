package Proyecto.GestionTareas.model.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Proyecto.GestionTareas.model.entity.Tarea;
import Proyecto.GestionTareas.model.entity.Usuario;
import Proyecto.GestionTareas.model.repository.ITareaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;

@Service
public class TareaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ITareaRepository tarea;
    
    public List<Tarea> findAllByUsuarioUsername(String username) {
        TypedQuery<Usuario> usuarioQuery = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class);
        usuarioQuery.setParameter("username", username);
        Usuario usuario = usuarioQuery.getSingleResult();

        TypedQuery<Tarea> tareaQuery = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.usuario.id = :usuarioId", Tarea.class);
        tareaQuery.setParameter("usuarioId", usuario.getId());

        return tareaQuery.getResultList();
    }

    public List<Tarea> findAll() {
        TypedQuery<Tarea> query = entityManager.createQuery("SELECT u FROM Tarea u", Tarea.class);
        return query.getResultList();
    }
    
    public void crearTarea(Tarea nuevaTarea) {
    	
    	tarea.save(nuevaTarea);
    }
}

