create table album_cmt_board1 (
seq INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
subject VARCHAR(150) NOT NULL,
writer VARCHAR(12) NOT NULL,
mail VARCHAR(50),
password VARCHAR(41) NOT NULL,
content VARCHAR(2000),
imagename VARCHAR(200) NOT NULL,
imagesize INT NOT NULL,
latitude VARCHAR(12),
longitude VARCHAR(12),
cmtcnt INT NOT NULL,
hit INT NOT NULL,
wip VARCHAR(15) NOT NULL,
wdate DATETIME NOT NULL
);
	
create table album_cmt_comment1 (
seq INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
pseq INT NOT NULL,
writer VARCHAR(12) NOT NULL,
password VARCHAR(41) NOT NULL,
content VARCHAR(2000) NOT NULL,
wdate DATETIME NOT NULL
);



insert into album_cmt_board1 values (0, '제목', '이름', 'test@test.com', password('1234'), '내용', '607927_1_thumb1.jpg', 21156, '37.497461', '127.028576', 1, 0, '000.000.000.000', now());

insert into album_cmt_comment1 values (0, 1, '이름', password('1234'), '내용', now());