/* �����߰���ȸ�� */
DROP TABLE REAUSER 
	CASCADE CONSTRAINTS;

/* ����ȸ�� */
DROP TABLE GENERICUSER 
	CASCADE CONSTRAINTS;

/* �����߰���ȸ�� �̹��� */
DROP TABLE REAIMAGE 
	CASCADE CONSTRAINTS;

/* �Ź��̹��� */
DROP TABLE SALEIMAGE 
	CASCADE CONSTRAINTS;

/* �����߰��� �Ź��������� */
DROP TABLE REASCHEDULE 
	CASCADE CONSTRAINTS;

/* �����߰��� �ı� */
DROP TABLE REVIEW 
	CASCADE CONSTRAINTS;

/* �ϸ�ũ */
DROP TABLE BOOKMARK 
	CASCADE CONSTRAINTS;

/* �����߰��� �Ұ� �Խ��� */
DROP TABLE REAINTROBOARD 
	CASCADE CONSTRAINTS;

/* �Ź� */
DROP TABLE SALE 
	CASCADE CONSTRAINTS;

/* �ŷ����� */
DROP TABLE TYPE 
	CASCADE CONSTRAINTS;

/* ������ */
DROP TABLE ADMIN 
	CASCADE CONSTRAINTS;

/* ȸ���ڵ� */
DROP TABLE USERCODE 
	CASCADE CONSTRAINTS;

/* �����߰��� ȸ�� �̹��� */
DROP TABLE OFFICEIMAGE 
	CASCADE CONSTRAINTS;

/* �����߰���ȸ�� */
CREATE TABLE REAUSER (
	REAId VARCHAR2(30) NOT NULL, /* �����߰��� ���̵� */
	REAPwd VARCHAR2(30) NOT NULL, /* �����߰��� ��й�ȣ */
	REAName VARCHAR2(20) NOT NULL, /* �����߰��� �̸� */
	REAPhoneNum VARCHAR2(30) NOT NULL, /* �����߰��� �޴�����ȣ */
	officeName VARCHAR2(30) NOT NULL, /* �繫�� �̸� */
	officeAddr VARCHAR2(100) NOT NULL, /* �繫�� �ּ� */
	officeDetailAddr VARCHAR2(100) NOT NULL, /* �繫�� ���ּ� */
	officeHp VARCHAR2(30) NOT NULL, /* �繫�� ��ȭ��ȣ */
	regNum VARCHAR2(20) NOT NULL, /* ����ڵ�Ϲ�ȣ */
	USERCODE VARCHAR(10) NOT NULL /* ȸ���ڵ� */
);

COMMENT ON TABLE REAUSER IS '�����߰���ȸ��';

COMMENT ON COLUMN REAUSER.REAId IS '�����߰��� ���̵�';

COMMENT ON COLUMN REAUSER.REAPwd IS '�����߰��� ��й�ȣ';

COMMENT ON COLUMN REAUSER.REAName IS '�����߰��� �̸�';

COMMENT ON COLUMN REAUSER.REAPhoneNum IS '�����߰��� �޴�����ȣ';

COMMENT ON COLUMN REAUSER.officeName IS '�繫�� �̸�';

COMMENT ON COLUMN REAUSER.officeAddr IS '�繫�� �ּ�';

COMMENT ON COLUMN REAUSER.officeDetailAddr IS '�繫�� ���ּ�';

COMMENT ON COLUMN REAUSER.officeHp IS '�繫�� ��ȭ��ȣ';

COMMENT ON COLUMN REAUSER.regNum IS '����ڵ�Ϲ�ȣ';

COMMENT ON COLUMN REAUSER.USERCODE IS 'ȸ���ڵ�';

CREATE UNIQUE INDEX PK_REAUSER
	ON REAUSER (
		REAId ASC
	);

ALTER TABLE REAUSER
	ADD
		CONSTRAINT PK_REAUSER
		PRIMARY KEY (
			REAId
		);

