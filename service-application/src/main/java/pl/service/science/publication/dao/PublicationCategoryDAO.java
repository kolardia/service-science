package pl.service.science.publication.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.publication.domain.Category;

@Repository
public interface PublicationCategoryDAO extends CrudRepository<Category, Long> {

	public Category findById(Long id);

	public List<Category> findAll();

}
