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

INSERT INTO medications(id,type,name,specification) VALUES (1,1,'Antibiotik1', 'Specifikacija1');
INSERT INTO medications(id,type,name,specification) VALUES (2,1,'Antibiotik2', 'Specifikacija2');
INSERT INTO medications(id,type,name,specification) VALUES (3,2,'Anestetik1', 'Specifikacija3');
INSERT INTO medications(id,type,name,specification) VALUES (4,2,'Anestetik2', 'Specifikacija4');


INSERT INTO alergies(id,medication_id,patient_id) VALUES (1,1,1);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (2,2,1);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (3,3,2);
INSERT INTO alergies(id,medication_id,patient_id) VALUES (4,4,2);

INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (1,100,1500,'13/08/2021','07:00', 1, 1);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (2,50,1000,'15/09/2021','07:00', 1, 2);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (3,75,500,'12/07/2021','07:00', 1, 3);
INSERT INTO medication_info(id,in_storage,price,price_duration_end_date, price_duration_end_time,apotecary_id,medication_id) VALUES (4,150,750,'23/06/2021','07:00', 1, 4);

INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (1,4, 1,1);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (2,5, 1,2);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (3,2.5,2,1);
INSERT INTO medication_ratings(id,rating,medication_id,patient_id) VALUES (4,3.7,2,2);

INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (1,7,'15/09/2021','07:00',1,1,null,1,1,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (2,10,'12/09/2021','08:00',1,1,1,2,1,null);
INSERT INTO medication_reservation(id,quantity,reservation_end_date, reservation_end_time,status,apotecary_id,consultation_id,medication_info_id,patient_id,visit_id)
VALUES (3,5,'11/06/2021','09:00',1,1,null,3,2,1);

INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (1, 'Contradictions1', 'Composition1', 'Daily_Intake1', 'Replacement_drugs1',1);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (2, 'Contradictions2', 'Composition2', 'Daily_Intake2', 'Replacement_drugs2',2);
INSERT INTO medication_specification(id,contradictions,composition,daily_intake,replacement_drugs,medication_id) VALUES (3, 'Contradictions3', 'Composition3', 'Daily_Intake3', 'Replacement_drugs3',3);
