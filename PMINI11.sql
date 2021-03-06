GRANT CONNECT,RESOURCE,UNLIMITED TABLESPACE TO PMINI11 IDENTIFIED BY TIGER;
CONN PMINI11/TIGER
CREATE TABLE PLAYER(
P_NAME VARCHAR2(20)
CONSTRAINT PLAYER_P_NAME_PK PRIMARY KEY,
GENDER VARCHAR2(6)
CONSTRAINT PLAYER_GENDER_CK CHECK (GENDER IN('남자','여자')),
MONEY NUMBER(7)
CONSTRAINT PLAYER_MONEY_NN NOT NULL,
LEV_NO NUMBER(2),
EXP NUMBER(5)
CONSTRAINT PLAYER_EXP_NN NOT NULL,
S_TIME DATE,
E_TIME NUMBER(15),
MON_LIST VARCHAR2(20),
TO_CNT NUMBER(3)
CONSTRAINT PLAYER_TO_CNT_NN NOT NULL
);
CREATE TABLE LEV(
LEV_NO NUMBER(2)
CONSTRAINT LEV_LEV_NO_PK PRIMARY KEY,
POW NUMBER(4)
CONSTRAINT LEV_POW_NN NOT NULL,
LOW NUMBER(7)
CONSTRAINT LEV_LOW_U UNIQUE,
HIGH NUMBER(7)
CONSTRAINT LEV_HIGH_U UNIQUE
);
CREATE TABLE MONSTER(
MON_NAME VARCHAR2(20)
CONSTRAINT MONSTER_MON_NAME_PK PRIMARY KEY,
T_NAME VARCHAR2(10),
GRADE VARCHAR2(2),
MON_LOB BLOB
);
CREATE TABLE RGRADE(
GRADE VARCHAR2(2)
CONSTRAINT RGRADE_GRADE_PK PRIMARY KEY,
CH_RATE NUMBER(3,3)
CONSTRAINT RGRADE_CH_RATE_NN NOT NULL,
ATT_CNT NUMBER(2)
CONSTRAINT RGRADE_ATT_CNT_NN NOT NULL,
HP NUMBER(5)
CONSTRAINT RGRADE_HP_NN NOT NULL,
EXP NUMBER(5)
CONSTRAINT RGRADE_EXP_NN NOT NULL,
MONEY NUMBER(7)
CONSTRAINT RGRADE_MONEY_NN NOT NULL
);
CREATE TABLE BALL(
B_NAME VARCHAR2(20)
CONSTRAINT BALL_B_NAME_PK PRIMARY KEY,
PRICE NUMBER(7)
CONSTRAINT BALL_PRICE_NN NOT NULL,
T_NAME VARCHAR2(10),
GRADE VARCHAR2(2)
);
CREATE TABLE INVENTORY(
B_NAME VARCHAR2(20),
B_CNT NUMBER(2)
CONSTRAINT INVENTORY_B_CNT_NN NOT NULL,
P_NAME VARCHAR2(20)
);
ALTER TABLE PLAYER
ADD CONSTRAINT PLAYER_LEV_NO_FK
FOREIGN KEY(LEV_NO) REFERENCES LEV(LEV_NO);
ALTER TABLE MONSTER
ADD CONSTRAINT MONSTER_GRADE_FK
FOREIGN KEY(GRADE) REFERENCES RGRADE(GRADE);
ALTER TABLE INVENTORY
ADD CONSTRAINT INVENTORY_B_NAME_FK
FOREIGN KEY(B_NAME) REFERENCES BALL(B_NAME);
ALTER TABLE INVENTORY
ADD CONSTRAINT INVENTORY_P_NAME_FK
FOREIGN KEY(P_NAME) REFERENCES PLAYER(P_NAME);
ALTER TABLE BALL
ADD CONSTRAINT BALL_GRADE_FK
FOREIGN KEY(GRADE) REFERENCES RGRADE(GRADE);


INSERT INTO RGRADE
VALUES('S',0.22,8,2000,1000,10000);
INSERT INTO RGRADE
VALUES('A',0.18,10,1000,500,3000);
INSERT INTO RGRADE
VALUES('B',0.15,13,500,100,1000);
INSERT INTO RGRADE
VALUES('C',0.1,15,150,10,500);

INSERT INTO BALL
VALUES('마스터볼',10000,'노말','S');
INSERT INTO BALL
VALUES('하이퍼볼',1000,'노말','A');
INSERT INTO BALL
VALUES('슈퍼볼',300,'노말','B');
INSERT INTO BALL
VALUES('몬스터볼',50,'노말','C');
INSERT INTO BALL
VALUES('넷트볼',1000,'풀','A');
INSERT INTO BALL
VALUES('다이브볼',1000,'물','A');
INSERT INTO BALL
VALUES('얼스볼',1000,'땅','A');
INSERT INTO BALL
VALUES('파이어볼',1000,'불','A');

INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('파이리','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('식스테일','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('가디','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('포니타','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('피카츄','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('불꽃숭이','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('브케인','불','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('아차모','불','C');

INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('꼬부기','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('고라파덕','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('발챙이','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('왕눈해','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('야돈','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('쏘드라','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('콘치','물','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('별가사리','물','C');

INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('이상해씨','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('캐터피','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('뿔충이','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('뚜벅쵸','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('파라스','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('콘팡','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('아라리','풀','C');
INSERT INTO MONSTER
(MON_NAME,T_NAME,GRADE)
VALUES
('두두','풀','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('구구','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('꼬렛','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('디그다','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('나옹','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('알통몬','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('꼬마돌','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('고오스','땅','C');
INSERT INTO MONSTER
(MON_NAME, T_NAME, GRADE)
VALUES
('이브이','땅','C');

commit;


DELETE BALL;

ALTER TABLE BALL
DROP PRIMARY KEY CASCADE;

ALTER TABLE BALL
ADD(B_KEY NUMBER(3)
CONSTRAINT BALL_B_KEY_PK PRIMARY KEY);

CREATE SEQUENCE SEQ_BALL
START WITH 1;

INSERT INTO BALL
VALUES('몬스터볼',50,'불','C',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('몬스터볼',50,'물','C',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('몬스터볼',50,'풀','C',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('몬스터볼',50,'땅','C',SEQ_BALL.NEXTVAL);

INSERT INTO BALL
VALUES('슈퍼볼',300,'불','B',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('슈퍼볼',300,'물','B',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('슈퍼볼',300,'풀','B',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('슈퍼볼',300,'땅','B',SEQ_BALL.NEXTVAL);

INSERT INTO BALL
VALUES('하이퍼볼',1000,'불','A',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('하이퍼볼',1000,'물','A',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('하이퍼볼',1000,'풀','A',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('하이퍼볼',1000,'땅','A',SEQ_BALL.NEXTVAL);

INSERT INTO BALL
VALUES('마스터볼',10000,'불','S',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('마스터볼',10000,'물','S',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('마스터볼',10000,'풀','S',SEQ_BALL.NEXTVAL);
INSERT INTO BALL
VALUES('마스터볼',10000,'땅','S',SEQ_BALL.NEXTVAL);

ALTER TABLE INVENTORY
ADD(B_KEY NUMBER(3));

ALTER TABLE INVENTORY
ADD CONSTRAINT INVENTORY_B_KEY_FK
FOREIGN KEY(B_KEY) REFERENCES BALL(B_KEY);

COMMIT;


ALTER TABLE INVENTORY
DROP CONSTRAINT INVENTORY_B_CNT_NN;