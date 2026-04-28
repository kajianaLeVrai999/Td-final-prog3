
INSERT INTO collectivity (id, number, name, location, occupation) VALUES
('col-1', 1, 'Mpanorina', 'Ambatondrazaka', 'RIZICULTURE'),
('col-2', 2, 'Dobo voalohany', 'Ambatondrazaka', 'PISCICULTURE'),
('col-3', 3, 'Tantely mamy', 'Brickaville', 'APICULTURE');



INSERT INTO member (
id, last_name, first_name, birth_date, gender, address,
profession, phone_number, email, occupation, collectivity_id
) VALUES


('C1-M1','Nom membre 1','Prénom membre 1','1980-02-01','M','Lot II V M Ambato.','Riziculteur',341234567,'member.1@fed-agri.mg','PRESIDENT','col-1'),
('C1-M2','Nom membre 2','Prénom membre 2','1982-03-05','M','Lot II F Ambato.','Agriculteur',321234567,'member.2@fed-agri.mg','VICE_PRESIDENT','col-1'),
('C1-M3','Nom membre 3','Prénom membre 3','1992-03-10','M','Lot II J Ambato.','Collecteur',331234567,'member.3@fed-agrimg','SECRETAIRE','col-1'),
('C1-M4','Nom membre 4','Prénom membre 4','1988-05-22','F','Lot A K 50 Ambato.','Distributeur',381234567,'member.4@fed-agri.mg','TRESORIER','col-1'),
('C1-M5','Nom membre 5','Prénom membre 5','1999-08-21','M','Lot UV 80 Ambato.','Riziculteur',373434567,'member.5@fed-agri.mg','CONFIRME','col-1'),
('C1-M6','Nom membre 6','Prénom membre 6','1998-08-22','F','Lot UV 6 Ambato.','Riziculteur',372234567,'member.6@fed-agri.mg','CONFIRME','col-1'),
('C1-M7','Nom membre 7','Prénom membre 7','1998-01-31','M','Lot UV 7 Ambato.','Riziculteur',374234567,'member.7@fed-agri.mg','CONFIRME','col-1'),
('C1-M8','Nom membre 8','Prénom membre 8','1975-08-20','M','Lot UV 8 Ambato.','Riziculteur',370234567,'member.8@fed-agri.mg','CONFIRME','col-1'),


('C2-M1','Nom membre 1','Prénom membre 1','1980-02-01','M','Lot II V M Ambato.','Riziculteur',341234567,'member.1@fed-agri.mg','CONFIRME','col-2'),
('C2-M2','Nom membre 2','Prénom membre 2','1982-03-05','M','Lot II F Ambato.','Agriculteur',321234567,'member.2@fed-agri.mg','CONFIRME','col-2'),
('C2-M3','Nom membre 3','Prénom membre 3','1992-03-10','M','Lot II J Ambato.','Collecteur',331234567,'member.3@fed-agrimg','CONFIRME','col-2'),
('C2-M4','Nom membre 4','Prénom membre 4','1988-05-22','F','Lot A K 50 Ambato.','Distributeur',381234567,'member.4@fed-agri.mg','CONFIRME','col-2'),
('C2-M5','Nom membre 5','Prénom membre 5','1999-08-21','M','Lot UV 80 Ambato.','Riziculteur',373434567,'member.5@fed-agri.mg','PRESIDENT','col-2'),
('C2-M6','Nom membre 6','Prénom membre 6','1998-08-22','F','Lot UV 6 Ambato.','Riziculteur',372234567,'member.6@fed-agri.mg','VICE_PRESIDENT','col-2'),
('C2-M7','Nom membre 7','Prénom membre 7','1998-01-31','M','Lot UV 7 Ambato.','Riziculteur',374234567,'member.7@fed-agri.mg','SECRETAIRE','col-2'),
('C2-M8','Nom membre 8','Prénom membre 8','1975-08-20','M','Lot UV 8 Ambato.','Riziculteur',370234567,'member.8@fed-agri.mg','TRESORIER','col-2'),


