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
import pl.service.science.translation.service.TranslationTextService;

@Service
public class ServiceRegionImpl implements RegionService {

	@Autowired
	protected RegionDAO dao;

	@Autowired
	protected TranslationService serviceTranslation;
	
	@Autowired
	protected TranslationTextService serviceText;

	public Region findById(Long id) {
		return dao.findById(id);
	}

	public void save(Region region) {
		dao.save(region);
	}

	public List<Region> findAll() {
		return dao.findAll();
	}

	public void newText(Translation translation, String text, String languageCode) {
		serviceTranslation.newTranslationForObject(translation, text, languageCode);
	}

	public void deleteRegionWhithParts(Region region) {
		
		Translation translation = new Translation();
		translation = serviceTranslation.findById(region.getRegion().getId());
		
		dao.delete(region);
		serviceText.delete(serviceText.findByTranslation(translation));
		serviceTranslation.delete(translation);

	}
	
	public Region fineOrSaveRegion(String countryName, String languageCode) {

		Translation translation = new Translation();
		translation = serviceTranslation.findTextTranslation(countryName, languageCode);

		if (translation != null) {

			return dao.findByRegion(translation);

		} else {

			Region region = new Region();
			region.setRegion(serviceTranslation.save(new Translation()));

			dao.save(region);

			serviceTranslation.newTranslationForObject(region.getRegion(), countryName, languageCode);

			return dao.findById(region.getId());
		}
	}

	public List<Region> findByCountry(Country country) {
		return dao.findByCountry(country);
	}

	public Region findByRegion(Translation translation) {
		return dao.findByRegion(translation);
	}
}