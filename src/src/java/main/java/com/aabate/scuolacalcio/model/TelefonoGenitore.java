package main.java.com.aabate.scuolacalcio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TelefonoGenitore")
public class TelefonoGenitore implements Serializable {

    public TelefonoGenitore() {
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public Genitore getGenitore() {
        return genitore;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setGenitore(Genitore genitore) {
        this.genitore = genitore;
    }
    
    


    @Override
    public String toString() {
        return "TelefonoGenitore{" + "numero=" + genitore.toString();
    }

    @Id
    @Column(name="numeroTelefono")
    private String numeroTelefono;

    @ManyToOne
    @JoinColumn(name = "cf_g")
    private Genitore genitore;
}
