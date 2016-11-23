package pl.service.science.publication.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.publication.domain.PublicationCategory;

@Repository
public interface DaoPublicationCategory extends CrudRepository<PublicationCategory, Long> {

	public PublicationCategory findById(Long id);

	public List<PublicationCategory> findAll();

}
