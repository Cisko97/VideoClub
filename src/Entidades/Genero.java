/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Simon
 */
@Entity
@Table(name = "tbl_genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByIdGenero", query = "SELECT g FROM Genero g WHERE g.idGenero = :idGenero"),
    @NamedQuery(name = "Genero.findByNombre", query = "SELECT g FROM Genero g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Genero.findByDescripcion", query = "SELECT g FROM Genero g WHERE g.descripcion = :descripcion")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id_Genero")
    private Integer idGenero;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGenero")
    private List<Pelicula> peliculaList;

    public Genero() {
    }

    public Genero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Genero(Integer idGenero, String nombre) {
        this.idGenero = idGenero;
        this.nombre = nombre;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Pelicula> getPeliculaList() {
        return peliculaList;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGenero != null ? idGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.idGenero == null && other.idGenero != null) || (this.idGenero != null && !this.idGenero.equals(other.idGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BaseDeDatos.Genero[ idGenero=" + idGenero + " ]";
    }
    
}
