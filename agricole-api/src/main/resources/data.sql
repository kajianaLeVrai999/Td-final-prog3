

INSERT INTO collectivity (id, number, name, location, occupation) VALUES
('col-1', 1, 'Mpanorina', 'Ambatondrazaka', 'RIZICULTURE'),
('col-2', 2, 'Dobo voalohany', 'Ambatondrazaka', 'PISCICULTURE'),
('col-3', 3, 'Tantely mamy', 'Brickaville', 'APICULTURE');


INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, collectivity_id, creation_date) VALUES
-- Collectivité 1
('C1-M1','Prénom 1','Nom 1','1980-02-01','M','Ambato.','Riziculteur','341234567','member.1@fed-agri.mg','PRESIDENT','col-1','2026-01-01'),
('C1-M2','Prénom 2','Nom 2','1982-03-05','M','Ambato.','Agriculteur','321234567','member.2@fed-agri.mg','VICE_PRESIDENT','col-1','2026-01-01'),
('C1-M3','Prénom 3','Nom 3','1992-03-10','M','Ambato.','Collecteur','331234567','member.3@fed-agrimg','SECRETAIRE','col-1','2026-01-01'),
('C1-M4','Prénom 4','Nom 4','1988-05-22','F','Ambato.','Distributeur','381234567','member.4@fed-agri.mg','TRESORIER','col-1','2026-01-01'),
('C1-M5','Prénom 5','Nom 5','1999-08-21','M','Ambato.','Riziculteur','373434567','member.5@fed-agri.mg','CONFIRME','col-1','2026-01-01'),
('C1-M6','Prénom 6','Nom 6','1998-08-22','F','Ambato.','Riziculteur','372234567','member.6@fed-agri.mg','CONFIRME','col-1','2026-01-01'),
('C1-M7','Prénom 7','Nom 7','1998-01-31','M','Ambato.','Riziculteur','374234567','member.7@fed-agri.mg','CONFIRME','col-1','2026-01-01'),
('C1-M8','Prénom 8','Nom 8','1975-08-20','M','Ambato.','Riziculteur','370234567','member.8@fed-agri.mg','CONFIRME','col-1','2026-01-01'),
-- Collectivité 2
('C2-M1','Prénom 1','Nom 1','1980-02-01','M','Ambato.','Riziculteur','341234567','member.1@fed-agri.mg','CONFIRME','col-2','2026-01-01'),
('C2-M2','Prénom 2','Nom 2','1982-03-05','M','Ambato.','Agriculteur','321234567','member.2@fed-agri.mg','CONFIRME','col-2','2026-01-01'),
('C2-M3','Prénom 3','Nom 3','1992-03-10','M','Ambato.','Collecteur','331234567','member.3@fed-agrimg','CONFIRME','col-2','2026-01-01'),
('C2-M4','Prénom 4','Nom 4','1988-05-22','F','Ambato.','Distributeur','381234567','member.4@fed-agri.mg','CONFIRME','col-2','2026-01-01'),
('C2-M5','Prénom 5','Nom 5','1999-08-21','M','Ambato.','Riziculteur','373434567','member.5@fed-agri.mg','PRESIDENT','col-2','2026-01-01'),
('C2-M6','Prénom 6','Nom 6','1998-08-22','F','Ambato.','Riziculteur','372234567','member.6@fed-agri.mg','VICE_PRESIDENT','col-2','2026-01-01'),
('C2-M7','Prénom 7','Nom 7','1998-01-31','M','Ambato.','Riziculteur','374234567','member.7@fed-agri.mg','SECRETAIRE','col-2','2026-01-01'),
('C2-M8','Prénom 8','Nom 8','1975-08-20','M','Ambato.','Riziculteur','370234567','member.8@fed-agri.mg','TRESORIER','col-2','2026-01-01'),
-- Collectivité 3
('C3-M1','Prénom 9','Nom 9','1988-01-02','M','Antsirabe','Apiculteur','34034567','member.9@fed-agri.mg','PRESIDENT','col-3','2026-01-01'),
('C3-M2','Prénom 10','Nom 10','1982-03-05','M','Antsirabe','Agriculteur','338634567','member.10@fed-agri.mg','VICE_PRESIDENT','col-3','2026-01-01'),
('C3-M3','Prénom 11','Nom 11','1992-03-12','M','Antsirabe','Collecteur','338234567','member.11@fed-agrimg','SECRETAIRE','col-3','2026-01-01'),
('C3-M4','Prénom 12','Nom 12','1988-05-10','F','Antsirabe','Distributeur','382334567','member.12@fed-agri.mg','TRESORIER','col-3','2026-01-01'),
('C3-M5','Prénom 13','Nom 13','1999-08-11','M','Antsirabe.','Apiculteur','373365567','member.13@fed-agri.mg','CONFIRME','col-3','2026-01-01'),
('C3-M6','Prénom 14','Nom 14','1998-08-09','F','Antsirabe.','Apiculteur','378234567','member.14@fed-agri.mg','CONFIRME','col-3','2026-01-01'),
('C3-M7','Prénom 15','Nom 15','1998-01-13','M','Antsirabe','Apiculteur','374914567','member.15@fed-agri.mg','CONFIRME','col-3','2026-01-01'),
('C3-M8','Prénom 16','Nom 16','1975-08-02','M','Antsirabe','Apiculteur','370634567','member.16@fed-agri.mg','CONFIRME','col-3','2026-01-01');

