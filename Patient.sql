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
	Name VARCHAR(25),
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
	WStatus_ID SMALLINT not null,
	Occup_ID SMALLINT not null,
	Educational_Degree VARCHAR(10),
	Tin_background CHAR(1),
	H_background CHAR(1),
	Tin_When Date,
	H_When Date
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
