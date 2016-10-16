create table a8_comment(
id bigint(20) unsigned not null auto_increment comment '主键ID',
content varchar(1024) null comment '评论内容',
approve_count int(10) DEFAULT 0 comment '点赞数',
parent_id bigint(20) null comment '父亲被评论ID',
origin_id varchar(512) null comment '评论源ID',
user_id varchar(512) null comment '用户ID',
user_logo varchar(1024) null comment '用户头像',
user_nickname varchar(512) null comment '用户昵称',
machine_code varchar(1024) null comment '设备机器码',
create_time DATETIME not null DEFAULT CURRENT_TIMESTAMP comment '评论时间',
state tinyint(3) not null DEFAULT 1 comment '0 无效 1 有效',
PRIMARY KEY (id)
);