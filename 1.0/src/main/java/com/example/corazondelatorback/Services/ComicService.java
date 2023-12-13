package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class ComicService {

    private final ComicRepository comicRepository;

    @Autowired
    public ComicService(ComicRepository comicRepository){
        this.comicRepository = comicRepository;
    }

    public String AddComic(@RequestBody Comic comic){
        comicRepository.save(comic);
        return "Comic agregado";
    }
    public String deleteComic(Long comicId) {
        comicRepository.deleteById(comicId);
        return "Comic eliminado";
    }

    public String updateComic(Long comicId, @RequestBody Comic updatedComic) {
        Comic existingComic = comicRepository.findById(comicId)
                .orElseThrow(() -> new RuntimeException("No se encontró el cómic con id: " + comicId));

        // Actualiza los campos necesarios
        existingComic.setAuthor(updatedComic.getAuthor());
        existingComic.setTitle(updatedComic.getTitle());
        existingComic.setPublicationDate(updatedComic.getPublicationDate());
        existingComic.setEdition(updatedComic.getEdition());
        existingComic.setGenre(updatedComic.getGenre());
        existingComic.setImage(updatedComic.getImage());

        // ... actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        comicRepository.save(existingComic);

        return "Comic actualizado";
    }

    public List<Comic> ComicList(){
        return comicRepository.findAll();
    }


}
