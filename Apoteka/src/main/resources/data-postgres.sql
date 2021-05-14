INSERT INTO apotecaries(id,adress,description,name) values (1, 'neka adresa', 'deskripcija', 'Apoteka1');

INSERT INTO administrators(id, firstname, lastname, username, password, email, adress, city, country, phone,apotecary_id, first_time_login) VALUES (15,'admin','admin1','admin','admin','admin@gmail.com','g','h','i','j',1, false);

INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (2,'b','v','derma1','derma1','f','g','h','i','j','07:00','15:00',1, false);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (3,'asdf','asdfv','derma2','derma2','asdff','asdfg','asdfh','asdfi','asdfj','08:00','13:00',1, false);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (4,'sgb','gsv','derma3','derma3','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj','07:00','15:00',1, false);

INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (5,'hgah','haha','pharma1','pharma1','haha','gsgsg','adgag','yuky','ag','07:00','15:00',1, false);

INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone,first_time_login) VALUES (6,'a','b','pati1','pati1','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj', false);
INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone,first_time_login) VALUES (7,'aasdf','pati2','pati2','pati2','ghk','ghk','nghn','gssgi','jswssdf', false);


INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (1,3.5,2,6);
INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (2,5,3,7);

INSERT INTO pharmacist_ratings(id,rating,pharmacist_id,patient_id) VALUES (10,4, 5,6);
INSERT INTO pharmacist_ratings(id,rating,pharmacist_id,patient_id) VALUES (11,5, 5,7);

INSERT INTO apotecary_ratings(id,rating,apotecary_id,patient_id) VALUES (1,5, 1,6);
INSERT INTO apotecary_ratings(id,rating,apotecary_id,patient_id) VALUES (2,4, 1,7);

INSERT INTO consultations(id, duration, price, report, start_date, start_time, status, apotecary_id, patient_id, pharmacist_id) values
                        (1, 20, 100.00, 'Report', '12/04/2021','07:00', 1, 1,6,5);

INSERT INTO visits(id, duration, price, report, start_date, start_time, status, apotecary_id, dermatologist_id, patient_id) values
                    (1, 20, 100.00, 'Report', '12/04/2021','07:00', 1, 1,2,6);

INSERT INTO medications(id,type,name,specification) VALUES (1,1,'Antibiotik1', 'Specifikacija1');
INSERT INTO medications(id,type,name,specification) VALUES (2,1,'Antibiotik2', 'Specifikacija2');
INSERT INTO medications(id,type,name,specification) VALUES (3,0,'Anestetik1', 'Specifikacija3');
INSERT INTO medications(id,type,name,specification) VALUES (4,0,'Anestetik2', 'Specifikacija4');


INSERT INTO alergies(id,medication_id,patient_id) VALUES (1,1,6);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (2,2,6);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (3,3,7);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (4,4,7);

INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (1,100,1500,'12/08/2021','07:00', 1, 1);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (2,50,1000,'11/09/2021','07:00', 1, 2);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (3,75,500,'10/07/2021','07:00', 1, 3);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (4,150,750,'03/06/2021','07:00', 1, 4);

INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (1,4, 1,6);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (2,5, 1,7);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (3,2.5,2,6);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (4,3.7,2,7);

INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (1,7,'10/09/2021','07:00',1,1,null,1,6,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (2,10,'12/09/2021','08:00',1,1,1,2,6,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (3,5,'11/06/2021','09:00',1,1,null,3,7,1);

INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (1, 'Contradictions1', 'Composition1', 'Daily_Intake1', 'Replacement_drugs1',1);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (2, 'Contradictions2', 'Composition2', 'Daily_Intake2', 'Replacement_drugs2',2);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (3, 'Contradictions3', 'Composition3', 'Daily_Intake3', 'Replacement_drugs3',3);
