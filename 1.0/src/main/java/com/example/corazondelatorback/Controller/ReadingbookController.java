package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Newspaper;
import com.example.corazondelatorback.Model.ReadingBook;
import com.example.corazondelatorback.Services.ReadingbookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReadingbookController {

    private final ReadingbookService readingbookService;

    public ReadingbookController(ReadingbookService readingbookService){
        this.readingbookService = readingbookService;
    }

    @GetMapping(value = "/getReadingbook")
    public List<ReadingBook> getAllReadingbook(){
        return readingbookService.ReadingbookList();
    }
    @PostMapping(value = "/addReadingbook")
    public String addReadingbook(@RequestBody ReadingBook readingBook){
        return readingbookService.AddReadingbook(readingBook);
    }

    @DeleteMapping("/deleteReadingbook/{id}")
    public String deleteReadingbook(@PathVariable Long id) {
        return readingbookService.deleteReadingbook(id);
    }

    @PutMapping("/updateReadingbook/{id}")
    public String updateReadingbook(@PathVariable Long id, @RequestBody ReadingBook updatedReadingbook) {
        return readingbookService.updateReadingbook(id, updatedReadingbook);
    }
}
