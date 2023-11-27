
CREATE TABLE CONTA (
   ID INT PRIMARY KEY,
   NOME_CLIENTE VARCHAR(50), 
   SALDO FLOAT);
   
-- {"id":100,"nomeCliente":"FLAVIA CAMPOS","saldo":200.0}]
INSERT INTO CONTA (ID,NOME_CLIENTE, SALDO) VALUES (0,'FLAVIA CAMPOS', 200.00);
INSERT INTO CONTA (ID,NOME_CLIENTE, SALDO) VALUES (1, 'TIAGO MONTEIRO', 100.00);
INSERT INTO CONTA (ID, NOME_CLIENTE, SALDO) VALUES (2, 'MARIA OLVEIRA', 300.00);


CREATE TABLE CONTA2 (
   ID INT PRIMARY KEY,
   NOME_CLIENTE VARCHAR(50), 
   SALDO FLOAT,
   VERSION DATE);
   
-- {"id":100,"nomeCliente":"FLAVIA CAMPOS","saldo":200.0}]
INSERT INTO CONTA2 (ID,NOME_CLIENTE, SALDO, VERSION) VALUES (0,'FLAVIA CAMPOS', 200.00,NULL);
INSERT INTO CONTA2 (ID,NOME_CLIENTE, SALDO, VERSION) VALUES (1, 'TIAGO MONTEIRO', 100.00, NULL);
INSERT INTO CONTA2 (ID, NOME_CLIENTE, SALDO, VERSION) VALUES (2, 'MARIA OLVEIRA', 300.00, NULL);