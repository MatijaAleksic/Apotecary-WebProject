INSERT INTO administrators(id, firstname, lastname, username, password, email, adress, city, country, phone) VALUES (1,'b','v','d','e','f','g','h','i','j');

INSERT INTO apotecaries(id,adress,description,name) values (1, 'neka adresa', 'deskripcija', 'Apoteka1');

INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (1,'b','v','d','e','f','g','h','i','j','07:00','15:00',1);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (2,'asdf','asdfv','asdfd','asdfe','asdff','asdfg','asdfh','asdfi','asdfj','08:00','13:00',1);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (3,'sgb','gsv','dggsg','gsgse','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj','07:00','15:00',1);

INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone) VALUES (1,'a','b','dggsg','gsgse','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj');

INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (1,3.5, 1,1);