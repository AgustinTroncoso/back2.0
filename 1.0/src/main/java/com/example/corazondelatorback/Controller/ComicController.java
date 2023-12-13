package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Borrow;
import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Services.ComicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin

@RestController

public class ComicController {
    private final ComicService comicService;

    public ComicController(ComicService comicService){
        this.comicService = comicService;
    }

     @PostMapping(value = "/addComic")
        public String addComic(@RequestBody Comic comic){
        return comicService.AddComic(comic);
    }
    @GetMapping(value = "/getComic")
    public List<Comic> getAllComics(){
        return comicService.ComicList();
    }

    @DeleteMapping("/deleteComic/{id}")
    public String deleteComic(@PathVariable Long id) {
        return comicService.deleteComic(id);
    }

    @PutMapping("/updateComic/{id}")
    public String updateComic(@PathVariable Long id, @RequestBody Comic updatedComic) {
        return comicService.updateComic(id, updatedComic);
    }


}
