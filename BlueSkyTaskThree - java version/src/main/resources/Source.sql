CREATE TABLE Branches(
	Id   INT              NOT NULL,
	Name VARCHAR (50)     NOT NULL,
	Description VARCHAR (50)     NOT NULL,
	City VARCHAR (50)     NOT NULL,
	State VARCHAR (50)     NOT NULL,
	PostCode INT    NOT NULL,
	Country VARCHAR (50)     NOT NULL,
	Contact VARCHAR (50)     NOT NULL,
	Phone VARCHAR (50)     NOT NULL,   
	PRIMARY KEY (ID)
);


CREATE TABLE Customers(
	Id   INT              NOT NULL,
	FirstName VARCHAR (50)     NOT NULL,
	LastName VARCHAR (50)     NOT NULL,
	Address1 VARCHAR (50)     NOT NULL,
    Address2 VARCHAR (50)     NOT NULL,
	City VARCHAR (50)     NOT NULL,
	State VARCHAR (50)     NOT NULL,
	PostCode INT    NOT NULL,
	Country VARCHAR (50)     NOT NULL,
	Contact VARCHAR (50)     NOT NULL,
	Phone1 VARCHAR (50)     NOT NULL,   
    Phone2 VARCHAR (50)     NOT NULL,   
	Fax VARCHAR (50)     NOT NULL,   
	Email VARCHAR (50)     NOT NULL,   
	Website VARCHAR (50)     NOT NULL,   
	Company VARCHAR (50)     NOT NULL,   
	Branch_id int FOREIGN KEY REFERENCES Branches(id),		   
	PRIMARY KEY (ID)
);

INSERT INTO Branches (Id, Name, Description, City, State, PostCode, Country,Contact,Phone)
VALUES (1,'Fatih','IT administrator','Perth','WA',6061,'Australai','Phone','0470254588');

INSERT INTO Branches (Id, Name, Description, City, State, PostCode, Country,Contact,Phone)
VALUES (2,'Ali','IT administrator','Perth','WA',6061,'Australai','Phone','0470254588');

INSERT INTO Branches (Id, Name, Description, City, State, PostCode, Country,Contact,Phone)
VALUES (3,'Deli','IT administrator','Perth','WA',6061,'Australai','Phone','0470254588');




INSERT INTO Customers (Id, FirstName, LastName, Address1,Address2, City, State, PostCode, Country,Contact,Phone1,Phone2,Fax,Email, Website,Company,Branch_id)
VALUES (101,'Kemal','Tahir','15B Tery St','20C Blue St','Perth','WA',6061,'Australai','Phone','0470254588','0470254583','0470254528','kem@gmail.com','www.kem.org','TerGem',1);

INSERT INTO Customers (Id, FirstName, LastName, Address1,Address2, City, State, PostCode, Country,Contact,Phone1,Phone2,Fax,Email, Website,Company,Branch_id)
VALUES (102,'Halit','Tahir','15B Tery St','20C Blue St','Perth','WA',6061,'Australai','Phone','0470254588','0470254583','0470254528','kem@gmail.com','www.kem.org','TerGem',2);

INSERT INTO Customers (Id, FirstName, LastName, Address1,Address2, City, State, PostCode, Country,Contact,Phone1,Phone2,Fax,Email, Website,Company,Branch_id)
VALUES (103,'Caner','Tahir','15B Tery St','20C Blue St','Perth','WA',6061,'Australai','Phone','0470254588','0470254583','0470254528','kem@gmail.com','www.kem.org','TerGem',3);

