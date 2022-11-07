package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.programmingTechnologyRequests.CreateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.DeleteProgrammingTechnologyRequest;
import kodlama.io.Devs.business.requests.programmingTechnologyRequests.UpdateProgrammingTechnologyRequest;
import kodlama.io.Devs.business.responses.programmingTechnologyResponses.GetAllProgrammingTechnologyResponse;
import kodlama.io.Devs.business.responses.programmingTechnologyResponses.GetByIdProgrammingTechnologyResponse;


import java.util.List;


public interface ProgrammingTechnologyService {
    void add(CreateProgrammingTechnologyRequest createProgrammingTechnologyRequest);
    void update(UpdateProgrammingTechnologyRequest updateProgrammingTechnologyRequest, int id);
    void delete(DeleteProgrammingTechnologyRequest deleteProgrammingTechnologyRequest);
    List<GetAllProgrammingTechnologyResponse> getAll();
    GetByIdProgrammingTechnologyResponse getById(int id);
}
