package pl.service.science.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.service.science.authorization.dao.AuthorizationDAO;
import pl.service.science.authorization.domain.Authorization;
import pl.service.science.authorization.domain.Status;
import pl.service.science.authorization.domain.User;
import pl.service.science.authorization.service.AuthorizationService;
import pl.service.science.section.domain.Section;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	public AuthorizationDAO dao;

	public Authorization findById(Long id) {

		return dao.findById(id);
	}

	public Authorization findByUserAndSectionAndAuthorization(User user, Section section, Status status) {

		return dao.findByUserAndSectionAndAuthorization(user, section, status);
	}

	public void save(Authorization authorization) {

		dao.save(authorization);
	}
}
