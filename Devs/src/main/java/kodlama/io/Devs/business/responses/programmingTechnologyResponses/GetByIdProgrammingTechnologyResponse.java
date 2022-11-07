package kodlama.io.Devs.business.responses.programmingTechnologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdProgrammingTechnologyResponse {
    private int id;
    private String name;
}
