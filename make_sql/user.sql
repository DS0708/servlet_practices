use webdb;

desc user;

select * from user;

-- login
select no, name
from user
where email = 'sss@naver.com'
	and password = password('1234');
    
    select no, name from user where email = 'jonum123@daum.net' and password = password('1234');
    
-- update
update user set name = '이성민' and gender = 'female' and password = password('123') where no = 1 ;