/* ����ȸ�� */
CREATE TABLE GENERICUSER (
	userId VARCHAR2(30) NOT NULL, /* ����ȸ�� ���̵� */
	userPwd VARCHAR2(30) NOT NULL, /* ����ȸ�� ��й�ȣ */
	userName VARCHAR2(20) NOT NULL, /* ����ȸ�� �̸� */
	frontResNum VARCHAR2(6) NOT NULL, /* �ֹι�ȣ ���ڸ� */
	backResNum VARCHAR2(7) NOT NULL, /* �ֹι�ȣ ���ڸ� */
	userPhoneNum VARCHAR2(30) NOT NULL, /* ����ȸ�� �޴�����ȣ */
	userAddr VARCHAR2(100) NOT NULL, /* ����ȸ�� �ּ� */
	userDetailAddr VARCHAR2(100) NOT NULL, /* ����ȸ�� ���ּ� */
	USERCODE VARCHAR(10) NOT NULL /* ȸ���ڵ� */
);

COMMENT ON TABLE GENERICUSER IS '����ȸ��';

COMMENT ON COLUMN GENERICUSER.userId IS '����ȸ�� ���̵�';

COMMENT ON COLUMN GENERICUSER.userPwd IS '����ȸ�� ��й�ȣ';

COMMENT ON COLUMN GENERICUSER.userName IS '����ȸ�� �̸�';

COMMENT ON COLUMN GENERICUSER.frontResNum IS '�ֹι�ȣ ���ڸ�';

COMMENT ON COLUMN GENERICUSER.backResNum IS '�ֹι�ȣ ���ڸ�';

COMMENT ON COLUMN GENERICUSER.userPhoneNum IS '����ȸ�� �޴�����ȣ';

COMMENT ON COLUMN GENERICUSER.userAddr IS '����ȸ�� �ּ�';

COMMENT ON COLUMN GENERICUSER.userDetailAddr IS '����ȸ�� ���ּ�';

COMMENT ON COLUMN GENERICUSER.USERCODE IS 'ȸ���ڵ�';

CREATE UNIQUE INDEX PK_GENERICUSER
	ON GENERICUSER (
		userId ASC
	);

ALTER TABLE GENERICUSER
	ADD
		CONSTRAINT PK_GENERICUSER
		PRIMARY KEY (
			userId
		);

/* �����߰���ȸ�� �̹��� */
CREATE TABLE REAIMAGE (
	REAId VARCHAR2(30) NOT NULL, /* �����߰��� ���̵� */
	reaImgOriginName VARCHAR2(20), /* �����߰���ȸ�� ���� ���� ���ϸ� */
	reaImgSaveName VARCHAR2(20) /* �����߰���ȸ�� ���� ���� ���ϸ� */
);

COMMENT ON TABLE REAIMAGE IS '�����߰���ȸ�� �̹���';

COMMENT ON COLUMN REAIMAGE.REAId IS '�����߰��� ���̵�';

COMMENT ON COLUMN REAIMAGE.reaImgOriginName IS '�����߰���ȸ�� ���� ���� ���ϸ�';

COMMENT ON COLUMN REAIMAGE.reaImgSaveName IS '�����߰���ȸ�� ���� ���� ���ϸ�';

CREATE UNIQUE INDEX PK_REAIMAGE
	ON REAIMAGE (
		REAId ASC
	);

ALTER TABLE REAIMAGE
	ADD
		CONSTRAINT PK_REAIMAGE
		PRIMARY KEY (
			REAId
		);

/* �Ź��̹��� */
CREATE TABLE SALEIMAGE (
	saleImgOriginName1 VARCHAR2(300), /* �Ź����� ���� ���ϸ�1 */
	saleImgSaveName1 VARCHAR2(300), /* �Ź����� ���� ���ϸ�1 */
	saleImgOriginName2 VARCHAR2(300), /* �Ź����� ���� ���ϸ�2 */
	saleImgSaveName2 VARCHAR2(300), /* �Ź����� ���� ���ϸ�2 */
	saleImgOriginName3 VARCHAR2(300), /* �Ź����� ���� ���ϸ�3 */
	saleImgSaveName3 VARCHAR2(300), /* �Ź����� ���� ���ϸ�3 */
	aptNum VARCHAR2(20) /* �Ź���ȣ */
);

COMMENT ON TABLE SALEIMAGE IS '�Ź��̹���';

