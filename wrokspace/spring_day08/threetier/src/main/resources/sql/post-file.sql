create table tbl_post_file(
    id bigint unsigned primary key,
    post_id bigint unsigned not null,
    constraint fk_post_file_post foreign key (post_id)
                          references tbl_post(id),
    constraint fk_post_file_file foreign key (id)
                          references tbl_file(id)
);

select * from tbl_post_file;

