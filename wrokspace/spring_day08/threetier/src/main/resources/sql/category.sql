create table tbl_category(
    id bigint unsigned auto_increment primary key,
    category_name varchar(255),
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp()
);

insert into tbl_category(category_name)
values ('이비인후과');

select * from tbl_category;