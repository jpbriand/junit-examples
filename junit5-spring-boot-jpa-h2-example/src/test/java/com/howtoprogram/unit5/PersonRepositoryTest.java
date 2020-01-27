package com.howtoprogram.unit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@BeforeEach
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
