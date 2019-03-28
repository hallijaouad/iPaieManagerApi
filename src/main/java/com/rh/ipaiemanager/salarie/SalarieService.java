package com.rh.ipaiemanager.salarie;
import java.util.List;
import java.util.Optional;
public interface SalarieService {
	List<Salarie> findAll();
	List<Salarie> findByNom(String nom);
	Optional<Salarie> findById(long id);
	Optional<Salarie> delete(long id);
}
