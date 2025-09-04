create table tbl_reply(
    id bigint unsigned auto_increment primary key,
    reply_content text not null,
    member_id bigint unsigned not null,
    post_id bigint unsigned not null,
    created_datetime datetime default current_timestamp,
    updated_datetime datetime default current_timestamp,
    constraint fk_reply_member foreign key (member_id)
                      references tbl_member(id),
    constraint fk_reply_post foreign key (post_id)
        references tbl_post(id)
);

select * from tbl_reply;

create view view_reply_member as
(
    select r.id, r.reply_content, r.member_id, m.member_name,
           r.post_id, r.created_datetime, r.updated_datetime
    from tbl_member m join tbl_reply r
    on m.id = r.member_id
);

insert into tbl_reply(reply_content, member_id, post_id)
(select reply_content, member_id, post_id from tbl_reply);



