COMMENT ON COLUMN SALEIMAGE.saleImgOriginName1 IS '�Ź����� ���� ���ϸ�1';

COMMENT ON COLUMN SALEIMAGE.saleImgSaveName1 IS '�Ź����� ���� ���ϸ�1';

COMMENT ON COLUMN SALEIMAGE.saleImgOriginName2 IS '�Ź����� ���� ���ϸ�2';

COMMENT ON COLUMN SALEIMAGE.saleImgSaveName2 IS '�Ź����� ���� ���ϸ�2';

COMMENT ON COLUMN SALEIMAGE.saleImgOriginName3 IS '�Ź����� ���� ���ϸ�3';

COMMENT ON COLUMN SALEIMAGE.saleImgSaveName3 IS '�Ź����� ���� ���ϸ�3';

COMMENT ON COLUMN SALEIMAGE.aptNum IS '�Ź���ȣ';

/* �����߰��� �Ź��������� */
CREATE TABLE REASCHEDULE (
	scheNum NUMBER NOT NULL, /* ������ȣ */
	scheDate TIMESTAMP NOT NULL, /* ��¥ */
	CONTENT VARCHAR2(1000), /* ���� */
	REAId VARCHAR2(30) /* �����߰��� ���̵� */
);

COMMENT ON TABLE REASCHEDULE IS '�����߰��� �Ź���������';

COMMENT ON COLUMN REASCHEDULE.scheNum IS '������ȣ';

COMMENT ON COLUMN REASCHEDULE.scheDate IS '��¥';

COMMENT ON COLUMN REASCHEDULE.CONTENT IS '����';

COMMENT ON COLUMN REASCHEDULE.REAId IS '�����߰��� ���̵�';

CREATE UNIQUE INDEX PK_REASCHEDULE
	ON REASCHEDULE (
		scheNum ASC,
		scheDate ASC
	);

ALTER TABLE REASCHEDULE
	ADD
		CONSTRAINT PK_REASCHEDULE
		PRIMARY KEY (
			scheNum,
			scheDate
		);

/* �����߰��� �ı� */
CREATE TABLE REVIEW (
	reviewNum NUMBER NOT NULL, /* �Խñ۹�ȣ */
	userId VARCHAR2(30) NOT NULL, /* ����ȸ�� ���̵� */
	REAId VARCHAR2(30) NOT NULL, /* �����߰��� ���̵� */
	reviewContent VARCHAR2(3000), /* ���� */
	reviewDate DATE /* ��¥ */
);

COMMENT ON TABLE REVIEW IS '�����߰��� �ı�';

COMMENT ON COLUMN REVIEW.reviewNum IS '�Խñ۹�ȣ';

COMMENT ON COLUMN REVIEW.userId IS '����ȸ�� ���̵�';

COMMENT ON COLUMN REVIEW.REAId IS '�����߰��� ���̵�';

COMMENT ON COLUMN REVIEW.reviewContent IS '����';

COMMENT ON COLUMN REVIEW.reviewDate IS '��¥';

CREATE UNIQUE INDEX PK_REVIEW
	ON REVIEW (
		reviewNum ASC,
		userId ASC,
		REAId ASC
	);

ALTER TABLE REVIEW
	ADD
		CONSTRAINT PK_REVIEW
		PRIMARY KEY (
			reviewNum,
			userId,
			REAId
		);

/* �ϸ�ũ */
CREATE TABLE BOOKMARK (
	userId VARCHAR2(30) NOT NULL, /* ����ȸ�� ���̵� */
	aptNum VARCHAR2(20) NOT NULL, /* �Ź���ȣ */
	bookDate DATE /* ��¥ */
);

COMMENT ON TABLE BOOKMARK IS '�ϸ�ũ';

COMMENT ON COLUMN BOOKMARK.userId IS '����ȸ�� ���̵�';

COMMENT ON COLUMN BOOKMARK.aptNum IS '�Ź���ȣ';

COMMENT ON COLUMN BOOKMARK.bookDate IS '��¥';

CREATE UNIQUE INDEX PK_BOOKMARK
	ON BOOKMARK (
		aptNum ASC
	);

