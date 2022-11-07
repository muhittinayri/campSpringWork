package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.responses.programmingTechnologyResponses.GetAllProgrammingTechnologyResponse;
import kodlama.io.Devs.business.responses.programmingTechnologyResponses.GetByIdProgrammingTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programingtechnology")
public class ProgrammingTechnologyController {
    private final ProgrammingTechnologyService programmingTechnologyService;

    public ProgrammingTechnologyController(ProgrammingTechnologyService programmingTechnologyService) {
        this.programmingTechnologyService = programmingTechnologyService;
    }

    @GetMapping("/getAll")
    public List<GetAllProgrammingTechnologyResponse> getAll(){
        return programmingTechnologyService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdProgrammingTechnologyResponse getById(@PathVariable int id){
        return programmingTechnologyService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest){
        programmingTechnologyService.add(createProgrammingTechnologyRequest);
    }

    @PutMapping("/update/{id}")
    public void update(@RequestBody UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest, @PathVariable int id){
        programmingTechnologyService.update(updateProgrammingTechnologyRequest, id);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest){
        programmingTechnologyService.delete(deleteProgrammingTechnologyRequest);
    }


}
