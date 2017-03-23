package pl.service.science.publication.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.service.science.publication.domain.Category;

@Service
public interface ServiceCategory {

	public Category findById(Long id);

	public List<Category> findAll();

	public Category save(Category category);

}
