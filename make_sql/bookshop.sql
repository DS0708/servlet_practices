use webdb;

show tables;

desc book;
desc author;

select * from author;
select * from book;

select b.no , b.title,b.rent, a.no, a.name from author a, book b 
where a.no = b.author_no;

select rent
from book
where no = 1;

update book set rent = 'y' where no = 1;

use webdb;

select * from emaillist;
