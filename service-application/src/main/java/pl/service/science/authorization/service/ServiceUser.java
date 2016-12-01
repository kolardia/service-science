package pl.service.science.authorization.service;

import org.springframework.stereotype.Service;

import pl.service.science.localization.domain.City;
import pl.service.science.user.domain.User;

@Service
public interface ServiceUser {

	public User findById(Long id);

	public void save(User user);

	public User ifExistFindByEmail(String email);

	public User findByEmail(String email);

	public void delete(User user);

	public City findOrSaveLocation(String countryName, String regionName, String cityName, String codeLanguage);
}
