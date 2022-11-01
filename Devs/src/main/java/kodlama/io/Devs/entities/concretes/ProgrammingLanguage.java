package kodlama.io.Devs.entities.concretes;

public class ProgrammingLanguage {
    private int id;
    private String programingName;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(int id, String programingName) {
        this.id = id;
        this.programingName = programingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProgramingName() {
        return programingName;
    }

    public void setProgramingName(String programingName) {
        this.programingName = programingName;
    }
}
