drop table frm_sysuser;
create table frm_sysuser(
     userId int primary key comment '用户ID',
     userName varchar(32) NOT NULL comment '系统用户名',
     password varchar(100) NOT NULL comment '密码',
     department varchar(20) NOT NULL comment '用户所在部门',
     sex char(1) comment '性别',
     birthday date comment '出生日期',
     sfzmhm varchar(20) comment '身份证明号码',
     email varchar(50) comment '邮箱',
     ipks varchar(20) comment '登陆地址段起始ip',
     ipjs varchar(20) comment '登陆地址段结束ip',
     zhyxq date comment '账号有效期',
     mmyxq date comment '密码有效期',
     yhlx char(1) comment '用户类型',
     lxdh varchar(30) comment '联系电话',
     zjdlip varchar(20) comment '最近登陆地址ip',
     zt char(1) comment '用户状态：0代表删除，1代表正常，2代表锁定（停用）',
     cjsj date comment '创建时间',
     gxsj date comment '更新时间')ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户信息表';

insert into frm_sysuser values('1000','admin','$2a$10$b7FbBNdjQDgQNbBbn.bCLeEntO6WBm3Ail/zOSJvM7nCTSr/ZBosq','451229000000','1','1989-08-09','','','','','2020-01-01','2020-01-01','1','','','1',now(),now());
drop table frm_role;
create table frm_role(
    roleId int primary key comment '角色id',
    roleName varchar(32) comment '角色名称',
    description varchar(60) comment '描述',
    zt char(1) comment '角色状态：0代表删除，1代表正常，2代表停用',
    cjsj date comment '创建时间',
    gxsj date comment '更新时间')ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '角色表';

insert into frm_role values(1000,'系统管理员','系统管理员，拥有所有权限','1',now(),now());

drop table frm_menu;
create table frm_menu(
    menuId int primary key comment '菜单id',
    parentId int not null comment '上级菜单',
    menuName varchar(32) comment '菜单名称',
    css varchar(30) comment '图标样式',
    url varchar(100) comment '图标url',
    type char(1) COMMENT '菜单类型 1：菜单 2：按钮',
    permission varchar(10) COMMENT '按钮权限 a,d,u,s 分别代表增删改查',
    sequence int not null comment '排序',
    zt char(1) comment '菜单状态：0代表删除，1代表正常，2代表停用',
    cjsj date comment '创建时间',
    gxsj date comment '更新时间')ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '菜单表';

insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(1000,'','系统管理',0,'/admin','1','a,d,u,s',1,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(1001,'','用户管理',1000,'/admin/user','1','a,d,u,s',2,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(1002,'','部门管理',1000,'/admin/dept','1','a,d,u,s',3,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(1003,'','角色管理',1000,'/admin/role','1','a,d,u,s',4,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(1004,'','权限管理',1000,'/admin/permit','1','a,d,u,s',5,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(2000,'','移民管理',0,'/ym','1','a,d,u,s',11,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(2001,'','移民信息采集',2000,'/ym/add','1','a,d,u,s',12,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(2002,'','移民信息管理',2000,'/ym/mgr','1','a,d,u,s',13,'1',now(),now());
insert into frm_menu(menuId, css, menuName, parentId, url,type,permission, sequence, zt, cjsj, gxsj) values(2003,'','影像化采集',2000,'/ym/img','1','a,d,u,s',14,'1',now(),now());





drop table frm_sysuser_role;
create table frm_sysuser_role(
    userId int not null ,
    roleId int not null,
    primary key (userid,roleid)
) comment '用户与角色关联表';

insert into frm_sysuser_role values(1000,1000);

drop table frm_role_menu;
create table frm_role_menu(
     roleId int not null ,
     menuId int not null,
      primary key (roleId,menuId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '角色-菜单-权限关联表';
insert into frm_role_menu values(1000,1000);
insert into frm_role_menu values(1000,1001);
insert into frm_role_menu values(1000,1002);
insert into frm_role_menu values(1000,1003);
insert into frm_role_menu values(1000,1004);
insert into frm_role_menu values(1000,2000);
insert into frm_role_menu values(1000,2001);
insert into frm_role_menu values(1000,2002);
insert into frm_role_menu values(1000,2003);

drop table frm_department;
create table frm_department(
    departmentCode int primary key ,
    departmentName varchar(100),
    fzjg varchar(10),
    fzr varchar(30),
    lxdh varchar(20),
    sjbm varchar(20),
    zt char(1),
    cjsj date comment '创建时间',
    gxsj date comment '更新时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '用户部门表';


drop table persistent_logins;
#存放用户验证token的表
create table persistent_logins(
    username varchar(64) not null comment '验证后的用户名',
    series varchar(64) not null primary key comment '主键信息',
    token varchar(64) not null comment '用户token',
    last_used timestamp not null comment '最近使用时间'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment '验证用户token存放表';