package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Dictionary;
import com.example.corazondelatorback.Model.Newspaper;
import com.example.corazondelatorback.Services.DictionaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DictionaryController {

    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService){
        this.dictionaryService = dictionaryService;
    }

    @GetMapping(value = "/getDictionary")
    public List<Dictionary> getAllDictionary(){
        return dictionaryService.DictionaryList();
    }

    @PostMapping(value = "/addDictionary")
    public String addDictionary(@RequestBody Dictionary dictionary){
        return dictionaryService.AddDictionary(dictionary);
    }

    @DeleteMapping("/deleteDictionary/{id}")
    public String deleteDictionary(@PathVariable Long id) {
        return dictionaryService.deleteDictionary(id);
    }

    @PutMapping("/updateDictionary/{id}")
    public String updateDictionary(@PathVariable Long id, @RequestBody Dictionary updatedDictionary) {
        return dictionaryService.updateDictionary(id, updatedDictionary);
    }

}
