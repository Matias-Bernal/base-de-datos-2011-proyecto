SET search_path="plarpebu";
-- RESETEAR TODO EL ESQUEMA
INSERT INTO CARPETA (nombreCarpeta,id_carpetaPadre) VALUES
	('Raiz1',null),
	('Raiz2',null)
;

INSERT INTO LISTA (nombreLista,id_carpeta) VALUES
	('Rock',1),
	('Heavy Metal',1),
	('Rock',2),
	('Nacional',2)
;

DELETE FROM LISTA;

INSERT INTO LISTA (nombreLista,id_carpeta) VALUES
	('Internacional',2),
	('Latinos',2),
	('Cuarteto',1),
	('Cumbia',1);
;

DELETE FROM LISTA;

SELECT * FROM LISTAELIMINADA;