package nl.novi.springboot.first_demo.repository;

import nl.novi.springboot.first_demo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {
}
