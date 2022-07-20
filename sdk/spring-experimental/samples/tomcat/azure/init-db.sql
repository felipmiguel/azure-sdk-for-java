\c checklist;

--
-- Table structure for table checklist
--

DROP TABLE IF EXISTS checklist;
CREATE TABLE checklist (
  ID SERIAL PRIMARY KEY ,
  name varchar(35) NOT NULL DEFAULT '',
  date date not null,
  description varchar(75) NULL DEFAULT ''
) ;

DROP TABLE IF EXISTS checkitem;
CREATE TABLE checkitem (
  ID SERIAL PRIMARY KEY ,
  checklist_ID INT NOT NULL,
  description varchar(75) NULL DEFAULT '',
  FOREIGN KEY (checklist_ID) REFERENCES checklist(ID)
) ;