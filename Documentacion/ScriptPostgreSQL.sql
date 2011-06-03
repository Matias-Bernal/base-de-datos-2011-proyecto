drop schema Plarpebu cascade;
CREATE schema Plarpebu;

DROP TABLE IF EXISTS Plarpebu.SKIN;
CREATE TABLE Plarpebu.SKIN (
		path_skin varchar(40) NOT NULL,
		nombreSkin varchar(40) NOT NULL,
		CONSTRAINT pk_skin PRIMARY KEY (path_skin)
);

DROP TABLE IF EXISTS Plarpebu.GENERO;
CREATE TABLE Plarpebu.GENERO (
		nombreGenero varchar(40) NOT NULL,
		CONSTRAINT pk_genero PRIMARY KEY (nombreGenero)
);

DROP TABLE IF EXISTS Plarpebu.TEMA;
CREATE TABLE Plarpebu.TEMA (
		path_tema varchar(40) NOT NULL,
		anio int NOT NULL,
		titulo varchar(40) NOT NULL,
		artista varchar(40) NOT NULL,
		album varchar(40) NOT NULL,
		nombreGenero varchar(40) NOT NULL,
		duracion time NOT NULL,
		CONSTRAINT pk_tema PRIMARY KEY (path_tema),
		CONSTRAINT fk_nombreGenero FOREIGN KEY (nombreGenero) REFERENCES Plarpebu.GENERO (nombreGenero),
		CONSTRAINT ctl_anio CHECK (anio>0)
);


CREATE DOMAIN Plarpebu.NumBanda AS int
CHECK (value>=1 and value<=32);

DROP TABLE IF EXISTS Plarpebu.BANDA;
CREATE TABLE Plarpebu.BANDA (
		num_banda Plarpebu.NumBanda NOT NULL,
		CONSTRAINT pk_banda PRIMARY KEY (num_banda)
);

CREATE SEQUENCE Plarpebu.ecualizacion_id_seq MINVALUE 1;
DROP TABLE IF EXISTS Plarpebu.ECUALIZACION;
CREATE TABLE Plarpebu.ECUALIZACION (
		id_ecualizacion int DEFAULT NEXTVAL('Plarpebu.ecualizacion_id_seq') NOT NULL,
		nombreEcualizacion varchar(40) NOT NULL,
		CONSTRAINT pk_ecualizacion PRIMARY KEY (id_ecualizacion)
);

CREATE DOMAIN Plarpebu.Frecuencia AS int
CHECK (value>=-12 and value<=12);

DROP TABLE IF EXISTS Plarpebu.COMPUESTO;
CREATE TABLE Plarpebu.COMPUESTO (
		id_ecualizacion int NOT NULL,
		num_banda Plarpebu.NumBanda NOT NULL,
		valor Plarpebu.Frecuencia DEFAULT 0 NOT NULL,
		CONSTRAINT pk_compuesto PRIMARY KEY (id_ecualizacion,num_banda),
		CONSTRAINT fk_ecualizacion FOREIGN KEY (id_ecualizacion) REFERENCES Plarpebu.ECUALIZACION (id_ecualizacion),
		CONSTRAINT fk_num_banda FOREIGN KEY (num_banda) REFERENCES Plarpebu.BANDA (num_banda)
);

CREATE SEQUENCE Plarpebu.orden_id_seq MINVALUE 1;
DROP TABLE IF EXISTS Plarpebu.ORDEN;
CREATE TABLE Plarpebu.ORDEN (
		num_orden int DEFAULT NEXTVAL('Plarpebu.orden_id_seq') NOT NULL,
		CONSTRAINT pk_orden PRIMARY KEY (num_orden)
		--CONSTRAINT ctl_num_orden CHECK (num_orden>0)
);

CREATE SEQUENCE Plarpebu.carpeta_id_seq MINVALUE 1;
DROP TABLE IF EXISTS Plarpebu.CARPETA;
CREATE TABLE Plarpebu.CARPETA (
		id_carpeta int DEFAULT NEXTVAL('Plarpebu.carpeta_id_seq') NOT NULL,
		nombreCarpeta varchar(40) NOT NULL,
		id_carpetaPadre int,
		CONSTRAINT pk_carpeta PRIMARY KEY (id_carpeta),
		CONSTRAINT ctl_carpeta CHECK (id_carpeta<>id_carpetaPadre),
		CONSTRAINT ctl_nombre_carpetaPadre UNIQUE (id_carpetaPadre,nombreCarpeta)
);

ALTER TABLE Plarpebu.CARPETA ADD CONSTRAINT fk_id_carpetaPadre FOREIGN KEY (id_carpetaPadre) REFERENCES Plarpebu.CARPETA (id_carpeta);

DROP TABLE IF EXISTS Plarpebu.RAIZ;
CREATE TABLE Plarpebu.RAIZ (
		id_carpetaRaiz int NOT NULL UNIQUE,
		CONSTRAINT fk_id_carpetaRaiz FOREIGN KEY (id_carpetaRaiz) REFERENCES Plarpebu.CARPETA (id_carpeta)

);


