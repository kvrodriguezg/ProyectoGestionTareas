package Proyecto.GestionTareas.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import Proyecto.GestionTareas.model.entity.Tarea;
import Proyecto.GestionTareas.model.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

	Tarea findByUsername(String username);

}
