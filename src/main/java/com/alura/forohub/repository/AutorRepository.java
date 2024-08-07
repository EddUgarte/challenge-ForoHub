package com.alura.forohub.repository;

import com.alura.forohub.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
    UserDetails findByEmail(String username);
}