-- Anciens comptes 
INSERT INTO financial_account (id, account_type, amount, holder_name, mobile_number, mobile_banking_service, bank_name, bank_code, bank_branch_code, bank_account_number, bank_account_key, collectivity_id) VALUES
('C1-A-CASH', 'CASH', 0, '-', '-', NULL, NULL, NULL, NULL, NULL, NULL, 'col-1'),
('C1-A-MOBILE-1', 'MOBILE', 0, 'Mpanorina', '0370489612', 'ORANGE_MONEY', NULL, NULL, NULL, NULL, NULL, 'col-1'),
('C2-A-CASH', 'CASH', 0, '-', '-', NULL, NULL, NULL, NULL, NULL, NULL, 'col-2'),
('C2-A-MOBILE-1', 'MOBILE', 0, 'Dobo voalohany', '0320489612', 'ORANGE_MONEY', NULL, NULL, NULL, NULL, NULL, 'col-2'),
('C3-A-CASH', 'CASH', 0, '-', '-', NULL, NULL, NULL, NULL, NULL, NULL, 'col-3'),
('C3-A-BANK-1', 'BANK', 0, 'Koto', NULL, NULL, 'BMOI', '00004', '00001', '1234567890', '12', 'col-3'),
('C3-A-BANK-2', 'BANK', 0, 'Naivo', NULL, NULL, 'BRED', '00008', '00003', '4567890123', '58', 'col-3'),
('C3-A-MOBILE-1', 'MOBILE', 0, 'Kolo', '0341889612', 'MVOLA', NULL, NULL, NULL, NULL, NULL, 'col-3');

-- Cotisations
INSERT INTO membership_fee (id, label, status, frequency, eligible_from, amount, collectivity_id) VALUES
('cot-1', 'Cotisation annuelle', 'ACTIVE', 'ANNUALLY', '2026-01-01', 200000, 'col-1'),
('cot-2', 'Famangiana', 'ACTIVE', 'PUNCTUALLY', '2026-04-30', 20000, 'col-1'),
('cot-3', 'Cotisation annuelle', 'ACTIVE', 'ANNUALLY', '2026-01-01', 200000, 'col-2'),
('cot-4', 'Cotisation 2025', 'INACTIVE', 'ANNUALLY', '2025-01-01', 100000, 'col-2'),
('cot-5', 'Cotisation mensuelle', 'ACTIVE', 'MONTHLY', '2026-04-01', 25000, 'col-3');


