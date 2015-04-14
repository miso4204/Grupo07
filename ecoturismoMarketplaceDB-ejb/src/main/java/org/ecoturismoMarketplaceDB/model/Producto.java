package org.ecoturismoMarketplaceDB.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
@Entity
@Table(name = "PRODUCTO")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findByCategoria", query = "SELECT p FROM Producto p WHERE p.idCategoria.id = :idCategoria"),
    @NamedQuery(name = "Imagen.countByCategoria", query = "SELECT COUNT(p) FROM Producto p WHERE p.idCategoria.id = :idCategoria")
})

public class Producto implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private long codigo;
 
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
    
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idProveedor;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ubicacion idUbicacion;
    
    @JoinColumn(name = "id_categoria", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Categoria idCategoria;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
   
    @Column(name = "impuestos")
    private float impuestos;

    
    public Producto() {
    	
    }

    public Producto(Integer id) {
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
    
    public Usuario getIdProveedor() {
        return idProveedor;
    }
 
    public void setIdProveedor(Usuario idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
    
    public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Ubicacion getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Ubicacion idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public float getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(float impuestos) {
		this.impuestos = impuestos;
	}

	@Override
    public String toString() {
        return "marketplace.user.model.Producto[ nombre=" + nombre + " ]";
    }
    
    
}
