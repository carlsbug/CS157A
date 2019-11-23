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
	THC varchar(6) AUTO_INCREMENT PRIMARY KEY,
	Country_ID SMALLINT, #if not null, mandatory?
    State_ID SMALLINT, #it's null so optional, isn't it?
    ZIP_ID SMALLINT, # or maybe we dont constraint foreign key here
    WStatus_ID SMALLINT, #cuz anyways, they are primary key in its table
    Occup_ID SMALLINT, #F
    Surname VARCHAR(25), # Below here, those are all optional on the picture...
    First_name VARCHAR(15),
    SSN VARCHAR(10),
    DOB DATE,
    Insurance VARCHAR(10),
    Tin_Background CHAR(1),
    H_Background CHAR(1),
    Tin_WHEN DATE,
    H_when DATE,
    T_Ind_comments VARCHAR(65535),
    H_Ind_comments VARCHAR(65535),
    
    FOREIGN KEY(Country_ID) REFERENCES REF_Country(Country_ID),
    FOREIGN KEY(State_ID) REFERENCES REF_Status(State_ID),
    FOREIGN KEY(ZIP_ID) REFERENCES REF_Zip(ZIP_ID),
    FOREIGN KEY(WStatus_ID) REFERENCES REF_Works(WStatus_ID),
    FOREIGN KEY(Occup_ID) REFERENCES REF_Occupation(Occup_ID)
);