-- TABLEAU 15 : COLLECTIVITÉ 1
INSERT INTO member_payment (id, amount, payment_mode, creation_date, member_id, financial_account_id) VALUES
('P-C1-1', 200000, 'CASH', '2026-01-01', 'C1-M1', 'C1-A-CASH'),
('P-C1-2', 200000, 'CASH', '2026-01-01', 'C1-M2', 'C1-A-CASH'),
('P-C1-3', 200000, 'MOBILE_MONEY', '2026-01-01', 'C1-M3', 'C1-A-MOBILE-1'),
('P-C1-4', 200000, 'MOBILE_MONEY', '2026-01-01', 'C1-M4', 'C1-A-MOBILE-1'),
('P-C1-5', 150000, 'MOBILE_MONEY', '2026-01-01', 'C1-M5', 'C1-A-MOBILE-1'),
('P-C1-6', 100000, 'CASH', '2026-05-01', 'C1-M6', 'C1-A-CASH'),
('P-C1-7', 60000, 'CASH', '2026-05-01', 'C1-M7', 'C1-A-CASH'),
('P-C1-8', 90000, 'CASH', '2026-05-01', 'C1-M8', 'C1-A-CASH');

-- TABLEAU 16 : COLLECTIVITÉ 2
INSERT INTO member_payment (id, amount, payment_mode, creation_date, member_id, financial_account_id) VALUES
('P-C2-1', 120000, 'CASH', '2026-01-01', 'C1-M1', 'C2-A-CASH'),
('P-C2-2', 180000, 'CASH', '2026-01-01', 'C1-M2', 'C2-A-CASH'),
('P-C2-3', 200000, 'CASH', '2026-01-01', 'C1-M3', 'C2-A-CASH'),
('P-C2-4', 200000, 'CASH', '2026-01-01', 'C1-M4', 'C2-A-CASH'),
('P-C2-5', 200000, 'CASH', '2026-01-01', 'C1-M5', 'C2-A-CASH'),
('P-C2-6', 200000, 'CASH', '2026-01-01', 'C1-M6', 'C2-A-CASH'),
('P-C2-7', 80000, 'MOBILE_MONEY', '2026-01-01', 'C1-M7', 'C2-A-MOBILE-1'),
('P-C2-8', 120000, 'MOBILE_MONEY', '2026-01-01', 'C1-M8', 'C2-A-MOBILE-1');

-- TABLEAU 17 : COLLECTIVITÉ 3
INSERT INTO member_payment (id, amount, payment_mode, creation_date, member_id, financial_account_id) VALUES
('P-C3-1', 25000, 'BANK_TRANSFER', '2026-04-01', 'C3-M1', 'C3-A-BANK-1'),
('P-C3-2', 25000, 'BANK_TRANSFER', '2026-04-01', 'C3-M2', 'C3-A-BANK-1'),
('P-C3-3', 25000, 'BANK_TRANSFER', '2026-04-01', 'C3-M3', 'C3-A-BANK-1'),
('P-C3-4', 25000, 'BANK_TRANSFER', '2026-04-01', 'C3-M4', 'C3-A-BANK-1'),
('P-C3-5', 25000, 'BANK_TRANSFER', '2026-04-01', 'C3-M5', 'C3-A-BANK-2'),
('P-C3-6', 25000, 'BANK_TRANSFER', '2026-04-01', 'C3-M6', 'C3-A-BANK-2'),
('P-C3-7', 25000, 'CASH', '2026-04-01', 'C3-M7', 'C3-A-CASH'),
('P-C3-8', 25000, 'CASH', '2026-04-01', 'C3-M8', 'C3-A-CASH'),
('P-C3-9', 25000, 'BANK_TRANSFER', '2026-05-01', 'C3-M1', 'C3-A-BANK-1'),
('P-C3-10', 25000, 'BANK_TRANSFER', '2026-05-01', 'C3-M2', 'C3-A-BANK-1'),
('P-C3-11', 15000, 'BANK_TRANSFER', '2026-05-01', 'C3-M3', 'C3-A-MOBILE-1'),
('P-C3-12', 15000, 'BANK_TRANSFER', '2026-05-01', 'C3-M4', 'C3-A-MOBILE-1'),
('P-C3-13', 20000, 'BANK_TRANSFER', '2026-05-01', 'C3-M5', 'C3-A-BANK-2'),
('P-C3-14', 25000, 'BANK_TRANSFER', '2026-05-01', 'C3-M6', 'C3-A-BANK-2'),
('P-C3-15', 5000, 'CASH', '2026-05-01', 'C3-M7', 'C3-A-CASH'),
('P-C3-16', 5000, 'CASH', '2026-05-01', 'C3-M8', 'C3-A-CASH');

 
INSERT INTO collectivity_transaction (id, amount, payment_mode, creation_date, member_debited_id, account_credited_id)
SELECT REPLACE(id, 'P-', 'T-'), amount, payment_mode, creation_date, member_id, financial_account_id FROM member_payment;


