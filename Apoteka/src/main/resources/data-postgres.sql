INSERT INTO apotecaries(id,adress,description,name) values (10, 'neka adresa1', 'deskripcija1', 'Apoteka1');
INSERT INTO apotecaries(id,adress,description,name) values (11, 'neka adresa2', 'deskripcija2', 'Apoteka2');
INSERT INTO apotecaries(id,adress,description,name) values (12, 'neka adresa3', 'deskripcija3', 'Apoteka3');

INSERT INTO administrators(id, firstname, lastname, username, password, email, adress, city, country, phone,apotecary_id, first_time_login) VALUES (15,'admin','admin1','admin','admin','admin@gmail.com','g','h','i','j',10, false);

INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (16,'Pera','Peric','derma1','derma1','pera@gmail.com','Address3','City3','Country2','062 124 27 32','07:00','15:00',10, false);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (17,'Marko','Markovic','marko1','marko1','marko@gmail.com','Address1','City1','Country3','063 929 82 32','08:00','13:00',10, false);
INSERT INTO dermatologists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (18,'Dusan','Dusanovic','dusan1','dusan1','dusan@gmail.com','Address2','City2','Country1','062 224 24 32','09:00','17:00',10, false);

INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (19,'Pavle','Pavlovic','pharma1','pharma1','pavle@gmail','Address3','City2','Country2','061 224 24 32','09:00','16:00',10, false);
INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (20,'Milica','Milkovic','milica1','milica1','milica@gmail.com','Address1','City1','Country2','063 224 24 32','08:00','15:00',11, false);
INSERT INTO pharmacists(id, firstname, lastname, username, password, email, adress, city, country, phone, start_hours, end_hours, apotecary_id,first_time_login) VALUES (21,'Uros','Urosevic','uros1','uros1','uros@gmail.com','Address2','City3','Country3','062 224 24 32','07:00','13:00',12, false);

INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone,first_time_login) VALUES (20,'a','b','pati1','pati1','gsgsf','gsgsg','gsgsh','gssgi','sgsgsj', false);
INSERT INTO patients(id, firstname, lastname, username, password, email, adress, city, country, phone,first_time_login) VALUES (21,'aasdf','pati2','pati2','pati2','ghk','ghk','nghn','gssgi','jswssdf', false);


INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (1,3.5,16,20);
INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (2,5,16,21);
INSERT INTO dermatologist_ratings(id,rating,dermatologist_id,patient_id) VALUES (3,5,17,21);

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


INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (15,100,1500,'12/08/2021','07:00', 10, 10);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (16,50,1000,'11/09/2021','07:00', 10, 11);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (17,75,500,'10/07/2021','07:00', 10, 12);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (18,150,750,'03/06/2021','07:00', 10, 13);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (19,25,100,'08/06/2021','09:00', 11, 13);


INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (10,4, 10,20);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (11,5, 11,21);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (12,2.5,12,20);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (13,3.7,13,21);

INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (31,7,'10/09/2021','07:00',1,10,null,15,20,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (32,10,'12/09/2021','08:00',1,10,1,16,20,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (33,5,'11/06/2021','09:00',1,12,null,17,21,1);

INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (10, 'Contradictions2', 'Composition2', 'Daily_Intake2', 'Replacement_drugs1',10);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (11, 'Contradictions1', 'Composition3', 'Daily_Intake2', 'Replacement_drugs2',11);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (12, 'Contradictions3', 'Composition4', 'Daily_Intake1', 'Replacement_drugs4',12);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (13, 'Contradictions4', 'Composition1', 'Daily_Intake3', 'Replacement_drugs2',13);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (14, 'Contradictions5', 'Composition5', 'Daily_Intake5', 'Replacement_drugs5',14);


INSERT INTO vacation_pharmacist(id,approved ,description, finish_date, start_date, pharmacist_id) VALUES (25,FALSE ,'Odo se kupati u Grcku','05/07/2021', '10/07/2021',19);
INSERT INTO vacation_pharmacist(id,approved ,description, finish_date, start_date, pharmacist_id) VALUES (26,FALSE ,'Description2','02/01/2021', '15/11/2021',20);
INSERT INTO vacation_pharmacist(id,approved ,description, finish_date, start_date, pharmacist_id) VALUES (27,FALSE ,'Description3','07/09/2021', '07/04/2021',21);
