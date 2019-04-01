package com.ipaiemanager.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ipaiemanager.models.Salarie;

@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Long>{
	List<Salarie> findByNom(String nom);
	Salarie findSalarieById(Long id);
}