ALTER TABLE BOOKMARK
	ADD
		CONSTRAINT PK_BOOKMARK
		PRIMARY KEY (
			aptNum
		);

/* �����߰��� �Ұ� �Խ��� */
CREATE TABLE REAINTROBOARD (
	REAId VARCHAR2(30) NOT NULL, /* �����߰��� ���̵� */
	subject VARCHAR2(100), /* ���� */
	content VARCHAR2(3000) /* ���� */
);

COMMENT ON TABLE REAINTROBOARD IS '�����߰��� �Ұ� �Խ���';

COMMENT ON COLUMN REAINTROBOARD.REAId IS '�����߰��� ���̵�';

COMMENT ON COLUMN REAINTROBOARD.subject IS '����';

COMMENT ON COLUMN REAINTROBOARD.content IS '����';

CREATE UNIQUE INDEX PK_REAINTROBOARD
	ON REAINTROBOARD (
		REAId ASC
	);

ALTER TABLE REAINTROBOARD
	ADD
		CONSTRAINT PK_REAINTROBOARD
		PRIMARY KEY (
			REAId
		);

/* �Ź� */
CREATE TABLE SALE (
	aptNum VARCHAR2(20) NOT NULL, /* �Ź���ȣ */
	APTSIZE VARCHAR2(10), /* ���� */
	TYPE VARCHAR2(10), /* �ŷ����� */
	ADDR VARCHAR2(200), /* �����ּ� */
	ROADADDR VARCHAR2(200), /* ���θ��ּ� */
	APTNAME VARCHAR2(100), /* ����Ʈ�̸� */
	APTDONG VARCHAR2(10), /* �� */
	APTHO VARCHAR2(10), /* ȣ�� */
	PRICE VARCHAR2(20), /* �ŷ��ݾ� */
	DIRECTION VARCHAR2(20), /* �� */
	ETC VARCHAR2(3000), /* �Ź�Ư¡ */
	isContract VARCHAR2(10), /* ��࿩�� */
	REAId VARCHAR2(30) /* �����߰��� ���̵� */
);

COMMENT ON TABLE SALE IS '�Ź�';

COMMENT ON COLUMN SALE.aptNum IS '�Ź���ȣ';

COMMENT ON COLUMN SALE.APTSIZE IS '����';

COMMENT ON COLUMN SALE.TYPE IS '�ŷ�����';

COMMENT ON COLUMN SALE.ADDR IS '�����ּ�';

COMMENT ON COLUMN SALE.ROADADDR IS '���θ��ּ�';

COMMENT ON COLUMN SALE.APTNAME IS '����Ʈ�̸�';

COMMENT ON COLUMN SALE.APTDONG IS '��';

COMMENT ON COLUMN SALE.APTHO IS 'ȣ��';

COMMENT ON COLUMN SALE.PRICE IS '�ŷ��ݾ�';

COMMENT ON COLUMN SALE.DIRECTION IS '��';

COMMENT ON COLUMN SALE.ETC IS '�Ź�Ư¡';

COMMENT ON COLUMN SALE.isContract IS '��࿩��';

COMMENT ON COLUMN SALE.REAId IS '�����߰��� ���̵�';

CREATE UNIQUE INDEX PK_SALE
	ON SALE (
		aptNum ASC
	);

ALTER TABLE SALE
	ADD
		CONSTRAINT PK_SALE
		PRIMARY KEY (
			aptNum
		);

/* �ŷ����� */
CREATE TABLE TYPE (
	type VARCHAR2(10) NOT NULL /* �ŷ����� */
);

COMMENT ON TABLE TYPE IS '�ŷ�����';

COMMENT ON COLUMN TYPE.type IS '�ŷ�����';

CREATE UNIQUE INDEX PK_TYPE
	ON TYPE (
		type ASC
	);

ALTER TABLE TYPE
	ADD
		CONSTRAINT PK_TYPE
		PRIMARY KEY (
			type
		);

/* ������ */
CREATE TABLE ADMIN (
	adminId VARCHAR2(30) NOT NULL, /* ������ ���̵� */
	adminPwd VARCHAR2(30) NOT NULL, /* ������ ��й�ȣ */
	USERCODE VARCHAR(10) NOT NULL /* ȸ���ڵ� */
);

