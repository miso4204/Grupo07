package org.ecoturismoMarketplaceDB.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan David
 */
@Entity
@Table(name = "IMAGEN")
//@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagen.findAll", query = "SELECT i FROM Imagen i"),
    @NamedQuery(name = "Imagen.findById", query = "SELECT i FROM Imagen i WHERE i.id = :id"),
    @NamedQuery(name = "Imagen.findByProducto", query = "SELECT i FROM Imagen i WHERE i.idProducto.id = :idProducto"),
    @NamedQuery(name = "Imagen.countByProduto", query = "SELECT COUNT(i) FROM Imagen i WHERE i.idProducto.id = :idProducto"),
    @NamedQuery(name = "Imagen.findByUbicacionImagen", query = "SELECT i FROM Imagen i WHERE i.ubicacionImagen = :ubicacionImagen")})

public class Imagen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "ubicacion_imagen")
    private String ubicacionImagen;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto idProducto;

    public Imagen() {
    }

    public Imagen(Integer id) {
        this.id = id;
    }

    public Imagen(Integer id, String ubicacionImagen) {
        this.id = id;
        this.ubicacionImagen = ubicacionImagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacionImagen() {
        return ubicacionImagen;
    }

    public void setUbicacionImagen(String ubicacionImagen) {
        this.ubicacionImagen = ubicacionImagen;
    }

    public Producto getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagen)) {
            return false;
        }
        Imagen other = (Imagen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagen[ id=" + id + " ]";
    }
    
}