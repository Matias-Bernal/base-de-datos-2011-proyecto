SET search_path="plarpebu";

INSERT INTO SKIN VALUES 
	('Default','Default'),
	('~/Skin1','Skin 1'),
	('~/Skin2','Skin 2');
	
INSERT INTO GENERO VALUES 
	('Desconocido'),
	('Rock'),
	('Pop'),
	('Clasico');
	
INSERT INTO TEMA VALUES
	('~/Tema1',2011,'Titulo1','Artista1','Album1','Desconocido','0:3:0'),
	('~/Tema2',2010,'Titulo2','Artista1','Album2','Rock','1:0:2'),
	('~/Tema3',2011,'Titulo3','Artista2','Album3','Pop','0:0:55'),
	('~/Tema4',2009,'Titulo4','Artista3','Album1','Clasico','1:11:11');

INSERT INTO BANDA VALUES
	(1),(2),(3),(4),(5),(6),(7),(8),
	(9),(10),(11),(12),(13),(14),(15),(16),
	(17),(18),(19),(20),(21),(22),(23),(24),
	(25),(26),(27),(28),(29),(30),(31),(32);
	
INSERT INTO ECUALIZACION (nombreEcualizacion) VALUES
	('Default'),
	('Ecualizacion 1');

INSERT INTO COMPUESTO VALUES
	(2,1,-12),(2,2,-11),(2,3,-10),(2,4,-9),
	(2,5,-8),(2,6,-7),(2,7,-6),(2,8,-5),
	(2,9,-4),(2,10,-3),(2,11,-2),(2,12,-1),
	(2,13,0),(2,14,1),(2,15,2),(2,16,3),
	(2,17,4),(2,18,5),(2,19,6),(2,20,7),
	(2,21,8),(2,22,9),(2,23,10),(2,24,11),
	(2,25,12);
	
INSERT INTO ORDEN VALUES
	(NEXTVAL('Plarpebu.orden_id_seq')),
	(NEXTVAL('Plarpebu.orden_id_seq')),
	(NEXTVAL('Plarpebu.orden_id_seq')),
	(NEXTVAL('Plarpebu.orden_id_seq'));

INSERT INTO CARPETA (nombreCarpeta,id_carpetaPadre) VALUES
	('Raiz1',null),
	('Raiz2',null),
	('Raiz3',null),
	('Carpeta1.1',1),
	('Carpeta1.2',1),
	('Carpeta2.1',2),
	('Carpeta2.1.1',6),
	('Carpeta2.1.2',6),
	('Carpeta3.1',3),
	('Carpeta3.1.1',9);

INSERT INTO RAIZ VALUES
	(1),
	(2),
	(3);

INSERT INTO LISTA (nombreLista,id_carpeta) VALUES
	('Rock',4),
	('Heavy Metal',5),
	('Rock',6),
	('Nacional',7),
	('Internacional',8),
	('Latinos',3),
	('Cuarteto',9),
	('Cumbia',10);
	
INSERT INTO SE_REPR VALUES
	(1,1,1,'~/Tema1'),
	(2,1,1,'~/Tema2'),
	(3,1,2,'~/Tema3'),
	(1,2,1,'~/Tema1'),
	(1,3,1,'~/Tema1'),
	(2,3,2,'~/Tema2'),
	(3,3,2,'~/Tema3'),
	(4,3,1,'~/Tema4'),
	(1,4,1,'~/Tema2'),
	(1,5,1,'~/Tema3'),
	(1,6,1,'~/Tema4'),
	(1,7,2,'~/Tema2'),
	(1,8,1,'~/Tema1');

INSERT INTO PERFIL (nombrePerfil,id_ecualizacionDefect,path_skin,id_carpetaRaiz) VALUES
	('Defecto_Usuario1',1,'Default',1),
	('Defecto_Usuario2',1,'Default',2),
	('Mi Perfil',1,'Default',3);

INSERT INTO USUARIO (nombreUsuario,id_perfil) VALUES
	('Usuario1',1),
	('Usuario2',2);

UPDATE PERFIL SET id_usuario= 1 WHERE id_perfil=1;
UPDATE PERFIL SET id_usuario= 2 WHERE id_perfil=2;
UPDATE PERFIL SET id_usuario= 1 WHERE id_perfil=3;

INSERT INTO USA VALUES
	(1,'~/Skin1');