-- TABLEAU 18 : COLLECTIVITÉ 1
INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, collectivity_id, creation_date) VALUES
('C1-MX1', 'Jean', 'Rabe', '1990-05-12', 'M', 'Lot 1 Ambato', 'Etudiant', '341100001', 'j.rabe@mail.mg', 'CONFIRME', 'col-1', '2026-04-01'),
('C1-MX2', 'Lala', 'Rasoa', '1995-03-22', 'F', 'Lot 2 Ambato', 'Sans', '321100002', 'l.rasoa@mail.mg', 'CONFIRME', 'col-1', '2026-04-01'),
('C1-MX3', 'Paul', 'Rakoto', '2000-01-10', 'M', 'Lot 3 Ambato', 'Sans', '331100003', 'p.rakoto@mail.mg', 'CONFIRME', 'col-1', '2026-05-01'),
('C1-MX4', 'Toky', 'Ranaivo', '1988-11-05', 'M', 'Lot 4 Ambato', 'Etudiant', '342200004', 't.ranaivo@mail.mg', 'CONFIRME', 'col-1', '2026-06-01');


INSERT INTO member_referees (member_id, referee_id) VALUES 
('C1-MX1', 'C1-M1'), ('C1-MX1', 'C1-M2'), ('C1-MX2', 'C1-M1'), ('C1-MX2', 'C1-M2'),
('C1-MX3', 'C1-M1'), ('C1-MX3', 'C1-M2'), ('C1-MX4', 'C1-M1'), ('C1-MX4', 'C1-M2');

-- TABLEAU 19 : COLLECTIVITÉ 2
INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, collectivity_id, creation_date) VALUES
('C2-MX1', 'Marie', 'Soa', '1982-08-14', 'F', 'Lot 5 Dobo', 'Apprenti', '322200001', 'm.soa@mail.mg', 'CONFIRME', 'col-2', '2026-03-01'),
('C2-MX2', 'Pierre', 'Solo', '1999-07-30', 'M', 'Lot 6 Dobo', 'Apprenti', '332200002', 'p.solo@mail.mg', 'CONFIRME', 'col-2', '2026-03-01'),
('C2-MX3', 'Luc', 'Mamy', '2001-12-12', 'M', 'Lot 7 Dobo', 'Apprenti', '343300003', 'l.mamy@mail.mg', 'CONFIRME', 'col-2', '2026-03-01');


INSERT INTO member_referees (member_id, referee_id) VALUES 
('C2-MX1', 'C1-M1'), ('C2-MX1', 'C1-M2'), ('C2-MX2', 'C1-M1'), ('C2-MX2', 'C1-M2'), ('C2-MX3', 'C1-M1'), ('C2-MX3', 'C1-M2');

