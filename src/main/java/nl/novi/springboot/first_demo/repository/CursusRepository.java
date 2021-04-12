package nl.novi.springboot.first_demo.repository;

import nl.novi.springboot.first_demo.model.Cursus;
import nl.novi.springboot.first_demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursusRepository extends JpaRepository<Cursus, Long> {

    List<Cursus> findByNaamStartingWithOrderByNaam(String name);

}
