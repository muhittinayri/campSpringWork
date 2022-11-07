package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.CreateProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.DeleteProgrammingLanguageRequest;
import kodlama.io.Devs.business.requests.programmingLanguageRequests.UpdateProgrammingLanguageRequest;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetAllProgrammingLanguageResponse;
import kodlama.io.Devs.business.responses.programmingLanguageResponses.GetByIdProgrammingLanguagesResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<GetAllProgrammingLanguageResponse> getAll() {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        List<GetAllProgrammingLanguageResponse> languageResponses = new ArrayList<>();
        for (ProgrammingLanguage programmingLanguage : languages) {
            GetAllProgrammingLanguageResponse responseItem = new GetAllProgrammingLanguageResponse();
            responseItem.setId(programmingLanguage.getId());
            responseItem.setProgramingName(programmingLanguage.getProgramingName());
            languageResponses.add(responseItem);
        }
        return languageResponses;
    }

    @Override
    public GetByIdProgrammingLanguagesResponse getById(int id) {
        ProgrammingLanguage language = programmingLanguageRepository.getReferenceById(id);
        GetByIdProgrammingLanguagesResponse languagesResponse = new GetByIdProgrammingLanguagesResponse();
        languagesResponse.setId(language.getId());
        languagesResponse.setProgramingName(language.getProgramingName());
        return languagesResponse;
    }

    @Override
    public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
        List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
        for (ProgrammingLanguage language : languages) {
            if (createProgrammingLanguageRequest.getProgramingName().equals(language.getProgramingName())) {

                throw new RuntimeException("Programlama Dili Mevcut");
            }
        }
        if (createProgrammingLanguageRequest.getProgramingName().equals("")) {

            throw new RuntimeException("Programlama Dili Boş Geçilemez");
        }

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setProgramingName(createProgrammingLanguageRequest.getProgramingName());
        this.programmingLanguageRepository.save(programmingLanguage);

    }

    @Override
    public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest, int id) {
        ProgrammingLanguage language = new ProgrammingLanguage();
        language.setId(updateProgrammingLanguageRequest.getId());
        language.setProgramingName(updateProgrammingLanguageRequest.getProgramingName());
        programmingLanguageRepository.save(language);
    }

    @Override
    public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
        programmingLanguageRepository.deleteById(deleteProgrammingLanguageRequest.getId());
    }
}