CREATE SEQUENCE Plarpebu.lista_id_seq MINVALUE 1;
DROP TABLE IF EXISTS Plarpebu.LISTA;
CREATE TABLE Plarpebu.LISTA (
		id_lista int DEFAULT NEXTVAL('Plarpebu.lista_id_seq') NOT NULL,
		nombreLista varchar(40) NOT NULL,
		id_carpeta int NOT NULL,
		CONSTRAINT pk_lista PRIMARY KEY (id_lista),
		CONSTRAINT fk_id_carpeta FOREIGN KEY (id_carpeta) REFERENCES Plarpebu.CARPETA (id_carpeta),
		CONSTRAINT ctl_nombreLista_carpeta UNIQUE (id_carpeta,nombreLista)
);

DROP TABLE IF EXISTS Plarpebu.SE_REPR;
CREATE TABLE Plarpebu.SE_REPR (
		num_orden int NOT NULL,
		id_lista int NOT NULL,
		id_ecualizacion int DEFAULT NULL,
		path_tema varchar(40) NOT NULL,
		CONSTRAINT pk_se_repr PRIMARY KEY (id_lista,num_orden),
		CONSTRAINT fk_id_ecualizacion FOREIGN KEY (id_ecualizacion) REFERENCES Plarpebu.ECUALIZACION (id_ecualizacion),
		CONSTRAINT fk_num_orden FOREIGN KEY (num_orden) REFERENCES Plarpebu.ORDEN (num_orden),
		CONSTRAINT fk_path_tema FOREIGN KEY (path_tema) REFERENCES Plarpebu.TEMA (path_tema),
		CONSTRAINT fk_id_lista FOREIGN KEY (id_lista) REFERENCES Plarpebu.LISTA (id_lista)
		--CONSTRAINT ctl_num_orden CHECK (num_orden>0)
);

CREATE SEQUENCE Plarpebu.perfil_id_seq MINVALUE 1;
DROP TABLE IF EXISTS Plarpebu.PERFIL;
CREATE TABLE Plarpebu.PERFIL (
		id_perfil int DEFAULT NEXTVAL('Plarpebu.perfil_id_seq') NOT NULL,
		nombrePerfil varchar(40) NOT NULL,
		id_ecualizacionDefect int NOT NULL,
		path_skin varchar(40) NOT NULL,
		id_carpetaRaiz int NOT NULL,
		id_usuario int DEFAULT NULL,
		CONSTRAINT pk_perfil PRIMARY KEY (id_perfil),
		CONSTRAINT fk_id_ecualizador FOREIGN KEY (id_ecualizacionDefect) REFERENCES Plarpebu.ECUALIZACION (id_ecualizacion),
		CONSTRAINT fk_path_skin FOREIGN KEY (path_skin) REFERENCES Plarpebu.SKIN (path_skin),
		CONSTRAINT fk_id_carpetaRaiz FOREIGN KEY (id_carpetaRaiz) REFERENCES Plarpebu.RAIZ (id_carpetaRaiz)
);

CREATE SEQUENCE Plarpebu.usuario_id_seq MINVALUE 1;
DROP TABLE IF EXISTS  Plarpebu.USUARIO ;
CREATE TABLE Plarpebu.USUARIO (
		id_usuario int DEFAULT NEXTVAL('Plarpebu.usuario_id_seq') NOT NULL,
		nombreUsuario varchar(40) NOT NULL,
		id_perfil int NOT NULL,
		CONSTRAINT pk_usuario PRIMARY KEY (id_usuario)
);

ALTER TABLE Plarpebu.USUARIO ADD CONSTRAINT fk_id_perfil FOREIGN KEY (id_perfil) REFERENCES Plarpebu.PERFIL (id_perfil);
ALTER TABLE Plarpebu.PERFIL ADD CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario) REFERENCES Plarpebu.USUARIO (id_usuario);

DROP TABLE IF EXISTS Plarpebu.USA;
CREATE TABLE Plarpebu.USA (
		id_perfil int,
		path_skin varchar(40),
		CONSTRAINT pk_usa PRIMARY KEY (id_perfil,path_skin),
		CONSTRAINT fk_id_perfil FOREIGN KEY (id_perfil) REFERENCES Plarpebu.PERFIL (id_perfil),
		CONSTRAINT fk_path_skin FOREIGN KEY (path_skin) REFERENCES Plarpebu.SKIN (path_skin)
);

CREATE SEQUENCE Plarpebu.listaEliminada_id_seq MINVALUE 1;
DROP TABLE IF EXISTS Plarpebu.LISTAELIMINADA;
CREATE TABLE Plarpebu.LISTAELIMINADA (
		id_listaEliminada int DEFAULT NEXTVAL('Plarpebu.listaEliminada_id_seq') NOT NULL,
		id_lista int NOT NULL,
		fecha date NOT NULL,
		usuario varchar(40) NOT NULL,
		CONSTRAINT pk_listaEliminada PRIMARY KEY (id_listaEliminada)
);

-- funcion auditoria que guarda la lista eliminada, la fecha y el usuario que la elimino

CREATE FUNCTION funcion_auditoria() returns opaque as 'begin INSERT INTO Plarpebu.LISTAELIMINADA (id_lista,fecha,usuario) VALUES 
(old.id_lista,now(),user);
return null;
end;'
LANGUAGE 'plpgsql';

-- creamos el trigget que llama a nuestra funcion auditoria

CREATE TRIGGER trigger_funcion_auditoria AFTER DELETE ON Plarpebu.LISTA FOR EACH ROW
	EXECUTE PROCEDURE funcion_auditoria();
