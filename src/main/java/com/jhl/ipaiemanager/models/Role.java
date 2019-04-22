package com.jhl.ipaiemanager.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity( name = "roles")
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@EqualsAndHashCode(of= {"refext","libelle"})
@ToString(of= {"refext","libelle"})

public class Role implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name = "pk_role", updatable = false, nullable = false)		
	    private Long id;
		
	 	@Column (name = "refext", updatable = false, nullable = false)	 	
	    private String refext;
	 	
	 	@Column (name = "libelle", updatable = true, nullable = false)
	 	private String libelle;
}