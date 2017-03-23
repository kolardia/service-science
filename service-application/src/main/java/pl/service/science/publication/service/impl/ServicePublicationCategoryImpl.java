package pl.service.science.publication.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.service.science.publication.dao.PublicationCategoryDAO;
import pl.service.science.publication.domain.Category;
import pl.service.science.publication.service.ServiceCategory;

@Service
public class ServicePublicationCategoryImpl implements ServiceCategory {

	@Autowired
	protected PublicationCategoryDAO dao;

	public Category findById(Long id) {
		return dao.findById(id);
	};

	public List<Category> findAll() {
		return dao.findAll();
	};

	public Category save(Category category) {
		return dao.save(category);
	};
}
