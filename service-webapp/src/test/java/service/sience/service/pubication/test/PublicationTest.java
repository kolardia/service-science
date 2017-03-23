package service.sience.service.pubication.test;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.authorization.dao.AuthorizationDAO;
import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class PublicationTest {

	final static Logger logger = Logger.getLogger(PublicationTest.class);

	@Autowired
	protected ServicePublication service;
	
	@Autowired
	AuthorizationDAO dao;

	@Test
	public void publication() {

		Publication contest = new Publication();

		contest.setAutorization(null);
		contest.setTitle(null);
		contest.setContents(null);

		service.save(contest);

	

		//service.deleteAllPublicationParts(contest);
	}
}