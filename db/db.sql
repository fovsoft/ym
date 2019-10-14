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
     gxsj date comment '更新时间') comment '用户信息表';

insert into frm_sysuser values('1000','admin','$2a$10$b7FbBNdjQDgQNbBbn.bCLeEntO6WBm3Ail/zOSJvM7nCTSr/ZBosq','451229000000','1','1989-08-09','','','','','2020-01-01','2020-01-01','1','','','1',now(),now());
create table frm_role(
    roleId int primary key comment '角色id',
    roleName varchar(32) comment '角色名称',
    description varchar(60) comment '描述',
    zt char(1) comment '角色状态：0代表删除，1代表正常，2代表停用',
    cjsj date comment '创建时间',
    gxsj date comment '更新时间') comment '角色表';

create table frm_menu(
    menuId int primary key comment '菜单id',
    parentId int not null comment '上级菜单',
    menuName varchar(32) comment '菜单名称',
    css varchar(30) comment '图标样式',
    url varchar(100) comment '图标url',
    type char(1) comment '菜单类型 1：菜单 2：按钮',
    permission varchar(32) comment '按钮权限',
    sequence int not null comment '排序',
    zt char(1) comment '菜单状态：0代表删除，1代表正常，2代表停用',
    cjsj date comment '创建时间',
    gxsj date comment '更新时间') comment '菜单表';

create table frm_sysuser_role(
    userId int not null ,
    roleId int not null,
    primary key (userid,roleid)
) comment '用户与角色关联表';

create table frm_role_menu(
     roleId int not null ,
     menuId int not null,
      primary key (roleId,menuId)
) comment '用户与角色关联表';


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
)