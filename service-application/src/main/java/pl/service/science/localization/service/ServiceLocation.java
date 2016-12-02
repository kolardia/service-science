package pl.service.science.localization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.Location;
import pl.service.science.localization.domain.Region;

@Service
public interface ServiceLocation {

	public Location findById(Long id);

	public void save(Location location);

	public Region findOrSaveRegion(String LanguageCode, String nameRegion, String nameCountry);
}
