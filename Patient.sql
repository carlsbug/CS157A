CREATE TABLE REF_Occupation(
	Occup_ID SMALLINT not null,
	Name VARCHAR(25),
	PRIMARY KEY(Occup_ID)
);

CREATE TABLE REF_Works(
	WStatus_ID SMALLINT not null,
	Name VARCHAR(25),
	PRIMARY KEY(WStatus_ID)
);

CREATE TABLE REF_State(
	State_ID SMALLINT  not null,
	Name VARCHAR(25),
	PRIMARY KEY(State_ID)
);

CREATE TABLE REF_Country(
	Country_ID SMALLINT  not null,
	Name VARCHAR(25),
	PRIMARY KEY(Country_ID)
);

CREATE TABLE REF_Zip(
	ZIP_ID SMALLINT not null,
	Name VARCHAR(5),
	PRIMARY KEY(ZIP_ID)
);

CREATE TABLE Patient(
	THC varchar(6) not null,
	CurrentDate DATE,
	First_name VARCHAR(15) not null,
	Middle_name VARCHAR(15),
	Last_name VARCHAR(15) not null,
	Date_of_Birth DATE not null,
	Gender VARCHAR(1) not null,
	Phone INTEGER not null,
	Email VARCHAR(50),
	Street_Address VARCHAR(60) not null,
	City VARCHAR(30) not null,
	State_ID SMALLINT,
	ZIP_ID SMALLINT not null,
	Country_ID SMALLINT not null,
	Photo VARCHAR(1000),
	Social_Security_Number VARCHAR(10),
	Insurnace VARCHAR(10),

  -- Demographic
	WStatus_ID SMALLINT,
	Occup_ID SMALLINT,
	Educational_Degree VARCHAR(10),
	Tin_background CHAR(1),
	H_background CHAR(1),
	Tin_When Date,
	H_When Date,
	-- T_lnd_comments VARCHAR(10000),
	-- H_lnd_comments VARCHAR(10000)
	--
	-- Tinnitus_Onset VARCHAR(10),
	-- Tinnitus_Etiology VARCHAR(10),
	-- Hyperacusis_Onset VARCHAR(10),
	-- Hyperacusis_Etiology VARCHAR(10),


	CONSTRAINT PK_PATIENT PRIMARY KEY (THC),
	CONSTRAINT FK_PATIENT_REFERENCE_REF_COUN FOREIGN KEY(Country_ID) REFERENCES REF_Country(Country_ID) ON UPDATE CASCADE
	ON DELETE CASCADE,
	CONSTRAINT FK_PATIENT_REFERENCE_REF_STAT FOREIGN KEY(State_ID) REFERENCES REF_State(State_ID) ON UPDATE CASCADE
	ON DELETE CASCADE,
	CONSTRAINT FK_PATIENT_REFERENCE_REF_ZIP FOREIGN KEY(ZIP_ID) REFERENCES REF_Zip(ZIP_ID) ON UPDATE CASCADE
	ON DELETE CASCADE,
	CONSTRAINT FK_PATIENT_REFERENCE_REF_WORK FOREIGN KEY(WStatus_ID) REFERENCES REF_Works(WStatus_ID) ON UPDATE CASCADE
	ON DELETE CASCADE,
	CONSTRAINT FK_PATIENT_REFERENCE_REF_OCCU FOREIGN KEY(Occup_ID) REFERENCES REF_Occupation(Occup_ID) ON UPDATE CASCADE
	ON DELETE CASCADE
);



CREATE TABLE Visit(
	Visit_ID INTEGER not null,
	THC VARCHAR(1) not null,
	Visit_nr SMALLINT not null,
	Date DATETIME not null,
	Comments VARCHAR(150),

	CONSTRAINT PK_VISIT PRIMARY KEY (Visit_ID),
	CONSTRAINT FK_VISIT_REFERENCE_PATIENT FOREIGN KEY(THC) REFERENCES Patient(THC) ON UPDATE CASCADE
	ON DELETE CASCADE
);

insert into REF_Occupation values (0,'DOCTOR');
insert into REF_Occupation values (1,'EATER');
insert into REF_Occupation values (2,'LUXURY BED TESTER');
insert into REF_Occupation values (3,'SOFTWARE DEVELOPER');
insert into REF_Occupation values (4,'TEACHER');
insert into REF_Occupation values (5,'PROFESSOR');
insert into REF_Occupation values (6,'TAXI DRIVER');
insert into REF_Occupation values (7,'PILOT');
insert into REF_Occupation values (8,'STUDENT');
insert into REF_Occupation values (9,'LAWYER');

