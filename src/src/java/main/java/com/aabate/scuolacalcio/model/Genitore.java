package main.java.com.aabate.scuolacalcio.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;




@Entity
@Table(name = "Genitore")
public class Genitore {

    public String getCf() {
        return cf;
    }

    public String getNomeGenitore() {
        return nomeGenitore;
    }

    public String getCognomeGenitore() {
        return cognomeGenitore;
    }

    public String getEmail() {
        return email;
    }



    public static List<TelefonoGenitore> getNumeriTelefono() {
        return numeriTelefono;
    }

    public static List<Allievo> getAllievi() {
        return allievi;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setNomeGenitore(String nomeGenitore) {
        this.nomeGenitore = nomeGenitore;
    }

    public void setCognomeGenitore(String cognomeGenitore) {
        this.cognomeGenitore = cognomeGenitore;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Id
    @Column(name = "cf")
    private String cf;

    @Column(name = "nomeGenitore")
    private String nomeGenitore;

    @Column(name = "cognomeGenitore")
    private String cognomeGenitore;

    @Column(name="email",unique=true)
    private String email;

    @OneToMany(mappedBy = "genitore",cascade= {CascadeType.REMOVE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private static final List<TelefonoGenitore> numeriTelefono = new ArrayList<TelefonoGenitore>();
    
    @OneToMany(mappedBy = "genitore",cascade= {CascadeType.REMOVE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private static final List<Allievo> allievi = new ArrayList<Allievo>();
}
