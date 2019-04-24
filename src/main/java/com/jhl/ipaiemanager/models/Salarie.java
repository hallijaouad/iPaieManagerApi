package com.jhl.ipaiemanager.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import lombok.experimental.FieldDefaults;


/**
 * @author jhl
 *
 */
@Entity (name = "salaries")
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"matricule", "nom","prenom","email","date_embauche","num_cnss", "contrat_duree_type", "poste_intitule", "description"}, callSuper=false)
@ToString(of= {"matricule", "nom","prenom","email","date_embauche", "num_cnss", "contrat_duree_type", "poste_intitule", "description"})

public class Salarie extends AuditModel implements Serializable {	
	private static final long serialVersionUID = 1L;	
	@Id		
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name = "matricule", nullable = false)
	private String matricule; 
	
	// Numéro de cnss >> numérique
	@Column(name = "num_cnss")
	private Long num_cnss;
	
	// Contrat déterminée ou indérteminée
	@Column (name = "contrat_duree_type")
	@Enumerated(EnumType.STRING)
	private ContratDureeType contrat_duree_type;
	
	// Libellé du poste
	@Column (name = "poste_intitule")
	private String poste_intitule;
	
	@Column(name = "nom", nullable = false)
	private String nom;	
	
	@Column(name = "prenom")
	private String prenom;  
	
	@Column(name = "email")
	private String email; 
	
	@Column(name = "mobile")
	private String mobile; 
	
	@Column(name = "date_embauche", nullable = true)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date_embauche;
	
	@Column(columnDefinition = "text")
    private String description;
	
	/**
	 * Type de contrat
	 * @author Jaouad_Halli
	 *
	 */
	public enum ContratDureeType{
		DETERMINEE("DETERMINEE"),
		INDETERMINEE("INDETERMINEE");		
		private String type;
		ContratDureeType(String type){
	       this.type= type;
	    }
	    public String getContratDureeType(){
	        return this.type;
	    }
	}
	
}
