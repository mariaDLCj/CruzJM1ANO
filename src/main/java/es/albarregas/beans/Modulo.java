package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Maria
 */
@Entity
@Table(name = "modulosA1an")
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idModulo")
    private int idModulo;

    @Column(name = "denominacion", length = 30, nullable = false)
    private String denominacion;
    
    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idModulo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modulo other = (Modulo) obj;
        return this.idModulo == other.idModulo;
    }
    
    
    
    
    
}
