package kodlama.io.Devs.business.requests.programmingTechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProgrammingTechnologyRequest {
    private int id;
    private int programming_language_id;
    private String name;
}
