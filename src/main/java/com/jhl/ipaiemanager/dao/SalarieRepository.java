package com.jhl.ipaiemanager.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jhl.ipaiemanager.models.Salarie;

@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Long>{	
	List<Salarie> findByNomLike(String nom);
	Salarie findSalarieById(Long id);
}
