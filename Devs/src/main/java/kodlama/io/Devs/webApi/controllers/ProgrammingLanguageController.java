package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguagesResponse;
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

    @GetMapping("/getAll")
    public List<GetAllProgrammingLanguageResponse> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingLanguagesResponse getById(@PathVariable int id){
        return programmingLanguageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
        programmingLanguageService.add(createProgrammingLanguageRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, @PathVariable int id){
        programmingLanguageService.update(updateProgrammingLanguageRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
        programmingLanguageService.delete(deleteProgrammingLanguageRequest);
    }

}
