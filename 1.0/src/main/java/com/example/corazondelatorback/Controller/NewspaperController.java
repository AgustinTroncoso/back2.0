package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Newspaper;
import com.example.corazondelatorback.Services.NewspaperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController

public class NewspaperController {

    private final NewspaperService newspaperService;

    public NewspaperController(NewspaperService newspaperService){
        this.newspaperService = newspaperService;
    }

    @GetMapping(value = "/getNewspaper")
    public List<Newspaper> getAllNewsPaper(){
        return newspaperService.newsPaperList();
    }

    @PostMapping(value = "/addNewspaper")
    public String Newspaper(@RequestBody Newspaper newspaper){
        return newspaperService.AddNewspaper(newspaper);
    }

    @DeleteMapping("/deleteNewspaper/{id}")
    public String deleteNewspaper(@PathVariable Long id) {
        return newspaperService.deleteNewspaper(id);
    }

    @PutMapping("/updateNewspaper/{id}")
    public ResponseEntity<String> updateNewspaper(@PathVariable Long id, @RequestBody Newspaper updatedNewspaper) {
        try {
            String result = newspaperService.updateNewspaper(id, updatedNewspaper);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el periódico");
        }
    }

    /*@PutMapping("/updateNewspaper/{id}")
    public String updateNewspaper(@PathVariable Long id, @RequestBody Newspaper updatedNewspaper) {
        return newspaperService.updateNewspaper(id, updatedNewspaper);
    }*/


}