COMMENT ON TABLE ADMIN IS '������';

COMMENT ON COLUMN ADMIN.adminId IS '������ ���̵�';

COMMENT ON COLUMN ADMIN.adminPwd IS '������ ��й�ȣ';

COMMENT ON COLUMN ADMIN.USERCODE IS 'ȸ���ڵ�';

/* ȸ���ڵ� */
CREATE TABLE USERCODE (
	USERCODE VARCHAR(10) NOT NULL, /* ȸ���ڵ� */
	USERTYPE VARCHAR2(30) NOT NULL /* ȸ������ */
);

COMMENT ON TABLE USERCODE IS 'ȸ���ڵ�';

COMMENT ON COLUMN USERCODE.USERCODE IS 'ȸ���ڵ�';

COMMENT ON COLUMN USERCODE.USERTYPE IS 'ȸ������';

CREATE UNIQUE INDEX PK_USERCODE
	ON USERCODE (
		USERCODE ASC
	);

ALTER TABLE USERCODE
	ADD
		CONSTRAINT PK_USERCODE
		PRIMARY KEY (
			USERCODE
		);

/* �����߰��� ȸ�� �̹��� */
CREATE TABLE OFFICEIMAGE (
	REAId VARCHAR2(30) NOT NULL, /* �����߰��� ���̵� */
	officeImgOriginName VARCHAR2(20), /* ȸ�� �Ұ� ���� ���� ���ϸ� */
	officeImgSaveName VARCHAR2(20) /* ȸ�� �Ұ� ���� ���� ���ϸ� */
);

COMMENT ON TABLE OFFICEIMAGE IS '�����߰��� ȸ�� �̹���';

COMMENT ON COLUMN OFFICEIMAGE.REAId IS '�����߰��� ���̵�';

COMMENT ON COLUMN OFFICEIMAGE.officeImgOriginName IS 'ȸ�� �Ұ� ���� ���� ���ϸ�';

COMMENT ON COLUMN OFFICEIMAGE.officeImgSaveName IS 'ȸ�� �Ұ� ���� ���� ���ϸ�';

CREATE UNIQUE INDEX PK_OFFICEIMAGE
	ON OFFICEIMAGE (
		REAId ASC
	);

ALTER TABLE OFFICEIMAGE
	ADD
		CONSTRAINT PK_OFFICEIMAGE
		PRIMARY KEY (
			REAId
		);

ALTER TABLE REAUSER
	ADD
		CONSTRAINT FK_USERCODE_TO_REAUSER
		FOREIGN KEY (
			USERCODE
		)
		REFERENCES USERCODE (
			USERCODE
		);

ALTER TABLE GENERICUSER
	ADD
		CONSTRAINT FK_USERCODE_TO_GENERICUSER
		FOREIGN KEY (
			USERCODE
		)
		REFERENCES USERCODE (
			USERCODE
		);

ALTER TABLE REAIMAGE
	ADD
		CONSTRAINT FK_REAUSER_TO_REAIMAGE
		FOREIGN KEY (
			REAId
		)
		REFERENCES REAUSER (
			REAId
		);

ALTER TABLE SALEIMAGE
	ADD
		CONSTRAINT FK_SALE_TO_SALEIMAGE
		FOREIGN KEY (
			aptNum
		)
		REFERENCES SALE (
			aptNum
		);

ALTER TABLE REASCHEDULE
	ADD
		CONSTRAINT FK_REAUSER_TO_REASCHEDULE
		FOREIGN KEY (
			REAId
		)
		REFERENCES REAUSER (
			REAId
		);

ALTER TABLE REVIEW
	ADD
		CONSTRAINT FK_GENERICUSER_TO_REVIEW
		FOREIGN KEY (
			userId
		)
		REFERENCES GENERICUSER (
			userId
		);

ALTER TABLE REVIEW
	ADD
		CONSTRAINT FK_REAUSER_TO_REVIEW
		FOREIGN KEY (
			REAId
		)
		REFERENCES REAUSER (
			REAId
		);

