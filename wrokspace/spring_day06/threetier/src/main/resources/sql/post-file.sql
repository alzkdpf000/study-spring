create table tbl_file(
    id bigint unsigned auto_increment primary key,
    file_path varchar(255) not null,
    file_name varchar(255) not null,
    file_original_name varchar(255) not null,
    file_size varchar(255) not null,
    file_content_type varchar(255) not null,
    created_datetime datetime default current_timestamp,
    updated_datetime datetime default current_timestamp
);
select * from tbl_file;

create table tbl_post_file(
    id bigint unsigned primary key,
    post_id bigint unsigned not null,
    constraint fk_post_file_post foreign key (post_id)
                          references tbl_post(id),
    constraint fk_post_file_file foreign key (id)
                          references tbl_file(id)
);

select * from tbl_post_file;

