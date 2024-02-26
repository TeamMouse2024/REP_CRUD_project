DROP TABLE IF EXISTS `REPORT`;
CREATE TABLE IF NOT EXISTS REPORT
(
  REP_NO  INT AUTO_INCREMENT PRIMARY KEY COMMENT '신고번호',
  REP_TITLE VARCHAR(120) NOT NULL COMMENT '신고제목',
  REP_CONTENT VARCHAR(6000) NOT NULL COMMENT '신고내용',
  REP_DATE VARCHAR(8) NOT NULL COMMENT '신고일',
  REP_ID VARCHAR(15) NOT NULL COMMENT '신고아이디',
  REP_PRC VARCHAR(4) NOT NULL COMMENT '신고처리여부'

) ENGINE=INNODB COMMENT '신고';

INSERT INTO REPORT(REP_TITLE, REP_CONTENT, REP_DATE, REP_ID, REP_PRC) 
VALUES 
('신고제목1', '신고내용입니다.1', '20240103', 'user01', '승인'),
('신고제목2', '신고내용입니다.2', '20240115', 'user02', '반려'),
('신고제목3', '신고내용입니다.3', '20240127', 'user03', '반려'),
('신고제목4', '신고내용입니다.4', '20240208', 'user04', '승인'),
('신고제목5', '신고내용입니다.5', '20240216', 'user05', '승인');

select * from report;