-- TABLEAU 20 : COLLECTIVITÉ 3
INSERT INTO member (id, first_name, last_name, birth_date, gender, address, profession, phone_number, email, occupation, collectivity_id, creation_date) VALUES
('C3-MX1', 'Hery', 'Jean', '1980-05-05', 'M', 'Lot 8 Brick', 'Aide', '323300001', 'h.jean@mail.mg', 'CONFIRME', 'col-3', '2026-01-01'),
('C3-MX2', 'Anna', 'Niry', '1992-04-04', 'F', 'Lot 9 Brick', 'Aide', '333300002', 'a.niry@mail.mg', 'CONFIRME', 'col-3', '2026-02-01'),
('C3-MX3', 'Marc', 'Feno', '1998-02-02', 'M', 'Lot 10 Brick', 'Aide', '344400003', 'm.feno@mail.mg', 'CONFIRME', 'col-3', '2026-02-01'),
('C3-MX4', 'Bob', 'Kely', '2005-09-09', 'M', 'Lot 11 Brick', 'Aide', '324400004', 'b.kely@mail.mg', 'CONFIRME', 'col-3', '2026-03-01'),
('C3-MX5', 'Lili', 'Vavy', '1994-06-06', 'F', 'Lot 12 Brick', 'Aide', '334400005', 'l.vavy@mail.mg', 'CONFIRME', 'col-3', '2026-03-01'),
('C3-MX6', 'Eric', 'Liva', '1985-10-10', 'M', 'Lot 13 Brick', 'Aide', '345500006', 'e.liva@mail.mg', 'CONFIRME', 'col-3', '2026-03-01');


INSERT INTO member_referees (member_id, referee_id) VALUES 
('C3-MX1', 'C3-M1'), ('C3-MX1', 'C3-M2'), ('C3-MX2', 'C3-M1'), ('C3-MX2', 'C3-M2'), ('C3-MX3', 'C3-M1'), ('C3-MX3', 'C3-M2'),
('C3-MX4', 'C3-M1'), ('C3-MX4', 'C3-M2'), ('C3-MX5', 'C3-M1'), ('C3-MX5', 'C3-M2'), ('C3-MX6', 'C3-M1'), ('C3-MX6', 'C3-M2');


INSERT INTO activity (id, label, collectivity_id, date) VALUES
-- Collectivité 1
('act-1-mar', 'AG1', 'col-1', '2026-03-07'),
('act-1-avr', 'AG1', 'col-1', '2026-04-04'),
('act-2', 'Formation de base', 'col-1', '2026-03-08'), 

-- Collectivité 2
('act-3-mar', 'AG2', 'col-2', '2026-03-08'),
('act-3-avr', 'AG2', 'col-2', '2026-04-05'),
('act-4', 'Formation de base', 'col-2', '2026-03-15'),
('act-5', 'Perfectionnement', 'col-2', '2026-04-30'),

-- Collectivité 3
('act-6-mar', 'AG3', 'col-3', '2026-03-06'),
('act-6-avr', 'AG3', 'col-3', '2026-04-03'),
('act-7', 'Formation de base', 'col-3', '2026-03-25');


-- Tableau 24:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c1-mar-1', 'act-1-mar', 'C1-M1', 'PRESENT'),
('att-c1-mar-2', 'act-1-mar', 'C1-M2', 'PRESENT'),
('att-c1-mar-3', 'act-1-mar', 'C1-M3', 'PRESENT'),
('att-c1-mar-4', 'act-1-mar', 'C1-M4', 'PRESENT'),
('att-c1-mar-5', 'act-1-mar', 'C1-M5', 'PRESENT'),
('att-c1-mar-6', 'act-1-mar', 'C1-M6', 'PRESENT'),
('att-c1-mar-7', 'act-1-mar', 'C1-M7', 'ABSENT'),
('att-c1-mar-8', 'act-1-mar', 'C1-M8', 'ABSENT');

-- Tableau 25:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c1-avr-1', 'act-1-avr', 'C1-M1', 'PRESENT'),
('att-c1-avr-2', 'act-1-avr', 'C1-M2', 'PRESENT'),
('att-c1-avr-3', 'act-1-avr', 'C1-M3', 'ABSENT'),
('att-c1-avr-4', 'act-1-avr', 'C1-M4', 'ABSENT'),
('att-c1-avr-5', 'act-1-avr', 'C1-M5', 'PRESENT'),
('att-c1-avr-6', 'act-1-avr', 'C1-M6', 'PRESENT'),
('att-c1-avr-7', 'act-1-avr', 'C1-M7', 'PRESENT'),
('att-c1-avr-8', 'act-1-avr', 'C1-M8', 'PRESENT');



