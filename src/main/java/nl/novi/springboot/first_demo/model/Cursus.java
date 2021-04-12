package nl.novi.springboot.first_demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursussen")
public class Cursus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String naam;

    @Column
    private String docent;

    @OneToMany(mappedBy = "cursus")
    List<StudentCursus> student_cursus;

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getDocent() {
        return docent;
    }

    public void setDocent(String docent) {
        this.docent = docent;
    }

    public List<StudentCursus> getStudent_cursus() {
        return student_cursus;
    }

    public void setStudent_cursus(List<StudentCursus> student_cursus) {
        this.student_cursus = student_cursus;
    }
}
