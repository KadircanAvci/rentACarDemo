package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsReponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService{

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllModelsReponse> getAll() {
		
		List<Model> models = this.modelRepository.findAll();
		
		List<GetAllModelsReponse> modelsResponse = models.stream()
				.map(model->this.modelMapperService.forResponse()
						.map(model, GetAllModelsReponse.class)).collect(Collectors.toList());
		
		return modelsResponse;
	}


	@Override
	public void add(CreateModelRequest createModelRequest) {
		
		Model model = this.modelMapperService.forRequest()
				.map(createModelRequest, Model.class);
		
		
		
		this.modelRepository.save(model);		
	}
			


}
