CREATE SCHEMA board_project COLLATE utf8mb4_general_ci;

USE board_project;

----------------------------------------------------------

create table board_project.member_ut (
    usn BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 유저 고유 번호'
    ,user_id VARCHAR(50) NOT NULL COMMENT '회원유저가 로그인시 사용할 ID'
    ,user_pw VARCHAR(100) NOT NULL COMMENT '회원 유저가 로그인시 사용할 PW'
    ,nick_name VARCHAR(50) NOT NULL COMMENT '회원 유저가 게시판에서 사용할 닉네임'
    ,is_delete TINYINT NOT NULL DEFAULT -1 COMMENT '회원 탈퇴 신청 상태(-1: 미신청, 0: 신청, 1:삭제)'
    ,permission TINYINT NOT NULL DEFAULT 0 COMMENT '유저의 권한 (-1: 관리자, 0: 일반유저, 1: 블랙리스트)'
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '회원가입일자'
    ,updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '회원정보 수정일자')
ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '회원정보';
CREATE  INDEX idx_member_ut_user_id_n1 ON board_project.member_ut(user_id);
CREATE  INDEX idx_member_ut_nicklname_n1 ON board_project.member_ut(nick_name);
ALTER TABLE board_project.member_ut ADD PRIMARY KEY (user_ut_usn);


create table board_project.associate_ut (
    associate_ut_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 신청 고유 번호'
    ,usn BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '회원 USN 정보 (신규 회원의 경우 USN이 없으므로 0입력)'
    ,user_id VARCHAR(50) NOT NULL COMMENT '유저가 로그인시 사용할 ID'
    ,user_pw VARCHAR(100) NOT NULL COMMENT '유저가 로그인시 사용할 PW'
    ,type TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '유저 정보 타입 (0: 일반 회원가입, 1: 정회원 전환, 2: 회원탈퇴 신청)'
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '테이블 생성 일자'
    ,updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '테이블 업데이트 일자')
    ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '회원정보에 대한 서브 테이블';
CREATE  INDEX idx_member_sub_ut_user_id_n1 ON board_project.associate_ut(user_id);
CREATE  INDEX idx_member_sub_ut_usn_n1 ON board_project.associate_ut(usn);
CREATE  INDEX idx_member_sub_ut_type_n1 ON board_project.associate_ut(type);
ALTER TABLE board_project.associate_ut ADD PRIMARY KEY (member_sub_ut_id);


create table board_project.member_ht (
    member_ht_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 유저 변경이력 고유 번호'
    ,usn BIGINT UNSIGNED NOT NULL COMMENT '회원 유저 고유 번호'
    ,before_data JSON NOT NULL COMMENT 'member 변경 전 데이터'
    ,after_data JSON NOT NULL COMMENT 'member 변경 후 데이터'
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '변경 이력 생성일자'
)
ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '회원정보 변경이력';
CREATE  INDEX idx_member_ht_usn_n1 ON board_project.member_ht(usn);
ALTER TABLE board_project.member_ht ADD PRIMARY KEY (member_ht_id);


create table board_project.board_ut (
    board_ut_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 유저 고유 번호'
    ,usn BIGINT UNSIGNED NOT NULL COMMENT '게시판 작성 글 제목'
    ,title VARCHAR(200) NOT NULL COMMENT '게시글 작성 내용'
    ,post TEXT NOT NULL COMMENT '게시판 작성일자'
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '게시판 수정일자'
    ,updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '회원정보';
CREATE  INDEX idx_board_ut_usn_n1 ON board_project.board_ut(usn);
ALTER TABLE board_project.board_ut ADD PRIMARY KEY (board_ut_id);


create table board_project.board_ht (
                                        board_ht_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 유저 고유 번호'
    ,board_ut_id BIGINT UNSIGNED NOT NULL COMMENT '게시판 수정 전 작성 글 제목'
    ,usn BIGINT UNSIGNED NOT NULL COMMENT '게시글 수정 전 작성 내용'
    ,before_title VARCHAR(100) NOT NULL COMMENT '게시판 작성일자'
    ,before_post TEXT NOT NULL
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)
ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '회원정보';
CREATE  INDEX idx_board_ht_usn_n1 ON board_project.board_ht(usn);
CREATE  INDEX idx_board_ht_board_ut_id_n1 ON board_project.board_ht(board_ut_id);
ALTER TABLE board_project.board_ht ADD PRIMARY KEY (board_ht_id);


create table board_project.board_delete_ht (
    board_delete_ht_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '회원 유저 고유 번호'
    ,board_ut_id BIGINT UNSIGNED NOT NULL COMMENT '게시판 작성 글 제목'
    ,usn BIGINT UNSIGNED NOT NULL COMMENT '게시글 작성 내용'
    ,title VARCHAR(200) NOT NULL COMMENT '게시판에 달렸던 댓글들을 Json으로 저장'
    ,post TEXT NOT NULL COMMENT '게시판 작성일자'
    ,comment JSON NOT NULL
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)
ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '회원정보';
CREATE  INDEX idx_board_delete_ht_usn_n1 ON board_project.board_delete_ht(usn);
CREATE  INDEX idx_board_delete_ht_boardmtid_n1 ON board_project.board_delete_ht(board_mt_id);
ALTER TABLE board_project.board_delete_ht ADD PRIMARY KEY (board_delete_ht_id);



create table board_project.comment_ut (
    comment_ut_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 고유 번호'
    ,usn BIGINT UNSIGNED NOT NULL COMMENT '상위 댓글 ID (0: 일반 댓글, 0이 아닐경우 : 대댓글)'
    ,board_ut_id BIGINT UNSIGNED NOT NULL COMMENT '댓글 내용'
    ,parent_id BIGINT UNSIGNED NOT NULL COMMENT '댓글 작성일자'
    ,comment VARCHAR(255) NOT NULL COMMENT '댓글 수정일자'
    ,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    ,updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
CREATE  INDEX idx_comment_ut_board_id_n1 ON board_project.comment_ut(board_id);
CREATE  INDEX idx_comment_ut_parent_id_n1 ON board_project.comment_ut(parent_id);
CREATE  INDEX idx_comment_ut_usn_n1 ON board_project.comment_ut(usn);
ALTER TABLE board_project.comment_ut ADD PRIMARY KEY (comment_ut_id);


