package com.jhl.ipaiemanager.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;


@Entity (name = "users")
@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"nom", "prenom", "email", "actif"}, callSuper=false)
@ToString(of= {"nom","prenom", "email", "actif"})

public class Utilisateur extends AuditModel implements Serializable {
	/**
     * Resource name to use for Utilisateur.
     */
    public static final String RESOURCE_PATH = "/api/users";
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pk_user", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nom", insertable = true, updatable = true, nullable = false)
	private String nom;
	
	@Column (name = "prenom", insertable = true, updatable = true, nullable = false)
	private String prenom;
	
	@NotNull(message="Veuilller indique l'email")
	@Column (name = "email", unique = true, insertable = true, updatable = true, nullable = false)
	private String email;
	
	@Column (name = "password", insertable = true, updatable = true, nullable = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Column (name = "actif", insertable = true, updatable = true, nullable = false)
	private Integer actif;	
	
	/**
	 * Jointure avec la table roles
	 */
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "fk_user"), inverseJoinColumns = @JoinColumn(name = "fk_role"))
	private Collection<Role> roles=new ArrayList<>();

}