ALTER TABLE BOOKMARK
	ADD
		CONSTRAINT FK_SALE_TO_BOOKMARK
		FOREIGN KEY (
			aptNum
		)
		REFERENCES SALE (
			aptNum
		);

ALTER TABLE BOOKMARK
	ADD
		CONSTRAINT FK_GENERICUSER_TO_BOOKMARK
		FOREIGN KEY (
			userId
		)
		REFERENCES GENERICUSER (
			userId
		);

ALTER TABLE REAINTROBOARD
	ADD
		CONSTRAINT FK_REAUSER_TO_REAINTROBOARD
		FOREIGN KEY (
			REAId
		)
		REFERENCES REAUSER (
			REAId
		);

ALTER TABLE SALE
	ADD
		CONSTRAINT FK_TYPE_TO_SALE
		FOREIGN KEY (
			TYPE
		)
		REFERENCES TYPE (
			type
		);

ALTER TABLE SALE
	ADD
		CONSTRAINT FK_REAUSER_TO_SALE
		FOREIGN KEY (
			REAId
		)
		REFERENCES REAUSER (
			REAId
		);

ALTER TABLE ADMIN
	ADD
		CONSTRAINT FK_USERCODE_TO_ADMIN
		FOREIGN KEY (
			USERCODE
		)
		REFERENCES USERCODE (
			USERCODE
		);

ALTER TABLE OFFICEIMAGE
	ADD
		CONSTRAINT FK_REAUSER_TO_OFFICEIMAGE
		FOREIGN KEY (
			REAId
		)
		REFERENCES REAUSER (
			REAId
		);
    
--------------------------------------------------------------------------------

-- USERCODE ����
INSERT INTO USERCODE VALUES (
  'A00', '������'
);
INSERT INTO USERCODE VALUES (
  'U01', '����ȸ��'
);
INSERT INTO USERCODE VALUES (
  'U02', '�����߰���ȸ��'
);
INSERT INTO USERCODE VALUES (
  'B01', '���κ�ȸ��'
);
INSERT INTO USERCODE VALUES (
  'B02', '�����߰����ȸ��'
);

-- ������ ���� ����   'A00', '������'
INSERT INTO ADMIN VALUES (
  'ododo', '1004', 'A00'
);
INSERT INTO ADMIN VALUES (
  'hgoguma', '1004', 'A00'
);
INSERT INTO ADMIN VALUES (
  'jeje', '1004', 'A00'
);
INSERT INTO ADMIN VALUES (
  'keem', '1004', 'A00'
);

COMMIT;
-- ������ ���� �������� COMMIT

-- �ŷ����� ���� '�Ÿ�', '����'
INSERT INTO TYPE VALUES (
  '�Ÿ�'
);
INSERT INTO TYPE VALUES (
  '����'
);

COMMIT;
-- �ŷ����� �Է±��� COMMIT

-- ������ ��ȣ ����
CREATE SEQUENCE SEQ_APTNUM -- �Ź���ȣ ������ ����
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SEQ_REVIEW -- �ı�� ������ ����
  START WITH 1
  INCREMENT BY 1;
CREATE SEQUENCE SEQ_SCHEDULE -- �������� ������ ����
  START WITH 1
  INCREMENT BY 1;
  
COMMIT;
-- ������ ��ȣ �������� COMMIT

