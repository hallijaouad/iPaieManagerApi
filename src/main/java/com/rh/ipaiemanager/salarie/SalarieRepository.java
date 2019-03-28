package com.rh.ipaiemanager.salarie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SalarieRepository extends JpaRepository<Salarie, Long>{
	List<Salarie> findByNom(String nom);

}
