package pl.service.science.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.ProfileDAO;
import pl.service.science.authorization.domain.Profile;
import pl.service.science.authorization.service.ProfileService;
import pl.service.science.translation.domain.Translation;

@Service
public class ServiceProfileImpl implements ProfileService {

	@Autowired
	protected ProfileDAO dao;

	public Profile findById(Long id) {
		return dao.findById(id);
	}

	public Profile findByPortfolio(Translation translation) {
		return dao.findByPortfolio(translation);
	}

	public void save(Profile profile) {
		dao.save(profile);
	}

}
