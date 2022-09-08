CREATE sequence PETSTORE.HIBERNATE_SEQUENCE start WITH 1 increment BY 1;

INSERT INTO PETSTORE.PSTB003_CATEGORY (C_NOME) VALUES ('GATO');
INSERT INTO PETSTORE.PSTB003_CATEGORY (C_NOME) VALUES ('CAO');
INSERT INTO PETSTORE.PSTB003_CATEGORY (C_NOME) VALUES ('PASSARO');

INSERT INTO PETSTORE.PSTB001_USER (U_NOME,U_EMAIL,U_SENHA,U_STATUS) VALUES ('IVANILSON','ivan@mail.com','123', 0);
INSERT INTO PETSTORE.PSTB001_USER (U_NOME,U_EMAIL,U_SENHA,U_STATUS) VALUES ('ARTHUR','arthur@mail.com','123',1);
INSERT INTO PETSTORE.PSTB001_USER (U_NOME,U_EMAIL,U_SENHA,U_STATUS) VALUES ('IGOR','igor@mail.com','123',1);

INSERT INTO PETSTORE.PSTB004_PET (P_NOME,P_STATUS,C_ID_CATEGORIA) VALUES ('PITBULL FILHOTE',1,2);
INSERT INTO PETSTORE.PSTB004_PET (P_NOME,P_STATUS,C_ID_CATEGORIA) VALUES ('GATO SIAMES',1,1);
INSERT INTO PETSTORE.PSTB004_PET (P_NOME,P_STATUS,C_ID_CATEGORIA) VALUES ('DALMATA FILHOTE',2,2);
INSERT INTO PETSTORE.PSTB004_PET (P_NOME,P_STATUS,C_ID_CATEGORIA) VALUES ('PAPAGAIO',1,3);

INSERT INTO PETSTORE.PSTB002_STORE (S_DATA_SAIDA,S_QUANTIDADE,P_ID_PET) VALUES ('2022-09-01',2,1);