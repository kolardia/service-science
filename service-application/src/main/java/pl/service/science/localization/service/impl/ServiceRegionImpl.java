package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.DaoRegion;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.ServiceRegion;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.ServiceTranslation;

@Service
public class ServiceRegionImpl implements ServiceRegion {

	@Autowired
	protected DaoRegion dao;

	@Autowired
	protected ServiceTranslation serviceTranslation;

	public Region findById(Long id) {
		return dao.findById(id);
	}

	public void save(Region region) {
		dao.save(region);
	}

	public Translation insert(Translation translation) {
		serviceTranslation.save(translation);
		return translation;
	}

	public void newText(Translation translation, String text, String languageCode) {
		serviceTranslation.newText(translation, text, languageCode);
	}

}
