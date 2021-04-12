package nl.novi.springboot.first_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 80)
    private String voornaam;

    @Column(length = 80)
    private String achternaam;

    @Column(length = 20, nullable = false)
    private String studienummer;

    @Column(length = 80)
    private String woonplaats;

    @Column(length = 20)
    private String telefoonnummer;

    @ManyToMany
    @JsonIgnoreProperties("studenten")
    List<Cursus> cursussen;

    // constructors
    public Student() {
    }

    public Student(long id, String voornaam, String achternaam, String studienummer, String woonplaats, String telefoonnummer) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.studienummer = studienummer;
        this.woonplaats = woonplaats;
        this.telefoonnummer = telefoonnummer;
    }

    // getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getStudienummer() {
        return studienummer;
    }

    public void setStudienummer(String studienummer) {
        this.studienummer = studienummer;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public List<Cursus> getCursussen() {
        return cursussen;
    }

    public void setCursussen(List<Cursus> cursussen) {
        this.cursussen = cursussen;
    }

}
