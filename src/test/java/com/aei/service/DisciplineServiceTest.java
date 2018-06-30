package com.aei.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aei.domain.Discipline;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class DisciplineServiceTest {
	@Autowired
	DisciplineService service;
    private final String NAME = "name";

	
	@Test
	public void testSaveName() {
		// given
        Discipline discipline = new Discipline();
        discipline.setId(300L);
        discipline.setName(NAME);
        discipline.setDescription("??");

     // when
        Discipline saved = service.save(discipline);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isNotEqualTo(NAME);
        assertThat(saved.getDescription()).isNotEqualTo("??");
	}	

    @Test
    public void testSaveNotExistingDiscipline(){
        // given
    	Discipline discipline = new Discipline();
    	discipline.setId(300L);
    	discipline.setName("name");
    	discipline.setDescription("?");

        // when
    	Discipline saved = service.save(discipline);

        // then
        assertThat(saved).isNull();
    }

}