-- ����ȸ�� ���� ����  'U01', '����ȸ��'
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser001','1004','ȫ����','961220','2222222','010-3333-3333','����� ���Ǳ� ��ȸ������ 52','301ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser002','1004','������','870325','1234567','010-3181-1611','����� ������ �������63�� 47','602ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser003','1004','������','810225','1036624','010-6353-6662','����� ������ ���ַ�30�� 26','1111ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser004','1004','�迵��','900227','1963336','010-3303-9964','����� ���ı� ������ 187','909ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser005','1004','������','930516','2003692','010-1004-3265','����� ���ʱ� ������� 275','1004ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser006','1004','������','970813','1078771','010-1996-1175','����� ������ ���ȷ�25�� 55','301ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser007','1004','������','830323','2963365','010-6355-8558','����� ���ʱ� �������6�� 148','1006ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser008','1004','�̼���','990504','2033623','010-4525-8877','����� ������ �ѷ�11�� 1','1101ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser009','1004','������','960912','1058585','010-9969-3361','����� ������ �ѷ�11�� 1','1101ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser010','1004','�̿���','710131','2096336','010-1312-9896','����� ���α� ��â�� 3','1��',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser011','1004','����','820925','1063989','010-8558-1234','����� ���ʱ� �������2�� 24','702ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser012','1004','�տ���','820111','2102003','010-9663-1223','����� ���ʱ� �Ź����� 270','1301ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser013','1004','���¸�','900424','2102236','010-9974-3660','����� ���ϱ� ���Ϸ�6���� 23','304ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser014','1004','���ؿ�','860925','1015584','010-7220-2124','���� ������ ����� 404','2009ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser015','1004','�̵���','850722','1033269','010-6636-4422','���� ������ õȣ��� 1077','2104ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser016','1004','������','810118','1022552','010-6633-1119','����� ������ ������� 319','705ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser017','1004','������','940609','2111536','010-9966-3337','����� ������ ����� 100','1010ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser018','1004','������','840824','2113365','010-9669-7774','����� ������ ��õ��� 192','701ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser019','1004','�ں���','900212','2236961','010-1336-9998','����� ������ ������� 272','804ȣ',(select usercode from usercode where usercode='U01'));
insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode) 
  values('guser020','1004','������','801226','1115887','010-8859-0258','����� ������ ���ַ� 420','306ȣ',(select usercode from usercode where usercode='U01'));

COMMIT;
-- ����ȸ�� ���� �������� COMMIT

-- �����߰���ȸ�� ���� ����  'U02', '�����߰���ȸ��'
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser001','1004', '������','010-1544-7777','LG�ε���','����� ������ �����߾�10�� 30','LG���̾���ũ','02-1544-7777','502-11-01931',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser002','1004', '�����','010-1588-3366','�Ｚ�ε���','����� ������ �������77�� 11-9','�ＺŸ��','02-1588-3366','124-81-00998',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser003','1004', '���Ǽ�','010-6000-6000','����ε���','����� ���ʱ� �帪�� 12','1��','080-600-6000','101-81-09147',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser004','1004', '���ؿ�','010-2000-2000','��ƺε���','����� ���ʱ� �帪�� 12','2��','080-200-2000','119-81-02316',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser005','1004', '���¿�','010-6400-0114','SK�ε���','����� ���α� ���� 26','SK����','02-6400-0114','502-11-01931',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser006','1004', '������','010-4220-0114','�����ںε���','���ϵ� ���׽� ���� ���ؾȷ� 6261','������','054-220-0114','540-20-21214',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser007','1004', '��¿�','010-2729-1114','��ȭ�ε���','����� �߱� û��õ�� 86','��ȭ����','02-729-1114','729-11-91114',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser008','1004', '��â��','010-2005-8125','GS�ε���','����� ������ ������ 508','GSŸ��','02-2005-8125','205-20-58125',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser009','1004', '�躴��','010-2080-5114','�����ε���','����� �߱� �����ȷ� 16','����Ÿ��','02-2080-5114','502-11-01931',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser010','1004', '���翵','010-1588-1234','�ż���ε���','����� �߱� �Ұ��� 63','LG���̾���ũ','02-1588-1234','158-81-81234',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser011','1004', '�հ��','010-7268-8114','CJ�ε���','����� �߱� �ҿ���2�� 12','CJ�׷�','02-726-8114','104-81-26714',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser012','1004', '������','010-3398-0114','�λ�ε���','����� �߱� ����ܷ� 275','�λ�Ÿ��','02-3398-0114','339-81-80011',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser013','1004', '������','010-1588-0220','�̷����ºε���','����� �������� ���������� 56','1��','02-1588-0220','305-81-08605',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser014','1004', '�ļ���','010-3772-5151','�������Ϻε���','����� ������ ����� 192','2��','02-3772-5151','236-81-04169',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser015','1004', '�賲��','010-3276-6400','SK�ε���','����� �������� �ǻ���� 88','�ѱ��������Ǻ���','02-3276-6400','123-11-20031',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser016','1004', '�̰���','010-2519-3314','��ǳ�ε���','����� ������ ������� 542','��ǳ����','02-519-3314','791-20-63100',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser017','1004', '�ڿ���','010-1544-1900','�����ε���','����� ���α� ���� 1','��������','02-1544-1900','102-81-11670',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser018','1004', '�����','010-1899-1326','īī���ε���','����Ư����ġ�� ���ֽ� ÷�ܷ� 242','10��','02-1899-1326','123-45-12345',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser019','1004', '������','010-3677-3114','�ڿ��պε���','��⵵ ��õ�� �ڿ��շ� 11','�ڿ���','02-3677-3114','367-73-73114',(select usercode from usercode where usercode='U02'));
insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode) 
  values('reauser020','1004', '�Ѽ���','010-1588-3830','���̹��ε���','��⵵ ������ �д籸 ������ 6','���̹�','02-1588-3830','712-81-71562',(select usercode from usercode where usercode='U02'));

