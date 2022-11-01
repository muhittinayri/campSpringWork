package kodlama.io.Devs.dataAccess.concretes;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguageRepository(){
        programmingLanguages = new ArrayList<>();
        programmingLanguages.add(new ProgrammingLanguage(1,"JAVA"));
        programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
        programmingLanguages.add(new ProgrammingLanguage(3,"C++"));
        programmingLanguages.add(new ProgrammingLanguage(4,"C"));
        programmingLanguages.add(new ProgrammingLanguage(5,"Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }

    @Override
    public ProgrammingLanguage getById(int id) {
        for (ProgrammingLanguage programingLanguage : programmingLanguages) {
            if (programingLanguage.getId() == id){
                return programingLanguage;
            }
        }
        return null;
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage, int id) {
        ProgrammingLanguage updateLanguage = getById(id);
        updateLanguage.setProgramingName(programmingLanguage.getProgramingName());

    }

    @Override
    public void delete(int id) {
        ProgrammingLanguage deleteLanguage = getById(id);
        programmingLanguages.remove(deleteLanguage);
    }
}
