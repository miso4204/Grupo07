package org.ecoturismoMarketplaceDB.model.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan David
 */
@XmlRootElement(name = "categoria")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriaDto {

    private Integer id;
    private String nombre;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
