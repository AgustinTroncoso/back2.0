package com.example.corazondelatorback.Repository;

import com.example.corazondelatorback.Model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<Comic, Long> {
}
