
package main.java.com.aabate.scuolacalcio.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Pagamento")
public class Pagamento {

    public int getId() {
        return id;
    }

    public Double getImporto() {
        return importo;
    }

    public Allievo getNumTesserino() {
        return numTesserino;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImporto(Double importo) {
        this.importo = importo;
    }

    public void setNumTesserino(Allievo numTesserino) {
        this.numTesserino = numTesserino;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
    
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;
    
    @Column(name="importo")
    @NotNull
    @Min(value=1)
    private Double importo;
    
    @ManyToOne
    @JoinColumn(name = "numTesserino")
    private Allievo numTesserino;
    
    @Column(name="dataPagamento")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPagamento;
}
