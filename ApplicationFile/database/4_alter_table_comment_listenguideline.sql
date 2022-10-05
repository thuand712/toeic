use toeic;

alter table comment add constraint fk_comment_user foreign key (userid) references userEntity(userid);
alter table comment add constraint fk_comment_listenguideline foreign key (listenguidelineid) references listenguideline(listenguidelineid);