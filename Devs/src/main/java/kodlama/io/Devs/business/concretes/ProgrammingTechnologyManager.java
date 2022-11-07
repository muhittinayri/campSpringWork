package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.abstracts.ProgrammingTechnologyService;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguagesResponse;
import kodlama.io.Devs.business.responses.programmingTechnologyResponses.GetAllProgrammingTechnologyResponse;
import kodlama.io.Devs.business.responses.programmingTechnologyResponses.GetByIdProgrammingTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologyRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Devs.entities.concretes.ProgrammingTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProgrammingTechnologyManager implements ProgrammingTechnologyService {

    private ProgrammingTechnologyRepository programmingTechnologyRepository;
    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingTechnologyManager(ProgrammingTechnologyRepository programmingTechnologyRepository, ProgrammingLanguageService programmingLanguageService) {
        this.programmingTechnologyRepository = programmingTechnologyRepository;
        this.programmingLanguageService = programmingLanguageService;
    }

    @Override
    public void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest) {
        ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        GetByIdProgrammingLanguagesResponse getByIdProgrammingLanguagesResponse = programmingLanguageService
                .getById(createProgrammingTechnologyRequest.getProgramming_language_id());

        programmingLanguage.setId(getByIdProgrammingLanguagesResponse.getId());
        programmingLanguage.setProgramingName(getByIdProgrammingLanguagesResponse.getProgramingName());
        programmingTechnology.setName(createProgrammingTechnologyRequest.getName());
        programmingTechnology.setProgrammingLanguage(programmingLanguage);
        programmingTechnologyRepository.save(programmingTechnology);
    }

    @Override
    public void update(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest, int id) {
        ProgrammingTechnology programmingTechnology = new ProgrammingTechnology();
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        GetByIdProgrammingLanguagesResponse getByIdProgrammingLanguagesResponse = programmingLanguageService
                .getById(updateProgrammingTechnologyRequest.getProgramming_language_id());

        programmingLanguage.setId(getByIdProgrammingLanguagesResponse.getId());
        programmingLanguage.setProgramingName(getByIdProgrammingLanguagesResponse.getProgramingName());

        programmingTechnology.setName(updateProgrammingTechnologyRequest.getName());
        programmingTechnology.setId(updateProgrammingTechnologyRequest.getId());
        programmingTechnology.setProgrammingLanguage(programmingLanguage);
        programmingTechnologyRepository.save(programmingTechnology);
    }

    @Override
    public void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest) {
        programmingTechnologyRepository.deleteById(deleteProgrammingTechnologyRequest.getId());
    }

    @Override
    public List<GetAllProgrammingTechnologyResponse> getAll() {
        List<ProgrammingTechnology> programmingTechnologies = programmingTechnologyRepository.findAll();
        List<GetAllProgrammingTechnologyResponse> getAllProgrammingTechnologyResponses = new ArrayList<>();

        for (ProgrammingTechnology programmingTechnology : programmingTechnologies){
            GetAllProgrammingTechnologyResponse responseItem = new GetAllProgrammingTechnologyResponse();
            responseItem.setId(programmingTechnology.getId());
            responseItem.setName(programmingTechnology.getName());
            getAllProgrammingTechnologyResponses.add(responseItem);
        }
        return getAllProgrammingTechnologyResponses;
    }

    @Override
    public GetByIdProgrammingTechnologyResponse getById(int id) {
        ProgrammingTechnology programmingTechnology = programmingTechnologyRepository.getReferenceById(id);
        GetByIdProgrammingTechnologyResponse getByIdProgrammingTechnologyResponse = new GetByIdProgrammingTechnologyResponse();
        getByIdProgrammingTechnologyResponse.setId(programmingTechnology.getId());
        getByIdProgrammingTechnologyResponse.setName(programmingTechnology.getName());
        return getByIdProgrammingTechnologyResponse;
    }
}
