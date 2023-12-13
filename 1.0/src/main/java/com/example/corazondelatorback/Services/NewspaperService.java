package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Newspaper;
import com.example.corazondelatorback.Repository.BorrowRepository;
import com.example.corazondelatorback.Repository.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service


public class NewspaperService {

    private final NewspaperRepository newspaperRepository;

    public void saveNewspaper(Newspaper newspaper) {
        newspaperRepository.save(newspaper);
    }
    public List<Newspaper> newsPaperList(){
        return newspaperRepository.findAll();
    }
    @Autowired
    public NewspaperService(NewspaperRepository newspaperRepository){
        this.newspaperRepository = newspaperRepository;
    }

    public String AddNewspaper(@RequestBody Newspaper newspaper){
        newspaperRepository.save(newspaper);
        return "Newspaper guardado";
    }
    public String deleteNewspaper(Long newspaperId) {
        newspaperRepository.deleteById(newspaperId);
        return "newspaper eliminado";
    }

    public String updateNewspaper(Long newspaperId, @RequestBody Newspaper updatedNewspaper) {
        try{
            Newspaper existingNewspaper = newspaperRepository.findById(newspaperId)
                    .orElseThrow(() -> new RuntimeException("No se encontró el cómic con id: " + newspaperId));

            // Actualiza los campos necesarios
            existingNewspaper.setTitle(updatedNewspaper.getTitle());
            existingNewspaper.setBrand(updatedNewspaper.getBrand());
            existingNewspaper.setPublicationDate(updatedNewspaper.getPublicationDate());
            existingNewspaper.setEdition(updatedNewspaper.getEdition());
            existingNewspaper.setEditor(updatedNewspaper.getEditor());
            existingNewspaper.setImage(updatedNewspaper.getImage());
            // ... actualiza otros campos según sea necesario

            // Guarda los cambios en la base de datos
            newspaperRepository.save(existingNewspaper);

            return "Comic actualizado";
        }catch (Exception e) {
            throw new RuntimeException("Error al actualizar el periódico", e);
        }

    }

}
