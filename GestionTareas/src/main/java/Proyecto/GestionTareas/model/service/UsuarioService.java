package Proyecto.GestionTareas.model.service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import Proyecto.GestionTareas.model.entity.Usuario;


@Service
public class UsuarioService{


    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> findAll() {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }   
    
}