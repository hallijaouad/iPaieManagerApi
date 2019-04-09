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
@EqualsAndHashCode(of= {"matricule", "nom","prenom","email","date_embauche"}, callSuper=false)
@ToString(of= {"matricule", "nom","prenom","email","date_embauche"})

public class Salarie extends AuditModel implements Serializable {	
	private static final long serialVersionUID = 1L;	
	@Id		
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column(name = "matricule", nullable = false)
	private String matricule; 
	
	@Column(name = "nom", nullable = false)
	private String nom;	
	
	@Column(name = "prenom")
	private String prenom;  
	
	@Column(name = "email")
	private String email; 
	
	@Column(name = "mobile")
	private String mobile; 
	
	@Column(name = "date_embauche", nullable = true)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date date_embauche;
	
	@Column(columnDefinition = "text")
    private String description;
}
