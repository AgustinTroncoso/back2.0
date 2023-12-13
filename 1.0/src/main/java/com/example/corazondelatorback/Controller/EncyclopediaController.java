package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Encyclopedia;
import com.example.corazondelatorback.Model.Newspaper;
import com.example.corazondelatorback.Services.EncyclopediaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EncyclopediaController {

    private final EncyclopediaService encyclopediaService;

    public EncyclopediaController(EncyclopediaService encyclopediaService){
        this.encyclopediaService = encyclopediaService;
    }

    @GetMapping(value = "/getEncyclopedia")
    public List<Encyclopedia> getAllEncyclopedia(){
        return encyclopediaService.EncyclopediaList();
    }
    @PostMapping (value = "/addEncyclopedia")
    public String addEncyclopedia(@RequestBody Encyclopedia encyclopedia){
        return encyclopediaService.AddEncyclopedia(encyclopedia);
    }

    @DeleteMapping("/deleteEncyclopedia/{id}")
    public String deleteEncyclopedia(@PathVariable Long id) {
        return encyclopediaService.deleteEncyclopedia(id);
    }

    @PutMapping("/updateEncyclopedia/{id}")
    public String updateEncyclopedia(@PathVariable Long id, @RequestBody Encyclopedia updatedEncyclopedia) {
        return encyclopediaService.updateEncyclopedia(id, updatedEncyclopedia);
    }
}
