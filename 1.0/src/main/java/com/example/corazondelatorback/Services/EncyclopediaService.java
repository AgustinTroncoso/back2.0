package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Encyclopedia;
import com.example.corazondelatorback.Repository.BorrowRepository;
import com.example.corazondelatorback.Repository.EncyclopediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class EncyclopediaService {

    private final EncyclopediaRepository encyclopediaRepository;

    @Autowired
    public EncyclopediaService(EncyclopediaRepository encyclopediaRepository){
        this.encyclopediaRepository = encyclopediaRepository;
    }

    public List<Encyclopedia> EncyclopediaList(){
        return encyclopediaRepository.findAll();
    }

    public String AddEncyclopedia(@RequestBody Encyclopedia encyclopedia){
        encyclopediaRepository.save(encyclopedia);
        return "encyclopedia Guardada";
    }
    public String deleteEncyclopedia(Long encyclopediaId) {
        encyclopediaRepository.deleteById(encyclopediaId);
        return "encyclopedia eliminado";
    }

    public String updateEncyclopedia(Long encyclopediaId, @RequestBody Encyclopedia updatedEncyclopedia) {
        Encyclopedia existingEncyclopedia = encyclopediaRepository.findById(encyclopediaId)
                .orElseThrow(() -> new RuntimeException("No se encontró el cómic con id: " + encyclopediaId));

        // Actualiza los campos necesarios
        existingEncyclopedia.setTitle(updatedEncyclopedia.getTitle());
        existingEncyclopedia.setEncyclopediaType(updatedEncyclopedia.getEncyclopediaType());
        existingEncyclopedia.setLanguage(updatedEncyclopedia.getLanguage());
        existingEncyclopedia.setAuthor(updatedEncyclopedia.getAuthor());
        existingEncyclopedia.setPublicationDate(updatedEncyclopedia.getPublicationDate());
        existingEncyclopedia.setEdition(updatedEncyclopedia.getEdition());
        existingEncyclopedia.setImage(updatedEncyclopedia.getImage());

        // ... actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        encyclopediaRepository.save(existingEncyclopedia);

        return "encyclopedia actualizado";
    }

}
