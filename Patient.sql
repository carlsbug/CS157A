CREATE TABLE REF_Occupation(
	Occup_ID SMALLINT PRIMARY KEY,
    Name VARCHAR(25)
);

CREATE TABLE REF_Works(
	WStatus_ID SMALLINT PRIMARY KEY,
    Name VARCHAR(25)
);

CREATE TABLE REF_State(
	State_ID SMALLINT PRIMARY KEY,
    Name VARCHAR(25)
);

CREATE TABLE REF_Country(
	Country_ID SMALLINT PRIMARY KEY,
    Name VARCHAR(25)
);

CREATE TABLE REF_Zip(
	ZIP_ID SMALLINT PRIMARY KEY,
    Name VARCHAR(25)
);

create table Patient(
	THC varchar(6)  PRIMARY KEY,
	Country_ID SMALLINT, 
    State_ID SMALLINT, 
    ZIP_ID SMALLINT, 
    WStatus_ID SMALLINT,
    Occup_ID SMALLINT, 
    Surname VARCHAR(25), 
    First_name VARCHAR(15),
    SSN VARCHAR(10),
    DOB DATE,
    Insurance VARCHAR(10),
    Tin_Background CHAR(1),
    H_Background CHAR(1),
    Tin_WHEN DATE,
    H_when DATE,
    T_Ind_comments VARCHAR(10000),
    H_Ind_comments VARCHAR(10000),
    
    FOREIGN KEY(Country_ID) REFERENCES REF_Country(Country_ID)ON UPDATE CASCADE
        ON DELETE CASCADE
);



