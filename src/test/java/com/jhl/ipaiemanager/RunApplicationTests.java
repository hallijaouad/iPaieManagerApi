package com.jhl.ipaiemanager;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jhl.ipaiemanager.models.Salarie;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)


public class RunApplicationTests {
	
	@Autowired
    private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}
	
	private int port;
	private String getEndPoint() {
        return "http://localhost:" + port + "/api/salaries";
    }
	
	/**
	 * Test ressource récupération de tous les salariés
	 */
	@Test
    public void testGetAllSalaries() {
         HttpHeaders headers = new HttpHeaders();
         HttpEntity<String> entity = new HttpEntity<String>(null, headers);
         ResponseEntity<String> response = restTemplate.exchange(getEndPoint(),
         HttpMethod.GET, entity, String.class);
         assertNotNull(response.getBody());
    }
	
	/**
	 * Test resource récupération d'un salarie by id
	 */
	@Test
    public void testGetSalarie() {
        Salarie salarie = restTemplate.getForObject(getEndPoint() + "/1", Salarie.class);
        System.out.println(salarie.getNom());
        assertNotNull(salarie);
    }
	
	/**
	 * Test create new salarie
	 */
	
	@Test
	
	public void testCreateSalarie() {
		Salarie salarie = new Salarie();
		salarie.setNom("HALLI");
		salarie.setPrenom("Jaouad");
		
		ResponseEntity<Salarie> postResponse = restTemplate.postForEntity(getEndPoint(), salarie, Salarie.class);		
		assertNotNull(postResponse);		
		assertNotNull(postResponse.getBody());
	}
	
	
	public void testUpdateSalarie() {
		
	}
	
	
	public void testDeleteSalarie() {
		
	}
	
	

}
