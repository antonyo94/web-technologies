package main.java.com.aabate.scuolacalcio.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "Allievo")
public class Allievo {

    public Allievo() {
    }

    public String getNumeroTesserino() {
        return numeroTesserino;
    }

    public String getNomeAllievo() {
        return nomeAllievo;
    }

    public String getCognomeAllievo() {
        return cognomeAllievo;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public String getVia() {
        return via;
    }

    public String getCap() {
        return cap;
    }

    public String getCitta() {
        return citta;
    }

    public Genitore getGenitore() {
        return genitore;
    }

    public void setNumeroTesserino(String numeroTesserino) {
        this.numeroTesserino = numeroTesserino;
    }

    public void setNomeAllievo(String nomeAllievo) {
        this.nomeAllievo = nomeAllievo;
    }

    public void setCognomeAllievo(String cognomeAllievo) {
        this.cognomeAllievo = cognomeAllievo;
    }

    public void setDataNascita(Date dataNascita) throws ParseException {

        this.dataNascita=dataNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setGenitore(Genitore genitore) {
        this.genitore = genitore;
    }

    @Override
    public String toString() {
        return "Allievo{" + "numeroTesserino=" + numeroTesserino + ", nomeAllievo=" + nomeAllievo + ", cognomeAllievo=" + cognomeAllievo + ", dataNascita=" + dataNascita + ", luogoNascita=" + luogoNascita + ", via=" + via + ", cap=" + cap + ", citta=" + citta + ", genitore=" + genitore + '}';
    }
    
    

    @Id
    @NotEmpty
    @Column(name = "numeroTesserino")
    private String numeroTesserino;

    @Column(name = "nomeAllievo")
    @NotEmpty
    private String nomeAllievo;

    @Column(name = "cognomeAllievo")
    @NotEmpty
    private String cognomeAllievo;

    @Column(name = "dataNascita")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dataNascita;

    @Column(name = "luogoNascita")
    private String luogoNascita;

    @Column(name = "via")
    @NotEmpty
    private String via;

    @Column(name = "cap")
    @NotEmpty
    private String cap;

    @Column(name = "citta")
    @NotEmpty
    private String citta;
    

    @ManyToOne
    @JoinColumn(name = "cf_g")
    private Genitore genitore;
    
    @OneToMany(mappedBy = "numTesserino",cascade= {CascadeType.REMOVE})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private static final List<Pagamento> listaPagamenti=new ArrayList<Pagamento>();

}