-- Tableau 26:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c2-mar-1', 'act-3-mar', 'C2-M1', 'PRESENT'), 
('att-c2-mar-2', 'act-3-mar', 'C2-M2', 'PRESENT'),
('att-c2-mar-3', 'act-3-mar', 'C2-M3', 'ABSENT'),
('att-c2-mar-4', 'act-3-mar', 'C2-M4', 'ABSENT'),
('att-c2-mar-5', 'act-3-mar', 'C2-M5', 'PRESENT'),
('att-c2-mar-6', 'act-3-mar', 'C2-M6', 'PRESENT'),
('att-c2-mar-7', 'act-3-mar', 'C2-M7', 'PRESENT'),
('att-c2-mar-8', 'act-3-mar', 'C2-M8', 'PRESENT');

-- Tableau 27:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c2-avr-1', 'act-3-avr', 'C2-M1', 'PRESENT'),
('att-c2-avr-2', 'act-3-avr', 'C2-M2', 'PRESENT'),
('att-c2-avr-3', 'act-3-avr', 'C2-M3', 'ABSENT'),
('att-c2-avr-4', 'act-3-avr', 'C2-M4', 'PRESENT'),
('att-c2-avr-5', 'act-3-avr', 'C2-M5', 'PRESENT'),
('att-c2-avr-6', 'act-3-avr', 'C2-M6', 'PRESENT'),
('att-c2-avr-7', 'act-3-avr', 'C2-M7', 'PRESENT'),
('att-c2-avr-8', 'act-3-avr', 'C2-M8', 'ABSENT');

-- Tableau 28:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c2-perf-1', 'act-5', 'C2-M1', 'PRESENT'),
('att-c2-perf-2', 'act-5', 'C2-M2', 'PRESENT'),
('att-c2-perf-3', 'act-5', 'C2-M3', 'PRESENT'),
('att-c2-perf-4', 'act-5', 'C2-M4', 'ABSENT');




-- Tableau 29:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c3-mar-1', 'act-6-mar', 'C3-M1', 'PRESENT'),
('att-c3-mar-2', 'act-6-mar', 'C3-M2', 'PRESENT'),
('att-c3-mar-3', 'act-6-mar', 'C3-M3', 'PRESENT'),
('att-c3-mar-4', 'act-6-mar', 'C3-M4', 'PRESENT'),
('att-c3-mar-5', 'act-6-mar', 'C3-M5', 'PRESENT'),
('att-c3-mar-6', 'act-6-mar', 'C3-M6', 'PRESENT'),
('att-c3-mar-7', 'act-6-mar', 'C3-M7', 'ABSENT'),
('att-c3-mar-8', 'act-6-mar', 'C3-M8', 'ABSENT');

-- Tableau 30:
INSERT INTO attendance (id, activity_id, member_id, status) VALUES
('att-c3-avr-1', 'act-6-avr', 'C3-M1', 'PRESENT'),
('att-c3-avr-2', 'act-6-avr', 'C3-M2', 'PRESENT'),
('att-c3-avr-3', 'act-6-avr', 'C3-M3', 'ABSENT'),
('att-c3-avr-4', 'act-6-avr', 'C3-M4', 'ABSENT'),
('att-c3-avr-5', 'act-6-avr', 'C3-M5', 'PRESENT'),
('att-c3-avr-6', 'act-6-avr', 'C3-M6', 'PRESENT'),
('att-c3-avr-7', 'act-6-avr', 'C3-M7', 'ABSENT'),
('att-c3-avr-8', 'act-6-avr', 'C3-M8', 'PRESENT'),
('att-c3-avr-extra', 'act-6-avr', 'C1-M1', 'PRESENT');