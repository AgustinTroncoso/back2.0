package com.example.corazondelatorback.Repository;
import com.example.corazondelatorback.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
