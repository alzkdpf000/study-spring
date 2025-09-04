create table tbl_post(
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_read_count int default 0,
    post_status enum('active', 'inactive') default 'active',
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp,
    updated_datetime datetime default current_timestamp,
    constraint fk_post_member foreign key(member_id)
                     references tbl_member(id)
);

alter table tbl_post drop column category_id;
alter table tbl_post add column(category_id bigint unsigned);
alter table tbl_post add constraint fk_post_category foreign key(category_id) references tbl_category(id);
alter table tbl_post drop constraint fk_post_category;
/*오늘 ~ 4일 전 데이터 조회, 4일 넘어가면 조회 안됨*/
/*4 day, 4 week, 4 month*/
select * from tbl_post
where created_datetime >= date_sub(curdate(), interval 1 day)
order by id desc;

insert into tbl_post(post_title, post_content, member_id)
values ('테스트 제목4', '테스트 내용4', 3);

select * from tbl_post;
where tbl_post.category_id = 1;

delete from tbl_post;
delete from tbl_reply;
delete from tbl_post_file;