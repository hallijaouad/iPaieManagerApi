--INITIALISATION TABLE ROLE
INSERT INTO roles(pk_role, refext, libelle) VALUES (1,'ROLE_ADMIN', 'Profil administrateur');
INSERT INTO roles(pk_role, refext, libelle) VALUES (2,'ROLE_USER', 'Profil utilisateur');

--INITIALISATION TABLE UTILISATEURS
INSERT INTO users(pk_user, email, password, nom, prenom, actif, created_at, updated_at) values (1, 'admin@gmail.com', 'admin', 'Halli', 'Jaouad', 1, NOW(), NOW());
INSERT INTO users(pk_user, email, password, nom, prenom, actif, created_at, updated_at) values (2, 'hallisaad@gmail.com', 'saad', 'Halli', 'saad', 1, NOW(), NOW());

--TABLE DE JOINTURE ENTRE USERS ET ROLES
--Admin user profil
INSERT INTO users_roles(fk_user,fk_role) VALUES (1,1);
INSERT INTO users_roles(fk_user,fk_role) VALUES (1,2);
--User profil
INSERT INTO users_roles(fk_user,fk_role) VALUES (2,2);

COMMIT;