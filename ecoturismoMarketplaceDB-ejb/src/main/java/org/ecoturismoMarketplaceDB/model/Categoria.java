package org.ecoturismoMarketplaceDB.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "CATEGORIA")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
})

public class Categoria implements Serializable {
 
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
    @Column(name = "descripcion")
    private String descripcion;

    public Categoria() {
    	
    }

    public Categoria(Integer id) {
        this.id = id;
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
 
    public String getDescripcion() {
        return descripcion;
    }
 
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    @Override
    public String toString() {
        return "marketplace.user.model.Categoria[ nombre=" + nombre + " ]";
    }
    
    
}
