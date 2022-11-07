package kodlama.io.Devs.business.responses.programmingLanguageResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProgrammingLanguageResponse {
    private int id;
    private String programingName;
}
