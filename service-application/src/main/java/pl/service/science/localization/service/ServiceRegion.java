package pl.service.science.localization.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Region;
import pl.service.science.translation.domain.Translation;

@Service
public interface ServiceRegion {

	public Region findById(Long id);

	public Region findByRegion(Translation translation);

	public void save(Region region);

	public void newText(Translation translation, String text, String languageCode);

	public Region findOrSave(String countryName, String languageCode);

	public List<Region> findByCountry(Country country);

}
