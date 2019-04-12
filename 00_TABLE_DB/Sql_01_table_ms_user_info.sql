create table data_base.ms_user_info
(
  id            int auto_increment comment '序号',
  user_name     nvarchar(50) not null comment '姓名',
  user_password nvarchar(200) not null comment '密码',
  age           nvarchar(5) null comment '年龄',
  gender        nvarchar(5) null comment '性别',
  phone_call    nvarchar(20) null comment '联系方式',
  address       nvarchar(200) null comment '地址',
  create_by     nvarchar(50) default 'system' not null comment '创建者',
  date_create   timestamp default sysdate() null comment '创建时间',
  update_by     nvarchar(50) default 'system' not null comment '更新者',
  date_update   timestamp default sysdate() null comment '更新时间',
  constraint ms_user_info_pk
    primary key (id)
);

