package kodlama.io.Devs.business.requests.programmingTechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProgrammingTechnologyRequest {
    private int programming_language_id;
    private String name;
}
