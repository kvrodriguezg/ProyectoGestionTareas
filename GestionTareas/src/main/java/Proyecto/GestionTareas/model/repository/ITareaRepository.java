package Proyecto.GestionTareas.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import Proyecto.GestionTareas.model.entity.Tarea;

public interface ITareaRepository extends JpaRepository<Tarea,Integer> {

	
}
