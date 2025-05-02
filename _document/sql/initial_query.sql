CREATE SCHEMA board_project COLLATE utf8mb4_general_ci;

USE
board_project;


# --------------------------------------------------------------------------------------------------------------------

drop table if exists board_project.account_ut;
create table board_project.account_ut
(
    account_ut_id  INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '유저 계정 고유 번호',
    user_id        VARCHAR(50)  NOT NULL COMMENT '유저 계정 가입시 Id',
    password_value VARCHAR(255) NOT NULL COMMENT '계정 생성시 PW_key',
    password_key   VARCHAR(255) NOT NULL COMMENT '계정 생성시 PW_value',
    nick_name      VARCHAR(255) NOT NULL COMMENT '계정 닉네임',
    created_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 생성일',
    updated_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 변경일'
) ENGINE = INNODB
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.account_ut;


CREATE Unique INDEX idx_account_ut_id_n1 ON board_project.account_ut (id);
CREATE INDEX idx_account_ut_nickname_n1 ON board_project.account_ut (nick_name);
CREATE INDEX idx_account_ut_updatedat_n1 ON board_project.account_ut (updated_at);


# --------------------------------------------------------------------------------------------------------------------


drop table if exists board_project.account_lt;
create table board_project.account_lt
(
    account_lt_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '유저 계정 변경 이력 고유 번호',
    account_ut_id INT UNSIGNED NOT NULL COMMENT '유저 계정 고유 번호',
    nick_name     VARCHAR(255) NOT NULL COMMENT '계정 닉네임',
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 생성일'
) ENGINE = INNODB
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.account_lt;


CREATE INDEX idx_account_ut_accountutid_n1 ON board_project.account_lt (account_ut_id);


# --------------------------------------------------------------------------------------------------------------------


drop table if exists board_project.board_ut;
create table board_project.board_ut
(
    board_ut_id   INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 고유 번호',
    owner_user_id INT UNSIGNED NOT NULL COMMENT '게시판 작성자 유저 고유 번호',
    board_name    VARCHAR(255) NOT NULL COMMENT '게시판 제목',
    board_post    TEXT         NOT NULL COMMENT '게시판 게시글 내용',
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '게시글 작성일',
    updated_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '게시글 수정일'
) ENGINE = INNODB
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.board_ut;


CREATE INDEX idx_board_ut_owneruserid_n1 ON board_project.board_ut (owner_user_id);
CREATE INDEX idx_board_ut_boardname_n1 ON board_project.board_ut (board_name);

# --------------------------------------------------------------------------------------------------------------------

drop table if exists board_project.board_lt;
create table board_project.board_lt
(
    board_lt_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '게시판 변경이력 고유 번호',
    board_ut_id INT UNSIGNED NOT NULL COMMENT '게시판 고유 번호',
    before_data JSON      NOT NULL COMMENT '변경전 Full 데이터',
    created_at  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 생성일'
) ENGINE = INNODB
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.board_lt;


CREATE INDEX idx_board_lt_boardltid_n1 ON board_project.board_lt (board_lt_id);


drop table if exists board_project.comment_ut;
create table board_project.comment_ut
(
    comment_ut_id        INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '댓글 고유 번호',
    board_ut_id          INT UNSIGNED NOT NULL COMMENT '게시판 고유 번호',
    parent_comment_ut_id INT UNSIGNED NULL     DEFAULT 0 COMMENT '댓글 부모 고유 번호',
    owner_user_id        INT UNSIGNED NOT NULL COMMENT '댓글 작성자 유저 고유 번호',
    comment              VARCHAR(255) NOT NULL COMMENT '댓글 내용',
    created_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '댓글 작성일',
    updated_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '댓글 수정일'
) ENGINE = INNODB CHARACTER SET utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.comment_ut;


CREATE INDEX idx_comment_ut_id_boardutid_n1 ON board_project.comment_ut (board_ut_id);
CREATE INDEX idx_comment_ut_id_owneruserid_n1 ON board_project.comment_ut (owner_user_id);

# --------------------------------------------------------------------------------------------------------------------


drop table if exists board_project.comment_lt;
create table board_project.comment_lt
(
    comment_lt_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '댓글 변경이력 고유 번호',
    comment_ut_id INT UNSIGNED NOT NULL COMMENT '댓글 고유 번호',
    before_data   VARCHAR(255) NOT NULL COMMENT '변경 전 댓글',
    created_at    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 생성일'
) ENGINE = INNODB
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.comment_lt;


CREATE INDEX idx_comment_lt_commentutid_n1 ON board_project.comment_lt (comment_ut_id);


# --------------------------------------------------------------------------------------------------------------------


drop table if exists board_project.user_active_lt;
create table board_project.user_active_lt
(
    user_active_lt_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '유저 행동 로그 고유 번호',
    account_ut_id     INT UNSIGNED NOT NULL COMMENT '유저 계정 고유 번호',
    access_ip_address VARCHAR(15)  NOT NULL COMMENT '유저 접속 IP 주소',
    active_type       VARCHAR(255) NOT NULL COMMENT '계정 닉네임',
    last_processed_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '계정 생성일'
) ENGINE = INNODB
    CHARACTER SET utf8mb4
    COLLATE = utf8mb4_general_ci COMMENT = '';
show
full
columns from board_project.user_active_lt;


CREATE INDEX idx_account_ut_accountutid_n1 ON board_project.user_active_lt (account_ut_id);
