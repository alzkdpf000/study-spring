create table tbl_test(
    id bigint unsigned auto_increment primary key,
    name varchar(255),
    category varchar(255),
    bloodType varchar(255),
    gender varchar(255)
);

insert into tbl_test(name, category, bloodType, gender)
values ('고길동', '인간', 'AB', '남');

select * from tbl_test;