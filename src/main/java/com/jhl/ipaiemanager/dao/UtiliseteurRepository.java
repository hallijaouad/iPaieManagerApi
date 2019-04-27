package com.jhl.ipaiemanager.dao;
import com.jhl.ipaiemanager.models.Utilisateur;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UtiliseteurRepository extends 
		JpaRepository<Utilisateur, Long>
{
	/**
	 * ,
		QuerydslPredicateExecutor<Utilisateur>, 
		QuerydslBinderCustomizer<QUtilisateur>
     * Override default QueryDsl bindings.
     * TODO explain what and why?
     * This customizes QueryDsl to ignore case on queries involving String values
     *
     * @param bindings a QueryDslBindings to use
     * @param root     the QPatient root
    
    @Override
    default void customize(QuerydslBindings bindings, QUtilisateur root) {
        bindings.excluding(root.id);
        //bindings.excluding(root.patientId);
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
     */
	
	List<Utilisateur> findByNom(String nom);	
	Utilisateur findByEmail(String email);
	Optional<Utilisateur> findById(Long id);
	
	
}
