package nl.novi.springboot.first_demo.service;

import nl.novi.springboot.first_demo.exception.RecordNotFoundException;
import nl.novi.springboot.first_demo.model.Cursus;
import nl.novi.springboot.first_demo.model.Student;
import nl.novi.springboot.first_demo.repository.CursusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursusServiceImpl implements CursusService {

    @Autowired
    CursusRepository cursusRepository;

    @Override
    public List<Cursus> getCursussenByName(String name) {
        if (name == null || name.isEmpty())
            return cursusRepository.findAll();
        else
            return cursusRepository.findByNaamStartingWithOrderByNaam(name);
    }

    @Override
    public Cursus getCursusById(long id) {
        if (cursusRepository.existsById(id)) {
            return cursusRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
