package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.model.Cursus;
import nl.novi.springboot.first_demo.model.Student;

import java.util.List;

public interface CursusService {

    List<Cursus> getCursussenByName(String name);
    Cursus getCursusById(long id);

}
