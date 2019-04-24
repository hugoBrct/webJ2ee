package beans;

import java.sql.Timestamp;

public class User {


    private Long      id;
    private String    email;
    private String    password;
    private Timestamp dateInscription;
    private String    role;

    public Long getId() {
        return id;
    }
    public void setId( Long id ) {
        this.id = id;
    }

    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPassword( String motDePasse ) {
        this.password = motDePasse;
    }
    public String getPassword() {
        return password;
    }

    public Timestamp getDateInscription() {
        return dateInscription;
    }
    public void setDateInscription( Timestamp dateInscription ) {
        this.dateInscription = dateInscription;
    }

    public String getRole(){ return role; }
    public void setRole(String role){ this.role = role; }
}
