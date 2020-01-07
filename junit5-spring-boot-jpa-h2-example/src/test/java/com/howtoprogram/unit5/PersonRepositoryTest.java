package com.howtoprogram.unit5;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Before
	public void setUp() {
		personRepository.deleteAll();
	}

	@Test
	public void should_find_MARC_when_find_all_persons() {

		Person MARC = new Person();
		MARC.setFirstName("Marc");
		MARC.setLastName("Cram");
		personRepository.save(MARC);

		List<Person> allStudents = personRepository.findAll();

		assertEquals(1, allStudents.size());
		Person FIRST_PERSON = allStudents.get(0);
		assertNotNull(FIRST_PERSON.getId());
		assertEquals(MARC.getFirstName(), FIRST_PERSON.getFirstName());
		assertEquals(MARC.getLastName(), FIRST_PERSON.getLastName());
	}
}
