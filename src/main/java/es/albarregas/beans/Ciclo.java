package es.albarregas.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author Maria
 */
@Entity
@Table(name = "ciclosA1an")
public class Ciclo implements Serializable {

    //FALTA LOS NOT NULL
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idCiclo")
    private int idCiclo;
    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;

    //ESTO ME PUEDE DAR FALLOS OJO 
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "idDeCiclo")
    @OrderColumn(name = "idx")
    private List<Modulo> modulos;

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        if (this.modulos == null) {
            this.modulos = new ArrayList<>();
        }
        this.modulos = modulos;
    }

    public void setModulo(Modulo modulo) {
        if (this.modulos == null) {
            this.modulos = new ArrayList<>();
        }
        this.modulos.add(modulo);
    }

}
