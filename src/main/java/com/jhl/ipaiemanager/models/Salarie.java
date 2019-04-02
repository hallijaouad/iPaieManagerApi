package com.jhl.ipaiemanager.models;

import java.io.Serializable;
import javax.persistence.*;

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
@EqualsAndHashCode(of= {"nom","prenom","email"})
@ToString(of= {"nom","prenom","email"})

public class Salarie implements Serializable{	
	private static final long serialVersionUID = 1L;	
	@Id		
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column(name = "nom")
	private String nom;	
	
	@Column(name = "prenom")
	private String prenom;  
	
	@Column(name = "email")
	private String email; 
}
