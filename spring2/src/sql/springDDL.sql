-- 데이터베이스 생성
create database spdb  default character set utf8;

-- USER생성 및 권한 부여
-- 호스트가 localhost인 경우 localhost에서 해당 계정으로 접근
create user 'spuser'@'localhost'  identified by 'sppw';
grant all  privileges on spdb.*  to 'spuser'@'localhost';

-- 호스트가 %인 경우 모든 호스트에서 해당 계정으로 접근
/* MySQL에서는 localhost와 다른 호스트를 구분하므로 
 사용자 계정을 생성할 때는 localhost용 계정과 
 외부에서 접근할 때 사용할 계정을   각 각 생성해야 한다*/
create user 'spuser'@'%' identified by 'sppw';
grant all  privileges on spdb.*  to 'spuser'@'%';

create table spdb.simplemember(
	id varchar(40) Not Null primary key,
    passwd varchar(20) Not Null,
    gender  varchar(10) Not Null,
    name  varchar(50) Not Null,
    regdate varchar(50) not null
)engine=InnoDB default character set=utf8;

insert into spdb.simplemember(id,passwd,gender,name,regdate)
value ('adminid','1234','남성','관리자','2020/01/01');

select id,passwd,gender,name,regdate
from spdb.simplemember;

--- 특정 id와 일치하는 회원조회 ---
select no,id,passwd,gender,name,regdate
from spdb.simplemember
where id='adminid';

----- 비밀번호 수정 -----------
update spdb.simplemember
set passwd='1234'
where id='1234';

---- 삭제 ------------------