INSERT INTO apotecaries(id,adress,description,name) values (10, 'neka adresa1', 'deskripcija1', 'Apoteka1');
INSERT INTO apotecaries(id,adress,description,name) values (11, 'neka adresa2', 'deskripcija2', 'Apoteka2');
INSERT INTO apotecaries(id,adress,description,name) values (12, 'neka adresa3', 'deskripcija3', 'Apoteka3');

INSERT INTO administrators(id, firstname, lastname, username, password, email, adress, city, country, phone,apotecary_id, first_time_login) VALUES (15,'admin','admin1','admin','admin','admin@gmail.com','g','h','i','j',10, false);

INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (16,'b','v','derma1','derma1','f','g','h','i','j','07:00','15:00',10, false);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (17,'asdf','asdfv','derma2','derma2','asdff','asdfg','asdfh','asdfi','asdfj','08:00','13:00',10, false);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (18,'sgb','gsv','derma3','derma3','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj','07:00','15:00',10, false);

INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (19,'hgah','haha','pharma1','pharma1','haha','gsgsg','adgag','yuky','ag','07:00','15:00',10, false);
INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (20,'tjtjtj','tjtj','pharma2','pharma2','tjtj','tjtj','tjtj','tjtj','tjtj','07:00','15:00',11, false);
INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (21,'nvnvnvn','nvnv','pharma3','pharma3','vnvn','vnvn','vnvn','vnvn','vnvn','07:00','15:00',12, false);

INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone,first_time_login) VALUES (20,'a','b','pati1','pati1','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj', false);
INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone,first_time_login) VALUES (21,'aasdf','pati2','pati2','pati2','ghk','ghk','nghn','gssgi','jswssdf', false);


INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (1,3.5,16,20);
INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (2,5,17,21);

INSERT INTO pharmacist_ratings(id,rating,pharmacist_id,patient_id) VALUES (10,4, 19,20);
INSERT INTO pharmacist_ratings(id,rating,pharmacist_id,patient_id) VALUES (11,5, 19,21);

INSERT INTO apotecary_ratings(id,rating,apotecary_id,patient_id) VALUES (1,5, 10,20);
INSERT INTO apotecary_ratings(id,rating,apotecary_id,patient_id) VALUES (2,4, 10,21);

INSERT INTO consultations(id, duration, price, report, start_date, start_time, status, apotecary_id, patient_id, pharmacist_id) values
                        (1, 20, 100.00, 'Report', '12/04/2021','07:00', 1, 10,20,19);

INSERT INTO visits(id, duration, price, report, start_date, start_time, status, apotecary_id, dermatologist_id, patient_id) values
                    (1, 20, 100.00, 'Report', '12/04/2021','07:00', 1, 10,17,20);

INSERT INTO medications(id,medication_type,name) VALUES (10,1,'Antibiotik1');
INSERT INTO medications(id,medication_type,name) VALUES (11,1,'Antibiotik2');
INSERT INTO medications(id,medication_type,name) VALUES (12,0,'Anestetik1');
INSERT INTO medications(id,medication_type,name) VALUES (13,0,'Anestetik2');
INSERT INTO medications(id,medication_type,name) VALUES (14,0,'Anestetik3');


INSERT INTO alergies(id,medication_id,patient_id) VALUES (1,10,20);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (2,11,20);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (3,12,21);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (4,13,21);

INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (10,100,1500,'12/08/2021','07:00', 10, 10);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (11,50,1000,'11/09/2021','07:00', 10, 11);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (12,75,500,'10/07/2021','07:00', 10, 12);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (13,150,750,'03/06/2021','07:00', 10, 13);

INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (10,4, 10,20);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (11,5, 11,21);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (12,2.5,12,20);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (13,3.7,13,21);

INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (10,7,'10/09/2021','07:00',1,10,null,10,20,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (11,10,'12/09/2021','08:00',1,10,1,11,20,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (12,5,'11/06/2021','09:00',1,10,null,12,21,1);

INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (10, 'Contradictions1', 'Composition1', 'Daily_Intake1', 'Replacement_drugs1',10);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (11, 'Contradictions2', 'Composition2', 'Daily_Intake2', 'Replacement_drugs2',11);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (12, 'Contradictions3', 'Composition3', 'Daily_Intake3', 'Replacement_drugs3',12);
