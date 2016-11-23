package pl.service.science.publication.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.service.science.publication.domain.PublicationStatus;

@Repository
public interface DaoPublicationStatus extends CrudRepository<PublicationStatus, Long> {

	public PublicationStatus findById(int id);

	public List<PublicationStatus> findAll();

}
