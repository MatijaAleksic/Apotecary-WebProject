INSERT INTO apotecaries(id,adress,description,name) values (1, 'neka adresa', 'deskripcija', 'Apoteka1');


INSERT INTO administrators(id, firstname, lastname, username, password, email, adress, city, country, phone,apotecary_id) VALUES (1,'b','v','d','e','f','g','h','i','j',1);

INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (1,'b','v','d','e','f','g','h','i','j','07:00','15:00',1);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (2,'asdf','asdfv','asdfd','asdfe','asdff','asdfg','asdfh','asdfi','asdfj','08:00','13:00',1);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (3,'sgb','gsv','dggsg','gsgse','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj','07:00','15:00',1);

INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id) VALUES (1,'hgah','haha','ahhh','gsgse','haha','gsgsg','adgag','yuky','ag','07:00','15:00',1);

INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone) VALUES (1,'a','b','dggsg','gsgse','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj');
INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone) VALUES (2,'aasdf','basdf','ahha','ukyg','ghk','ghk','nghn','gssgi','jswssdf');


INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (1,3.5,1,1);
INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (2,5,1,2);

INSERT INTO pharmacist_ratings(id,rating,pharmacist_id,patient_id) VALUES (1,4, 1,1);
INSERT INTO pharmacist_ratings(id,rating,pharmacist_id,patient_id) VALUES (2,5, 1,2);

INSERT INTO apotecary_ratings(id,rating,apotecary_id,patient_id) VALUES (1,5, 1,1);
INSERT INTO apotecary_ratings(id,rating,apotecary_id,patient_id) VALUES (2,4, 1,2);

INSERT INTO consultations(id, duration, price, report, start_date, start_time, status, apotecary_id, patient_id, pharmacist_id) values
                        (1, 20, 100.00, 'Report', '13/04/2021','07:00', 1, 1,1,1);

INSERT INTO visits(id, duration, price, report, start_date, start_time, status, apotecary_id, dermatologist_id, patient_id) values
(1, 20, 100.00, 'Report', '13/04/2021','07:00', 1, 1,1,1);
