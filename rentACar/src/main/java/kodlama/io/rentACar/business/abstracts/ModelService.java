package kodlama.io.rentACar.business.abstracts;

import java.util.List;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsReponse;

public interface ModelService {
	List<GetAllModelsReponse> getAll();
	void add (CreateModelRequest createModelRequest);
}
