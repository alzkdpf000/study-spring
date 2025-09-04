create table tbl_post_category(
    id bigint unsigned auto_increment primary key,
    post_id bigint unsigned not null,
    category_id bigint unsigned not null
);

select * from tbl_post_category;
select * from tbl_post;
insert into tbl_post_category (post_id, category_id)
values(195, 2);

select count(*)
from
    (
    select distinct p.*, m.member_name
    from tbl_member m
    join tbl_post p
    on m.id = p.member_id
        join tbl_post_category pc
        on p.id = pc.post_id
            join tbl_category c on
            c.id = pc.category_id
    ) a;













