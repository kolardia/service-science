package pl.service.science.localization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.RegionDAO;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.RegionService;
import pl.service.science.translation.domain.Translation;
import pl.service.science.translation.service.TranslationService;

@Service
public class ServiceRegionImpl implements RegionService {

	@Autowired
	protected RegionDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;

	public Region findById(Long id) {
		return dao.findById(id);
	}

	public void save(Region region) {
		dao.save(region);
	}

	public void newText(Translation translation, String text, String languageCode) {
		serviceTranslation.newTextTranslationForObject(translation, text, languageCode);
	}

	public Region fineOrSaveRegion(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.selectTextTranslation(countryName, languageCode);

		if (translation != null) {
		
			return dao.findByRegion(translation);

		} else {

			Region region = new Region();
			region.setRegion(serviceTranslation.save(new Translation()));

			dao.save(region);

			this.newText(region.getRegion(), countryName, languageCode);

			return dao.findById(region.getId());
		}
	}

	public List <Region> findByCountry(Country country) {
		return dao.findByCountry(country);
	}
	
	public Region findByRegion(Translation translation){
		return dao.findByRegion(translation);
	}
}