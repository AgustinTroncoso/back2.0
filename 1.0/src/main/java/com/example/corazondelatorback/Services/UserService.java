package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Encyclopedia;
import com.example.corazondelatorback.Model.User;
import com.example.corazondelatorback.Repository.BorrowRepository;
import com.example.corazondelatorback.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    // Metodos

    public List<User> UserList(){
        return userRepository.findAll();
    }

    public String adminCreate(@RequestBody User user){
        userRepository.save(user);
        return "user agregado";

    }
    public String deleteUser(Long userId){
        userRepository.deleteById(userId);
        return "User eliminado";
    }
    public User getUserById(Long userId) {
        // Implementa la lógica para obtener el usuario por su ID desde el repositorio
        return userRepository.findById(userId).orElse(null);
    }

    public String updateUser(Long userId, @RequestBody User updatedUser) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con id: " + userId));

        // Actualiza los campos necesarios
        existingUser.setUser(updatedUser.getUser());
        //existingUser.setPassword(updatedUser.getPassword());
        existingUser.setName(updatedUser.getName());
        existingUser.setPosition(updatedUser.getPosition());
        //existingUser.setCreationDate(updatedUser.getCreationDate());
        existingUser.setGenre(updatedUser.getGenre());


        // ... actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        userRepository.save(existingUser);

        return "User actualizado";
    }



}
