package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Dictionary;
import com.example.corazondelatorback.Model.Encyclopedia;
import com.example.corazondelatorback.Repository.BorrowRepository;
import com.example.corazondelatorback.Repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service


public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    @Autowired
    public DictionaryService(DictionaryRepository dictionaryRepository){
        this.dictionaryRepository = dictionaryRepository;
    }

    public List<Dictionary> DictionaryList(){
        return dictionaryRepository.findAll();
    }

    public String AddDictionary(@RequestBody Dictionary dictionary){
        dictionaryRepository.save(dictionary);
        return "Diccionario Creado";
    }

    public String deleteDictionary(Long dictionaryId) {
        dictionaryRepository.deleteById(dictionaryId);
        return "dictionary eliminado";
    }

    public String updateDictionary(Long dictionaryId, @RequestBody Dictionary updatedDictionary) {
        Dictionary existingDictionary = dictionaryRepository.findById(dictionaryId)
                .orElseThrow(() -> new RuntimeException("No se encontró el cómic con id: " + dictionaryId));

        // Actualiza los campos necesarios
        existingDictionary.setAuthor(updatedDictionary.getAuthor());
        existingDictionary.setTitle(updatedDictionary.getTitle());
        existingDictionary.setPublicationDate(updatedDictionary.getPublicationDate());
        existingDictionary.setEdition(updatedDictionary.getEdition());
        existingDictionary.setEditor(updatedDictionary.getEditor());
        existingDictionary.setCategory(updatedDictionary.getCategory());
        existingDictionary.setLanguage(updatedDictionary.getLanguage());
        existingDictionary.setImage(updatedDictionary.getImage());
        // ... actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        dictionaryRepository.save(existingDictionary);

        return "dictionary actualizado";
    }

}