insert into REF_Zip values (0,'00000');
insert into REF_Zip values (1,'95112');
insert into REF_Zip values (2,'95126');
insert into REF_Zip values (3,'95555');
insert into REF_Zip values (4,'35007');
insert into REF_Zip values (5,'99501');
insert into REF_Zip values (6,'85006');
insert into REF_Zip values (7,'95123');
insert into REF_Zip values (8,'95143');
insert into REF_Zip values (9,'95512');
insert into REF_Zip values (10,'35237');
insert into REF_Zip values (11,'92131');
insert into REF_Zip values (12,'82346');


insert into REF_Works values (0,'ACTIVE');
insert into REF_Works values (1,'NOT ACTIVE');


insert into REF_State values (0,'arkansas');
insert into REF_State values (1,'california');
insert into REF_State values (2,'colorado');
insert into REF_State values (3,'connecticut');
insert into REF_State values (4,'delaware');
insert into REF_State values (5,'florida');
insert into REF_State values (6,'georgia');
insert into REF_State values (7,'hawaii');
insert into REF_State values (8,'idaho');
insert into REF_State values (9,'illinois');
insert into REF_State values (10,'indiana');
insert into REF_State values (11,'iowa');
insert into REF_State values (12,'kansas');
insert into REF_State values (13,'kentucky');
insert into REF_State values (14,'louisiana');
insert into REF_State values (15,'maine');
insert into REF_State values (16,'maryland');
insert into REF_State values (17,'massachusetts');
insert into REF_State values (18,'michigan');
insert into REF_State values (19,'minnesota');
insert into REF_State values (20,'mississippi');
insert into REF_State values (21,'missouri');
insert into REF_State values (22,'montana');
insert into REF_State values (23,'nebraska');
insert into REF_State values (24,'nevada');
insert into REF_State values (25,'new Hampshire');
insert into REF_State values (26,'new Jersey');
insert into REF_State values (27,'new Mexico');
insert into REF_State values (28,'new York');
insert into REF_State values (29,'north Carolina');
insert into REF_State values (30,'north Dakota');
insert into REF_State values (31,'ohio');
insert into REF_State values (32,'oklahoma');
insert into REF_State values (33,'oregon');
insert into REF_State values (34,'pennsylvania');
insert into REF_State values (35,'rhode Island');
insert into REF_State values (36,'south Carolina');
insert into REF_State values (37,'south Dakota');
insert into REF_State values (38,'tennessee');
insert into REF_State values (39,'texas');
insert into REF_State values (40,'utah');
insert into REF_State values (41,'vermont');
insert into REF_State values (42,'virginia');
insert into REF_State values (43,'washington');
insert into REF_State values (44,'west Virginia');
insert into REF_State values (45,'wisconsin');
insert into REF_State values (46,'wyoming');
insert into REF_State values (47,'Alabama');
insert into REF_State values (48,'Alaska');
insert into REF_State values (49,'Arizona');
insert into REF_State values (50,'Arkansas');



insert into REF_Country values (0,'south korea');
insert into REF_Country values (1,'pakistan');
insert into REF_Country values (2,'ethiophia');
insert into REF_Country values (3,'united states');
insert into REF_Country values (4,'afghanistan');
insert into REF_Country values (5,'albania');
insert into REF_Country values (6,'algeria');
insert into REF_Country values (7,'austria');
insert into REF_Country values (8,'poland');
insert into REF_Country values (9,'belgium');
insert into REF_Country values (10,'brazil');
insert into REF_Country values (11,'canada');
insert into REF_Country values (12,'chile');
insert into REF_Country values (13,'china');
insert into REF_Country values (14,'colombia');
insert into REF_Country values (15,'costa Rica');
insert into REF_Country values (16,'cuba');
insert into REF_Country values (17,'denmark');
insert into REF_Country values (18,'dominica');
insert into REF_Country values (19,'egypt');
insert into REF_Country values (20,'france');
insert into REF_Country values (21,'greece');
insert into REF_Country values (22,'india');
insert into REF_Country values (23,'iran');
insert into REF_Country values (24,'italy');
insert into REF_Country values (25,'israel');
insert into REF_Country values (26,'liberia');
insert into REF_Country values (27,'mexico');
insert into REF_Country values (28,'russia');
insert into REF_Country values (29,'taiwan');
insert into REF_Country values (30,'vietnam');


