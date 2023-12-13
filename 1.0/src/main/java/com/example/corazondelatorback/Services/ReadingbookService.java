package com.example.corazondelatorback.Services;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Encyclopedia;
import com.example.corazondelatorback.Model.ReadingBook;
import com.example.corazondelatorback.Repository.BorrowRepository;
import com.example.corazondelatorback.Repository.ReadingbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service


public class ReadingbookService {

    private final ReadingbookRepository readingbookRepository;

    @Autowired
    public ReadingbookService(ReadingbookRepository readingbookRepository){
        this.readingbookRepository = readingbookRepository;
    }

    public List<ReadingBook> ReadingbookList(){
        return readingbookRepository.findAll();
    }

    public String AddReadingbook(@RequestBody ReadingBook readingBook){
        readingbookRepository.save(readingBook);
        return "Readingbook Guardado";
    }
    public String deleteReadingbook(Long readingbookId) {
        readingbookRepository.deleteById(readingbookId);
        return "readingbook eliminado";
    }

    public String updateReadingbook(Long readingbookId, @RequestBody ReadingBook updatedReadingbook) {
        ReadingBook existingReadingbook = readingbookRepository.findById(readingbookId)
                .orElseThrow(() -> new RuntimeException("No se encontró el cómic con id: " + readingbookId));

        // Actualiza los campos necesarios
        existingReadingbook.setAuthor(updatedReadingbook.getAuthor());
        existingReadingbook.setTitle(updatedReadingbook.getTitle());
        existingReadingbook.setPublicationDate(updatedReadingbook.getPublicationDate());
        existingReadingbook.setEdition(updatedReadingbook.getEdition());
        existingReadingbook.setGenre(updatedReadingbook.getGenre());
        existingReadingbook.setLanguage(updatedReadingbook.getLanguage());
        existingReadingbook.setImage(updatedReadingbook.getImage());

        // ... actualiza otros campos según sea necesario

        // Guarda los cambios en la base de datos
        readingbookRepository.save(existingReadingbook);

        return "redaingbook actualizado";
    }

}
