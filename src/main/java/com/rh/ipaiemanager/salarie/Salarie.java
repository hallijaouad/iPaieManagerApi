package com.rh.ipaiemanager.salarie;

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
@EqualsAndHashCode(of= {"nom","prenom"})
@ToString(of= {"nom","prenom"})

public class Salarie implements Serializable{	
	private static final long serialVersionUID = 1L;	
	@Id		
	private Long id;		
	private String nom;		
	private String prenom;  	
}
