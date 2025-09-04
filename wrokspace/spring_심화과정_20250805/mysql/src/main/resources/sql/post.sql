create table tbl_post(
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_read_count int default 0,
    member_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp,
    constraint fk_post_member foreign key (member_id)
                     references tbl_member(id)
);

select * from tbl_post;

insert into tbl_post (post_title, post_content, member_id)
values ('테스트 제목1', '테스트 내용1', 4);