('C3-M1','Nom membre 9','Prénom membre 9','1988-01-02','M','Lot 33 J Antsirabe','Apiculteur',34034567,'member.9@fed-agri.mg','PRESIDENT','col-3'),
('C3-M2','Nom membre 10','Prénom membre 10','1982-03-05','M','Lot 2 J Antsirabe','Agriculteur',338634567,'member.10@fed-agri.mg','VICE_PRESIDENT','col-3'),
('C3-M3','Nom membre 11','Prénom membre 11','1992-03-12','M','Lot 8 KM Antsirabe','Collecteur',338234567,'member.11@fed-agrimg','SECRETAIRE','col-3'),
('C3-M4','Nom membre 12','Prénom membre 12','1988-05-10','F','Lot A K 50 Antsirabe','Distributeur',382334567,'member.12@fed-agri.mg','TRESORIER','col-3'),
('C3-M5','Nom membre 13','Prénom membre 13','1999-08-11','M','Lot UV 80 Antsirabe.','Apiculteur',373365567,'member.13@fed-agri.mg','CONFIRME','col-3'),
('C3-M6','Nom membre 14','Prénom membre 14','1998-08-09','F','Lot UV 6 Antsirabe.','Apiculteur',378234567,'member.14@fed-agri.mg','CONFIRME','col-3'),
('C3-M7','Nom membre 15','Prénom membre 15','1998-01-13','M','Lot UV 7 Antsirabe','Apiculteur',374914567,'member.15@fed-agri.mg','CONFIRME','col-3'),
('C3-M8','Nom membre 16','Prénom membre 16','1975-08-02','M','Lot UV 8 Antsirabe','Apiculteur',370634567,'member.16@fed-agri.mg','CONFIRME','col-3');



INSERT INTO financial_account (
id, account_type, amount, holder_name, mobile_number, collectivity_id
) VALUES
('C1-A-CASH','CASH',0,'-','-','col-1'),
('C1-A-MOBILE-1','MOBILE',0,'Mpanorina','0370489612','col-1'),
('C2-A-CASH','CASH',0,'-','-','col-2'),
('C2-A-MOBILE-1','MOBILE',0,'Dobo voalohany','0320489612','col-2'),
('C3-A-CASH','CASH',0,'-','-','col-3');



INSERT INTO collectivity_transaction (
id, amount, payment_mode, creation_date, account_credited_id, member_debited_id
) VALUES


('tx-1-1',100000,'CASH','2026-01-01','C1-A-CASH','C1-M1'),
('tx-1-2',100000,'CASH','2026-01-01','C1-A-CASH','C1-M2'),
('tx-1-3',100000,'CASH','2026-01-01','C1-A-CASH','C1-M3'),
('tx-1-4',100000,'CASH','2026-01-01','C1-A-CASH','C1-M4'),
('tx-1-5',100000,'CASH','2026-01-01','C1-A-CASH','C1-M5'),
('tx-1-6',100000,'CASH','2026-01-01','C1-A-CASH','C1-M6'),
('tx-1-7',60000,'CASH','2026-01-01','C1-A-CASH','C1-M7'),
('tx-1-8',90000,'CASH','2026-01-01','C1-A-CASH','C1-M8'),


('tx-2-1',60000,'CASH','2026-01-01','C2-A-CASH','C2-M1'),
('tx-2-2',90000,'CASH','2026-01-01','C2-A-CASH','C2-M2'),
('tx-2-3',100000,'CASH','2026-01-01','C2-A-CASH','C2-M3'),
('tx-2-4',100000,'CASH','2026-01-01','C2-A-CASH','C2-M4'),
('tx-2-5',100000,'CASH','2026-01-01','C2-A-CASH','C2-M5'),
('tx-2-6',100000,'CASH','2026-01-01','C2-A-CASH','C2-M6'),
('tx-2-7',40000,'MOBILE_MONEY','2026-01-01','C2-A-MOBILE-1','C2-M7'),
('tx-2-8',60000,'MOBILE_MONEY','2026-01-01','C2-A-MOBILE-1','C2-M8');



INSERT INTO membership_fee (
id, label, status, frequency, eligible_from, amount, collectivity_id
) VALUES
('cot-1','Cotisation annuelle','ACTIVE','ANNUALLY','2026-01-01',100000,'col-1'),
('cot-2','Cotisation annuelle','ACTIVE','ANNUALLY','2026-01-01',100000,'col-2'),
('cot-3','Cotisation annuelle','ACTIVE','ANNUALLY','2026-01-01',50000,'col-3');