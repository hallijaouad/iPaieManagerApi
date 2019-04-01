package com.ipaiemanager.models;

import javax.persistence.*;

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
@EqualsAndHashCode(of= {"nom","prenom"})
@ToString(of= {"nom","prenom"})
public class User {

	@Id
	@Column(name = "pk_user")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pkUser;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String email;

}
