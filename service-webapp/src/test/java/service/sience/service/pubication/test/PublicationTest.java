package service.sience.service.pubication.test;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.service.science.publication.domain.Publication;
import pl.service.science.publication.service.ServicePublication;
import pl.service.science.translation.domain.Translation;

@FixMethodOrder(MethodSorters.JVM)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/applicationContext.xml")
public class PublicationTest {

	final static Logger logger = Logger.getLogger(PublicationTest.class);

	@Autowired
	protected ServicePublication service;

	@Test
	public void publication() {

		Publication contest = new Publication();

		contest.setTitle(service.insert(new Translation()));
		contest.setContents(service.insert(new Translation()));

		service.save(contest);

		assertNotNull(service.findById(contest.getId()));

		service.saveText(contest.getTitle(), "new publication title pl", "PL");
		service.saveText(contest.getTitle(), "new publication title en", "EN");
		service.saveText(contest.getContents(), "new publication contents pl", "PL");
		service.saveText(contest.getContents(), "new publication contents en", "EN");

		service.deleteAllPublicationParts(contest);
	}
}