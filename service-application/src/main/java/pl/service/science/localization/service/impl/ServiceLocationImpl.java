package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.LocationDAO;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Location;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.CityService;
import pl.service.science.localization.service.CountryService;
import pl.service.science.localization.service.LocationService;
import pl.service.science.localization.service.RegionService;

@Service
public class ServiceLocationImpl implements LocationService {

	@Autowired
	protected LocationDAO dao;

	@Autowired
	protected CountryService serviceCountry;

	@Autowired
	protected RegionService serviceRegion;

	@Autowired
	protected CityService serviceCity;

	public Location findById(Long id) {
		return dao.findById(id);
	}

	public Location save(Location location) {
		return dao.save(location);
	}

	public Region countryAssociatedWithRegion(String LanguageCode, String nameRegion, String nameCountry) {

		Country country = new Country();
		country = serviceCountry.fineOrSaveCountry(nameCountry, LanguageCode);

		Region region = new Region();
		region = serviceRegion.fineOrSaveRegion(nameRegion, LanguageCode);

		if (country.getRegion() == null) {
			country.setRegion(region);

			serviceCountry.save(country);
		}

		return serviceRegion.findById(region.getId());
	}
	
	public void cleanAndDelete(Location location){
		
		location.setCity(null);
		location.setRegon(null);;
		
		dao.save(location);
		dao.delete(location);
	}
	
}
