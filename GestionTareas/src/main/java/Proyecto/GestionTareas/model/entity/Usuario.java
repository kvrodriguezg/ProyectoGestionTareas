package Proyecto.GestionTareas.model.entity;
import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String rol;

    // Constructor, getters y setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
    public String getUsername() {
        return username;
    }

	public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
        return password;
    }
    
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}




