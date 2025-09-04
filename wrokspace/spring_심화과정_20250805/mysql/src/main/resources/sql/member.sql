create table tbl_member(
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) not null unique,
    member_password varchar(255) not null,
    member_name varchar(255),
    member_status enum('active', 'inactive') default 'active',
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp
);

# 실행: Ctrl + Enter
select * from tbl_member;

delete from tbl_member
where id = 1;