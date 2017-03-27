package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Location;
import pl.service.science.localization.domain.Region;

@Service
public interface LocationService {

	public Location findById(Long id);

	public void save(Location location);

	public Region countryAssociatedWithRegion(String LanguageCode, String nameRegion, String nameCountry);
	
}
