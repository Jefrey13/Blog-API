package com.sistema.blog.repositories;

import com.sistema.blog.models.publications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface publicationRepository extends JpaRepository<publications, Long> {
}
