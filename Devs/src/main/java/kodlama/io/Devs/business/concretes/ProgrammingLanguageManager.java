package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        if (checkProgramingLanguageNameValid(programmingLanguage)){
            throw new RuntimeException("Programlama Dili Boş Geçilemez");
        }
        if (isProgramingLanguageExists(programmingLanguage)){
            throw new RuntimeException("Programlama Dili Mevcut");
        }
        programmingLanguageRepository.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage, int id) {
        if (checkProgramingLanguageNameValid(programmingLanguage)){
            throw new RuntimeException("Programlama Dili Boş Geçilemez");
        }
        if (isProgramingLanguageExists(programmingLanguage)){
            throw new RuntimeException("Programlama Dili Mevcut");
        }
        programmingLanguageRepository.update(programmingLanguage,id);
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.delete(id);
    }

    public boolean checkProgramingLanguageNameValid(ProgrammingLanguage programmingLanguage){
        return programmingLanguage.getProgramingName().isEmpty() || programmingLanguage.getProgramingName().isBlank();
    }

    public boolean isProgramingLanguageExists(ProgrammingLanguage programmingLanguage){
        return programmingLanguageRepository.getAll().stream()
                .anyMatch(x -> x.getProgramingName()
                        .equals(programmingLanguage.getProgramingName()));
    }
}
