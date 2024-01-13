package main.java.com.aabate.scuolacalcio.model;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Ruolo")
public class Ruolo {

    public Ruolo() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Id   
    @Column(name="name")    
    private String name;

}