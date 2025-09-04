create table tbl_member(
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) unique,
    member_password varchar(255),
    member_name varchar(255) not null,
    member_status enum('active', 'inactive') default 'active',
    kakao_email varchar(255) unique,
    kakao_profile_url varchar(255),
    provider enum('threetier', 'kakao') default 'threetier',
    created_datetime datetime default current_timestamp,
    updated_datetime datetime default current_timestamp
);

select * from tbl_member;
