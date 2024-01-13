package main.java.com.aabate.scuolacalcio.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Utente")
public class Utente {

    public Utente() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Ruolo> getRoles() {
        return roles;
    }

    public void setRoles(List<Ruolo> roles) {
        this.roles = roles;
    }

    

    
    @Id
    @NotEmpty
    @Column(name = "username")
    private String username;
    
    @Column(name="password")
    @NotEmpty
    private String password;
    
    @Column(name ="roles")
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "Ruoli_Utenti",
            joinColumns = @JoinColumn(name = "usename_id"),
            inverseJoinColumns = @JoinColumn(name = "nome_ruolo_id"))
    private  List<Ruolo> roles=new ArrayList<Ruolo>();
}