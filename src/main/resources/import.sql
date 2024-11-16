CREATE SCHEMA SCHEMA1;

-- SCHEMA1.PARENT definição

-- Drop table

-- DROP TABLE SCHEMA1.PARENT;

CREATE TABLE SCHEMA1.PARENT (
	CMN_ID_1 VARCHAR(255) NOT NULL,
	CMN_ID_2 VARCHAR(255) NOT NULL,
	CMN_ID_3 VARCHAR(255) NOT NULL,
	PAR_COL_1 VARCHAR(255),
	PAR_COL_2 VARCHAR(255),
	PAR_UDT TIMESTAMP,
	CONSTRAINT PARENT_PK PRIMARY KEY (CMN_ID_1,CMN_ID_2,CMN_ID_3)
);

-- SCHEMA1.CHILD definição

-- Drop table

-- DROP TABLE SCHEMA1.CHILD;

CREATE TABLE SCHEMA1.CHILD (
	CMN_ID_1 VARCHAR(255) NOT NULL,
	CMN_ID_2 VARCHAR(255) NOT NULL,
	CMN_ID_3 VARCHAR(255) NOT NULL,
	CHD_ID_4 INTEGER NOT NULL,
	CHD_COL_1 VARCHAR(255),
	CHD_UDT TIMESTAMP,
	CONSTRAINT CHILD_PK PRIMARY KEY (CMN_ID_1,CMN_ID_2,CMN_ID_3,CHD_ID_4)
);

INSERT INTO SCHEMA1.PARENT
(CMN_ID_1, CMN_ID_2, CMN_ID_3, PAR_COL_1, PAR_COL_2, PAR_UDT)
VALUES('common-id-1', 'common-id-2', 'common-id-3', 'parent-field-1', 'parent-field-2', '2024-11-15 23:56:35.975');

INSERT INTO SCHEMA1.CHILD
(CMN_ID_1, CMN_ID_2, CMN_ID_3, CHD_ID_4, CHD_COL_1, CHD_UDT)
VALUES('common-id-1', 'common-id-2', 'common-id-3', 0, 'child-0-field-1', '2024-11-15 23:56:35.975');

INSERT INTO SCHEMA1.CHILD
(CMN_ID_1, CMN_ID_2, CMN_ID_3, CHD_ID_4, CHD_COL_1, CHD_UDT)
VALUES('common-id-1', 'common-id-2', 'common-id-3', 1, 'child-1-field-1', '2024-11-15 23:56:35.975');

INSERT INTO SCHEMA1.CHILD
(CMN_ID_1, CMN_ID_2, CMN_ID_3, CHD_ID_4, CHD_COL_1, CHD_UDT)
VALUES('common-id-1', 'common-id-2', 'common-id-3', 2, 'child-2-field-1', '2024-11-15 23:56:35.975');


