package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programinglanguages")
public class ProgrammingLanguageController {
    private final ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping("/")
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable int id){
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/")
    public void add(@RequestBody ProgrammingLanguage programmingLanguage){
        programmingLanguageService.add(programmingLanguage);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ProgrammingLanguage programmingLanguage, @PathVariable int id){
        programmingLanguageService.update(programmingLanguage, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        programmingLanguageService.delete(id);
    }

}
