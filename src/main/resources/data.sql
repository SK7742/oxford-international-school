--Drop tables
--drop table student_registration ;
--drop table student ;
--drop table standard_section ;
--drop table section ;
--drop table standard ;

-- Queries to populate standard table
INSERT INTO standard (standard_id,standard_code) VALUES (0,'NOT_ASSIGNED');
INSERT INTO standard (standard_id,standard_code) VALUES (1,'FIRST');
INSERT INTO standard (standard_id,standard_code) VALUES (2,'SECOND');
INSERT INTO standard (standard_id,standard_code) VALUES (3,'THIRD');
INSERT INTO standard (standard_id,standard_code) VALUES (4,'FOURTH');
INSERT INTO standard (standard_id,standard_code) VALUES (5,'FIFTH');
INSERT INTO standard (standard_id,standard_code) VALUES (11,'KG');
INSERT INTO standard (standard_id,standard_code) VALUES (12,'LKG');
INSERT INTO standard (standard_id,standard_code) VALUES (13,'UKG');

-- Queries to populate section table
INSERT INTO section (section_id,section_name) VALUES (0,'NOT_ASSIGNED');
INSERT INTO section (section_id,section_name) VALUES (1,'A');
INSERT INTO section (section_id,section_name) VALUES (2,'B');
INSERT INTO section (section_id,section_name) VALUES (3,'C');
INSERT INTO section (section_id,section_name) VALUES (4,'D');
INSERT INTO section (section_id,section_name) VALUES (5,'E');

-- Queries to populate standard section mapping table
INSERT INTO standard_section (section_id,standard_id) VALUES (0,0);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,11);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,12);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,13);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,1);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,2);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,3);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,4);
INSERT INTO standard_section (section_id,standard_id) VALUES (0,5);

