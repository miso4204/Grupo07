package org.ecoturismoMarketplaceDB.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "UBICACION")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u")
})

public class Ubicacion implements Serializable {
 
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
 
    @Column(name = "longitud")
    private double longitud;

    @Column(name = "latitud")
    private double latitud;

    public Ubicacion() {
    	
    }

    public Ubicacion(Integer id) {
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
 
    public double getLongitud() {
        return longitud;
    }
 
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    public double getLatitud() {
        return latitud;
    }
 
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    
    
    @Override
    public String toString() {
        return "marketplace.user.model.Ubicacion[ nombre=" + nombre + " ]";
    }
    
    
}
