package org.ecoturismoMarketplaceDB.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "USUARIO")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellidos", query = "SELECT u FROM Usuario u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuario.findByToken", query = "SELECT u FROM Usuario u WHERE u.token = :token"),
    @NamedQuery(name = "Usuario.findByUserPass", query = "SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password")
})

public class Usuario implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "correo")
    private String correo;
 
    @Size(min = 1, max = 200)
    @Column(name = "direccion")
    private String direccion;
    
    @Size(min = 1, max = 200)
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "rol")
    private String rol;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "username")
    private String username;
 
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "password")
    private String password;
    
    @Size(min = 1, max = 256)
    @Column(name = "token")
    private String token;

    public Usuario() {
    	
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
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
    
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getApellidos() {
        return apellidos;
    }
 
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getCorreo() {
        return correo;
    }
 
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getDireccion() {
        return direccion;
    }
 
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getRol() {
        return rol;
    }
 
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getTelefono() {
        return telefono;
    }
 
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
    public String toString() {
        return "marketplace.user.model.Usuario[ id=" + id + " ]";
    }
    
    
}
