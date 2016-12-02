package pl.service.science.localization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.localization.dao.DaoLocation;
import pl.service.science.localization.domain.Country;
import pl.service.science.localization.domain.Location;
import pl.service.science.localization.domain.Region;
import pl.service.science.localization.service.ServiceCity;
import pl.service.science.localization.service.ServiceCountry;
import pl.service.science.localization.service.ServiceLocation;
import pl.service.science.localization.service.ServiceRegion;

@Service
public class ServiceLocationImpl implements ServiceLocation {

	@Autowired
	protected DaoLocation dao;

	@Autowired
	protected ServiceCountry serviceCountry;

	@Autowired
	protected ServiceRegion serviceRegion;

	@Autowired
	protected ServiceCity serviceCity;

	public Location findById(Long id) {
		return dao.findById(id);
	}

	public void save(Location location) {
		dao.save(location);
	}

	public Region findOrSaveRegion(String LanguageCode, String nameRegion, String nameCountry) {

		Country country = new Country();
		country = serviceCountry.findOrSave(nameCountry, LanguageCode);

		Region region = new Region();
		region = serviceRegion.findOrSave(nameRegion, LanguageCode);

		if (region.getCountry() == null) {
			region.setCountry(country);

			serviceRegion.save(region);
		}

		return serviceRegion.findById(region.getId());
	}
}