COMMIT;
-- �����߰���ȸ�� ���� �������� COMMIT

insert into sale(aptNum, aptSize, type, addr, roadAddr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId) 
  values(seq_aptNum.nextval, '24',(select type from type where type='�Ÿ�'), '���� ������ ���ﵿ 794-19', '���� ������ �����19�� 17','���ﵿ, ���� �Ѽ־���Ʈ','105��','102ȣ','140000','������','�б�����,���￪ 10��,������','��',(select reaid from reauser where reaid='drop4bit')); 
insert into sale(aptNum, aptSize, type, addr, roadAddr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId) 
  values(seq_aptNum.nextval, '24',(select type from type where type='�Ÿ�'), '���� ������ ���ﵿ 794-24', '���� ������ �����19�� 13','���ﵿ, ������ī��Ƽ����Ʈ','103��','102ȣ','140000','������','�����̱���,������ 5�аŸ�,�����Ϸ�','��',(select reaid from reauser where reaid='drop4bit')); 
insert into sale(aptNum, aptSize, type, addr, roadAddr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId) 
  values(seq_aptNum.nextval, '24',(select type from type where type='�Ÿ�'), '���� ������ ���ﵿ 681-46', '���� ������ ������107�� 24','���ﵿ, ��������Ʈ for U','105��','302ȣ','160000','����','�ξ��� �������� �б�������� �Ｚ������ ��������Ʈ','��',(select reaid from reauser where reaid='drop4bit')); 
insert into sale(aptNum, aptSize, type, addr, roadAddr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId) 
  values(seq_aptNum.nextval, '24',(select type from type where type='�Ÿ�'), '���� ������ ���ﵿ 636-33', '���� ������ ������101�� 6','���ﵿ, �����콺�������Ʈ','103��','102ȣ','140000','������','���ΰ���, 6���� �� Ư �ü���,����,�ξ���,���� ���� ��','��',(select reaid from reauser where reaid='drop4bit')); 
insert into sale(aptNum, aptSize, type, addr, roadAddr, aptName, aptDong, aptHo, price, direction, etc, isContract,reaId) 
  values(seq_aptNum.nextval, '24',(select type from type where type='�Ÿ�'), '���� ������ ���ﵿ 789-29', '���� ������ ������71�� 48','���ﵿ, ���� õ��� ����Ʈ','103��','102ȣ','140000','������','���� �����ϰ� ������ �޸Ÿ�, ������','��',(select reaid from reauser where reaid='drop4bit'));
  
SELECT * FROM ADMIN;
SELECT * FROM BOOKMARK;
SELECT * FROM GENERICUSER;
SELECT * FROM OFFICEIMAGE;
SELECT * FROM REAIMAGE;
SELECT * FROM REAINTROBOARD;
SELECT * FROM REASCHEDULE;
SELECT * FROM REAUSER;
SELECT * FROM REVIEW;
SELECT * FROM SALE;
SELECT * FROM SALEIMAGE;
SELECT * FROM TYPE;
SELECT * FROM USERCODE;