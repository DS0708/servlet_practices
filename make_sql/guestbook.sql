use webdb;

show tables;

select * from guestbook;

insert into guestbook values (null,'신동성',password('1234'),'hi~~~~~\nhi!!',now());

select * from guestbook where password = password('ss');

desc guestbook;

alter table guestbook
modify post_date DATETIME;

select no, name, text, post_date from guestbook order by no asc;

delete from guestbook where no=5 and password = password('ds2');

delete from guestbook ;

SET @count=0;
UPDATE guestbook SET no=@count:=@count+1;
Alter table guestbook AUTO_INCREMENT = 0;

