drop table frm_sysuser;
create table frm_sysuser
(
    userId     int auto_increment primary key comment '用户ID',
    userName   varchar(32)  NOT NULL comment '系统用户名',
    password   varchar(100) NOT NULL comment '密码',
    department varchar(20)  NOT NULL comment '用户所在部门',
    sex        char(1) comment '性别',
    birthday   date comment '出生日期',
    sfzmhm     varchar(20) comment '身份证明号码',
    email      varchar(50) comment '邮箱',
    ipks       varchar(20) comment '登陆地址段起始ip',
    ipjs       varchar(20) comment '登陆地址段结束ip',
    zhyxq      date comment '账号有效期',
    mmyxq      date comment '密码有效期',
    yhlx       char(1) comment '用户类型',
    lxdh       varchar(30) comment '联系电话',
    zjdlip     varchar(20) comment '最近登陆地址ip',
    zt         char(1) comment '用户状态：0代表删除，1代表正常，2代表锁定（停用）',
    cjsj       datetime comment '创建时间',
    gxsj       datetime comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户信息表';

insert into frm_sysuser(userName,password,department,sex,birthday,sfzmhm,email,ipks,ipjs,zhyxq,mmyxq,yhlx,lxdh,zjdlip,zt,cjsj,gxsj)
values ('admin', '$2a$10$b7FbBNdjQDgQNbBbn.bCLeEntO6WBm3Ail/zOSJvM7nCTSr/ZBosq', '451229000000', '1',
        '1989-08-09', '', '', '', '', '2020-01-01', '2020-01-01', '1', '', '', '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
drop table frm_role;
create table frm_role
(
    roleId      int auto_increment primary key comment '角色id',
    roleName    varchar(32) comment '角色名称',
    description varchar(60) comment '描述',
    zt          char(1) comment '角色状态：0代表删除，1代表正常，2代表停用',
    cjsj        datetime comment '创建时间',
    gxsj        datetime comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色表';

insert into frm_role(roleName, description, zt, cjsj, gxsj)
values ('系统管理员', '系统管理员，拥有所有权限', '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');

drop table frm_menu;
create table frm_menu
(
    menuId     int auto_increment primary key comment '菜单id',
    parentId   int not null comment '上级菜单',
    menuName   varchar(32) comment '菜单名称',
    css        varchar(30) comment '图标样式',
    url        varchar(100) comment '图标url',
    type       char(1) COMMENT '菜单类型 1：菜单 2：按钮',
    permission varchar(10) COMMENT '按钮权限 a,d,u,s 分别代表增删改查',
    sequence   int not null comment '排序',
    zt         char(1) comment '菜单状态：0代表删除，1代表正常，2代表停用',
    cjsj       datetime comment '创建时间',
    gxsj       datetime comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '菜单表';

insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '系统管理', 0, '/admin', '1', 'a,d,u,s', 1, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '用户管理', 1, '/admin/user', '1', 'a,d,u,s', 2, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ( '', '行政区划管理', 1, '/admin/dept', '1', 'a,d,u,s', 3, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '角色管理', 1, '/admin/role', '1', 'a,d,u,s', 4, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '菜单管理', 1, '/admin/sysMenu', '1', 'a,d,u,s', 6, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '移民管理', 0, '/ym', '1', 'a,d,u,s', 11, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '移民信息采集', 6, '/ym/add', '1', 'a,d,u,s', 12, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '移民信息管理', 6, '/ym/mgr', '1', 'a,d,u,s', 13, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '影像化采集', 6, '/ym/img', '1', 'a,d,u,s', 14, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');
insert into frm_menu( css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values ('', '收入信息采集', 6, '/ym/income', '1', 'a,d,u,s', 15, '1', '2019-11-06 08:00:00', '2019-11-06 08:00:00');



drop table frm_sysuser_role;
create table frm_sysuser_role
(
    userId int not null,
    roleId int not null,
    primary key (userid, roleid)
) comment '用户与角色关联表';

insert into frm_sysuser_role
values (1, 1);

drop table frm_role_menu;
create table frm_role_menu
(
    roleId int not null,
    menuId int not null,
    primary key (roleId, menuId)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色-菜单-权限关联表';
insert into frm_role_menu
values (1, 1);
insert into frm_role_menu
values (1, 2);
insert into frm_role_menu
values (1, 3);
insert into frm_role_menu
values (1, 4);
insert into frm_role_menu
values (1, 5);
insert into frm_role_menu
values (1, 6);
insert into frm_role_menu
values (1, 7);
insert into frm_role_menu
values (1, 8);
insert into frm_role_menu
values (1, 9);
insert into frm_role_menu
values (1, 10);

drop table frm_department;
create table frm_department
(
    departmentCode int primary key,
    departmentName varchar(100),
    fzjg           varchar(10),
    fzr            varchar(30),
    lxdh           varchar(20),
    sjbm           varchar(20),
    zt             char(1),
    cjsj           date comment '创建时间',
    gxsj           date comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户部门表';


drop table frm_administrative_division;
create table frm_administrative_division
(
    id       int auto_increment primary key,
    xzqhdm   varchar(20) unique comment '行政区划代码',
    xzqhmz   varchar(80) comment '行政区划名字',
    xxxzqhmz varchar(80) comment '详细行政区划名字',
    sjxzqhdm varchar(20) comment '上级行政区划代码',
    xzqhcj   varchar(10) comment '层级',
    fzjg     varchar(10) comment '发证机关',
    xzqhlb   varchar(20) comment '类别',
    yzbm     varchar(20) comment '邮政编码',
    cjsj     datetime comment '创建时间',
    gxsj     datetime comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '行政区划表';
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('1','008600000000','中国','中华人民共和国','0','','国家','008600','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('2','450100000000','广西省','广西壮族自治区','008600000000','桂','省','530000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('3','450700000000','钦州市','广西壮族自治区钦州市','450100000000','桂N','地级市','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('4','450701000000','钦州市市辖区','广西壮族自治区钦州市市辖区','450700000000','桂N','市区','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('4','450702000000','钦州市钦南区','广西壮族自治区钦州市钦南区','450700000000','桂N','市区','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('4','450703000000','钦州市钦北区','广西壮族自治区钦州市钦北区','450700000000','桂N','市区','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('4','450704000000','钦州市灵山县','广西壮族自治区钦州市灵山县','450700000000','桂N','县','535400','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('4','450721000000','钦州市浦北县','广西壮族自治区钦州市浦北县','450700000000','桂N','县','535300','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('4','450722000000','钦州市浦北县','广西壮族自治区钦州市浦北县','450700000000','桂N','县','535300','2019-11-09 21:40:00','2019-11-09 21:40:01');

insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702001000', '向阳街道'	      ,'广西壮族自治区钦州市钦南区向阳街道'	      ,'450702000000','桂N','街道',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702002000', '水东街道'	      ,'广西壮族自治区钦州市钦南区水东街道'	      ,'450702000000','桂N','街道',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702003000', '文峰街道'	      ,'广西壮族自治区钦州市钦南区文峰街道'	      ,'450702000000','桂N','街道', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702004000', '南珠街道'	      ,'广西壮族自治区钦州市钦南区南珠街道'	      ,'450702000000','桂N','街道', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702005000', '尖山街道'	      ,'广西壮族自治区钦州市钦南区尖山街道'	      ,'450702000000','桂N','街道', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702100000', '沙埠镇'					      ,'广西壮族自治区钦州市钦南区沙埠镇'					      ,'450702000000','桂N','镇',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702101000', '康熙岭镇'				      ,'广西壮族自治区钦州市钦南区康熙岭镇'				      ,'450702000000','桂N','镇',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702102000', '黄屋屯镇'				      ,'广西壮族自治区钦州市钦南区黄屋屯镇'				      ,'450702000000','桂N','镇',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702104000', '大番坡镇'				      ,'广西壮族自治区钦州市钦南区大番坡镇'				      ,'450702000000','桂N','镇',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702105000', '龙门港镇'				      ,'广西壮族自治区钦州市钦南区龙门港镇'				      ,'450702000000','桂N','镇',		 '535034','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702107000', '久隆镇'					      ,'广西壮族自治区钦州市钦南区久隆镇'					      ,'450702000000','桂N','镇',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702108000', '东场镇'					      ,'广西壮族自治区钦州市钦南区东场镇'					      ,'450702000000','桂N','镇',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702109000', '那丽镇'					      ,'广西壮族自治区钦州市钦南区那丽镇'					      ,'450702000000','桂N','镇',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702110000', '那彭镇'					      ,'广西壮族自治区钦州市钦南区那彭镇'					      ,'450702000000','桂N','镇',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702111000', '那思镇'					      ,'广西壮族自治区钦州市钦南区那思镇'					      ,'450702000000','桂N','镇',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702112000', '犀牛脚镇'				      ,'广西壮族自治区钦州市钦南区犀牛脚镇'				      ,'450702000000','桂N','镇',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702400000', '丽光华侨农场'					,'广西壮族自治区钦州市钦南区丽光华侨农场'					,'450702000000','桂N','农场',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702401000', '钦州港经济技术开发区'	,'广西壮族自治区钦州市钦南区钦州港经济技术开发区'	,'450702000000','桂N','开发区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702402000', '三娘湾旅游管理区'		  ,'广西壮族自治区钦州市钦南区三娘湾旅游管理区'		  ,'450702000000','桂N','管理区','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702403000', '广西钦州保税港区'			,'广西壮族自治区钦州市钦南区广西钦州保税港区'			,'450702000000','桂N','港区',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('5','450702404000', '中马钦州产业园区'			,'广西壮族自治区钦州市钦南区中马钦州产业园区'			,'450702000000','桂N','园区',  '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702001003', '新兴社区居委会'	      ,'广西壮族自治区钦州市钦南区向阳街道办事处新兴社区'	      ,'450702001000','桂N','社区',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702001004', '新兴社区居委会'	      ,'广西壮族自治区钦州市钦南区向阳街道办事处新兴社区'	      ,'450702001000','桂N','社区',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702002001', '东南社区居委会'	      ,'广西壮族自治区钦州市钦南区水东街道办事处东南社区'	      ,'450702002000','桂N','社区',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702002002', '五里桥社区居委会'	      ,'广西壮族自治区钦州市钦南区水东街道办事处五里桥社区'	      ,'450702002000','桂N','社区',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702002005', '大沙垌社区居委会'	      ,'广西壮族自治区钦州市钦南区水东街道办事处大沙垌社区'	      ,'450702002000','桂N','社区',	'535000','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702003001', '东风社区居委会'	      ,'广西壮族自治区钦州市钦南区文峰街道办事处东风社区'	      ,'450702003000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702003002', '江滨社区居委会'	      ,'广西壮族自治区钦州市钦南区文峰街道办事处江滨社区'	      ,'450702003000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702003003', '中山社区居委会'	      ,'广西壮族自治区钦州市钦南区文峰街道办事处中山社区'	      ,'450702003000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702003004', '三宣堂社区居委会'	      ,'广西壮族自治区钦州市钦南区文峰街道办事处三宣堂社区'	      ,'450702003000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702003005', '文昌社区居委会'	      ,'广西壮族自治区钦州市钦南区文峰街道办事处文昌社区'	      ,'450702003000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702003006', '新隆社区居委会'	      ,'广西壮族自治区钦州市钦南区文峰街道办事处新隆社区'	      ,'450702003000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');



insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702004001', '城西社区居委会'	      ,'广西壮族自治区钦州市钦南区南珠街道办事处城西社区'	      ,'450702004000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702004002', '高岭社区居委会'	      ,'广西壮族自治区钦州市钦南区南珠街道办事处高岭社区'	      ,'450702004000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702004003', '鸿泰社区居委会'	      ,'广西壮族自治区钦州市钦南区南珠街道办事处鸿泰社区'	      ,'450702004000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');



insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005001', '尖山社区居委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处尖山社区'	      ,'450702005000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005002', '排榜社区居委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处排榜社区'	      ,'450702005000','桂N','社区', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005202', '西沟村委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处西沟村'	      ,'450702005000','桂N','村', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005203', '黄坡豕村委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处黄坡豕村'	      ,'450702005000','桂N','村', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005204', '谷仓村委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处谷仓村'	      ,'450702005000','桂N','村', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005205', '九鸦村委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处九鸦村'	      ,'450702005000','桂N','村', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702005206', '黎头咀村委会'	      ,'广西壮族自治区钦州市钦南区尖山街道办事处黎头咀村'	      ,'450702005000','桂N','村', '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');




insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100001','沙埠社区'					            ,'广西壮族自治区钦州市钦南区沙埠镇沙埠社区'					          ,'450702100000','桂N','社区',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100002','田寮社区'	  					      ,'广西壮族自治区钦州市钦南区沙埠镇田寮社区'					      ,'450702100000','桂N','社区',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100201','大石古村'	    					      ,'广西壮族自治区钦州市钦南区沙埠镇大石古村',	  '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100202','下南山村'	    					      ,'广西壮族自治区钦州市钦南区沙埠镇下南山村',	  '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100203','大岭村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇大岭村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100204','沙寮村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇沙寮村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100205','油路村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇油路村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100206','桥坪村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇桥坪村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100207','海棠村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇海棠村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100210','分界村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇分界村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100211','坭桥村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇坭桥村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100212','望埠村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇望埠村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100213','平艮村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇平艮村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100214','油埠村'	      					      ,'广西壮族自治区钦州市钦南区沙埠镇油埠村',	    '450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702100215','明天移民新村'					        ,'广西壮族自治区钦州市钦南区沙埠镇明天移民新村','450702100000','桂N','村',	   '535011','2019-11-09 21:40:00','2019-11-09 21:40:01');



insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101201','傍钦村','广西壮族自治区钦州市钦南区康熙岭镇傍钦村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101202','高沙村','广西壮族自治区钦州市钦南区康熙岭镇高沙村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101203','西围村','广西壮族自治区钦州市钦南区康熙岭镇西围村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101204','新平村','广西壮族自治区钦州市钦南区康熙岭镇新平村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101205','诗家村','广西壮族自治区钦州市钦南区康熙岭镇诗家村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101206','白鸡村','广西壮族自治区钦州市钦南区康熙岭镇白鸡村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101207','板坪村','广西壮族自治区钦州市钦南区康熙岭镇板坪村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101208','横山村','广西壮族自治区钦州市钦南区康熙岭镇横山村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101209','长坡村','广西壮族自治区钦州市钦南区康熙岭镇长坡村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101210','团和村','广西壮族自治区钦州市钦南区康熙岭镇团和村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101211','新营村','广西壮族自治区钦州市钦南区康熙岭镇新营村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702101212','新南村','广西壮族自治区钦州市钦南区康熙岭镇新南村'				      ,'450702101000','桂N','村',		 '535012','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102001',  '黄屋屯社区','广西壮族自治区钦州市钦南区黄屋屯镇黄屋屯社区'				      ,'450702102000','桂N','社区',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102201',  '屯西村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯西村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102202',  '屯安村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯安村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102203',  '屯胜村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯胜村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102204',  '屯利村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯利村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102205',  '加其村',	  '广西壮族自治区钦州市钦南区黄屋屯镇加其村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102206',  '屯北村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯北村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102207',  '大冲村',	  '广西壮族自治区钦州市钦南区黄屋屯镇大冲村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102208',  '屯光村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯光村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102209',  '屯南村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯南村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102210',  '金竹村',	  '广西壮族自治区钦州市钦南区黄屋屯镇金竹村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102211',  '圩埠村',	  '广西壮族自治区钦州市钦南区黄屋屯镇圩埠村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102212',  '田寮村',	  '广西壮族自治区钦州市钦南区黄屋屯镇田寮村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102213',  '塘营村',	  '广西壮族自治区钦州市钦南区黄屋屯镇塘营村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102214',  '屯显村',	  '广西壮族自治区钦州市钦南区黄屋屯镇屯显村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102215',  '西显村',	  '广西壮族自治区钦州市钦南区黄屋屯镇西显村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702102216',  '料连村',	  '广西壮族自治区钦州市钦南区黄屋屯镇料连村'				      ,'450702102000','桂N','村',		 '535033','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104001',  '茅坡社区',	'广西壮族自治区钦州市钦南区大番坡镇茅坡社区',	'450702000000','桂N','社区',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104201',  '沙坡村',	  '广西壮族自治区钦州市钦南区大番坡镇沙坡村',	  '450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104202',  '葵子村',	  '广西壮族自治区钦州市钦南区大番坡镇葵子村',	  '450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104203',  '大番坡村',	'广西壮族自治区钦州市钦南区大番坡镇大番坡村',	'450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104204',  '青龙村',	  '广西壮族自治区钦州市钦南区大番坡镇青龙村',	  '450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104205',  '板桥村',	  '广西壮族自治区钦州市钦南区大番坡镇板桥村',	  '450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104206',  '大窝口村',	'广西壮族自治区钦州市钦南区大番坡镇大窝口村',	'450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104207',  '六村村',	  '广西壮族自治区钦州市钦南区大番坡镇六村村',	  '450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104208',  '深坪村',	  '广西壮族自治区钦州市钦南区大番坡镇深坪村',	  '450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702104210',  '辣椒槌村',	'广西壮族自治区钦州市钦南区大番坡镇辣椒槌村',	'450702000000','桂N','村',		 '535037','2019-11-09 21:40:00','2019-11-09 21:40:01');



insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702105201', '东村'				      ,'广西壮族自治区钦州市钦南区龙门港镇东村'				      ,'450702105000','桂N','村',		 '535034','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702105202', '南村'				      ,'广西壮族自治区钦州市钦南区龙门港镇南村'				      ,'450702105000','桂N','村',		 '535034','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702105203', '西村'				      ,'广西壮族自治区钦州市钦南区龙门港镇西村'				      ,'450702105000','桂N','村',		 '535034','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702105204', '北村'				      ,'广西壮族自治区钦州市钦南区龙门港镇北村'				      ,'450702105000','桂N','村',		 '535034','2019-11-09 21:40:00','2019-11-09 21:40:01');




insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107001',  '久隆社区',	'广西壮族自治区钦州市钦南区久隆镇久隆社区',	' 450702107000','桂N','社区',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107201',  '久隆村',    '广西壮族自治区钦州市钦南区久隆镇久隆村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107202',  '黎屋村',    '广西壮族自治区钦州市钦南区久隆镇黎屋村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107203',  '沙田村',    '广西壮族自治区钦州市钦南区久隆镇沙田村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107204',  '丁屋村',    '广西壮族自治区钦州市钦南区久隆镇丁屋村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107205',  '高桥村',    '广西壮族自治区钦州市钦南区久隆镇高桥村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107206',  '水铺村',    '广西壮族自治区钦州市钦南区久隆镇水铺村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107207',  '新明村',    '广西壮族自治区钦州市钦南区久隆镇新明村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107208',  '平新村',    '广西壮族自治区钦州市钦南区久隆镇平新村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107209',  '那庆村',    '广西壮族自治区钦州市钦南区久隆镇那庆村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107210',  '白鹤村',    '广西壮族自治区钦州市钦南区久隆镇白鹤村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107211',  '青草村',    '广西壮族自治区钦州市钦南区久隆镇青草村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107212',  '大岭村',    '广西壮族自治区钦州市钦南区久隆镇大岭村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107213',  '高明村',    '广西壮族自治区钦州市钦南区久隆镇高明村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107214',  '新圩村',    '广西壮族自治区钦州市钦南区久隆镇新圩村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107215',  '石安村',    '广西壮族自治区钦州市钦南区久隆镇石安村',    '450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107216',  '细岭头村',	'广西壮族自治区钦州市钦南区久隆镇细岭头村',	' 450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702107217',  '荷木村',	  '广西壮族自治区钦州市钦南区久隆镇荷木村',	  ' 450702107000','桂N','村',		 '535017','2019-11-09 21:40:00','2019-11-09 21:40:01');




insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108201', '关塘村','广西壮族自治区钦州市钦南区东场镇关塘村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108202', '六加村','广西壮族自治区钦州市钦南区东场镇六加村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108203', '高塘村','广西壮族自治区钦州市钦南区东场镇高塘村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108204', '东场村','广西壮族自治区钦州市钦南区东场镇东场村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108205', '英窝村','广西壮族自治区钦州市钦南区东场镇英窝村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108206', '白木村','广西壮族自治区钦州市钦南区东场镇白木村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702108207', '上寮村','广西壮族自治区钦州市钦南区东场镇上寮村'					      ,'450702108000','桂N','村',		 '535014','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109001','那丽社区',	'广西壮族自治区钦州市钦南区那丽镇那丽社区',	 '450702109000','桂N','社区',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109201','那丽村',	  '广西壮族自治区钦州市钦南区那丽镇那丽村',	   '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109202','充包村',	  '广西壮族自治区钦州市钦南区那丽镇充包村',	   '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109203','殿艮村',	  '广西壮族自治区钦州市钦南区那丽镇殿艮村',	   '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109204','芦荻竹村',	'广西壮族自治区钦州市钦南区那丽镇芦荻竹村',	 '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109205','嫦娥垌村',	'广西壮族自治区钦州市钦南区那丽镇嫦娥垌村',	 '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109206','马鞍岭村',	'广西壮族自治区钦州市钦南区那丽镇马鞍岭村',	 '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109207','崩塘村',	  '广西壮族自治区钦州市钦南区那丽镇崩塘村',	   '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109208','那雾塘村',  '广西壮族自治区钦州市钦南区那丽镇那雾塘村',  '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109209','土地田村',  '广西壮族自治区钦州市钦南区那丽镇土地田村',  '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702109210','三蔸竹村',  '广西壮族自治区钦州市钦南区那丽镇三蔸竹村',  '450702109000','桂N','村',		 '535013','2019-11-09 21:40:00','2019-11-09 21:40:01');

insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110001','那彭社区'						      ,'广西壮族自治区钦州市钦南区那彭镇那彭社区'						      ,'450702110000','桂N','社区',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110201','那彭村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇那彭村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110202','担坳村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇担坳村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110203','那蒟村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇那蒟村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110204','白沙村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇白沙村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110205','六湖村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇六湖村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110206','彭新村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇彭新村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110207','清湖村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇清湖村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110208','那勉村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇那勉村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110209','凤凰岗村'						      ,'广西壮族自治区钦州市钦南区那彭镇凤凰岗村'						      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110210','那里村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇那里村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110211','后立村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇后立村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110212','英学村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇英学村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702110213','屋背村'	  					      ,'广西壮族自治区钦州市钦南区那彭镇屋背村'	  					      ,'450702110000','桂N','村',		 '535015','2019-11-09 21:40:00','2019-11-09 21:40:01');




insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111201','合江村'	  				      ,'广西壮族自治区钦州市钦南区那思镇合江村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111202','禄宦塘村'					      ,'广西壮族自治区钦州市钦南区那思镇禄宦塘村'					      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111203','米子村'	  				      ,'广西壮族自治区钦州市钦南区那思镇米子村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111204','那京村'	  				      ,'广西壮族自治区钦州市钦南区那思镇那京村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111205','那思村'	  				      ,'广西壮族自治区钦州市钦南区那思镇那思村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111206','塘底村'	  				      ,'广西壮族自治区钦州市钦南区那思镇塘底村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111207','定蒙村'	  				      ,'广西壮族自治区钦州市钦南区那思镇定蒙村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111208','茶蓝垌村'					      ,'广西壮族自治区钦州市钦南区那思镇茶蓝垌村'					      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111209','牛寮水村'					      ,'广西壮族自治区钦州市钦南区那思镇牛寮水村'					      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702111210','扁陂村'	  				      ,'广西壮族自治区钦州市钦南区那思镇扁陂村'	  				      ,'450702111000','桂N','村',		 '535016','2019-11-09 21:40:00','2019-11-09 21:40:01');



insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112001','新联社区'				      ,'广西壮族自治区钦州市钦南区犀牛脚镇新联社区'				      ,'450702112000','桂N','社区',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112002','丹寮社区'				      ,'广西壮族自治区钦州市钦南区犀牛脚镇丹寮社区'				      ,'450702112000','桂N','社区',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112203','犀牛脚村'				      ,'广西壮族自治区钦州市钦南区犀牛脚镇犀牛脚村'				      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112205','联民村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇联民村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112206','白路村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇白路村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112207','船厂村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇船厂村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112208','岭脚村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇岭脚村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112209','西寮村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇西寮村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112210','炮台村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇炮台村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112211','岭门村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇岭门村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112212','埠头村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇埠头村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112213','西坑村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇西坑村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112214','大灶村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇大灶村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112215','平山村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇平山村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112217','大坪村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇大坪村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702112219','沙角村'	  			      ,'广西壮族自治区钦州市钦南区犀牛脚镇沙角村'	  			      ,'450702112000','桂N','村',		 '535035','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702400501','总场'	          				,'广西壮族自治区钦州市钦南区丽光华侨农场总场'	          				,'450702400000','桂N','农场',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702400502','新屋管区生活区'					,'广西壮族自治区钦州市钦南区丽光华侨农场新屋管区生活区'					,'450702400000','桂N','生活区',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702400503','均田管区生活区'					,'广西壮族自治区钦州市钦南区丽光华侨农场均田管区生活区'					,'450702400000','桂N','生活区',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702400504','凤凰管区生活区'					,'广西壮族自治区钦州市钦南区丽光华侨农场凤凰管区生活区'					,'450702400000','桂N','生活区',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401001','滨海社区'	  	,'广西壮族自治区钦州市钦南区钦州港经济技术开发区滨海社区'	  	,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401002','亚路江社区'		,'广西壮族自治区钦州市钦南区钦州港经济技术开发区亚路江社区'		,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401003','水井坑社区'		,'广西壮族自治区钦州市钦南区钦州港经济技术开发区水井坑社区'		,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401004','果子山社区'		,'广西壮族自治区钦州市钦南区钦州港经济技术开发区果子山社区'		,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401005','鸡墩头社区'		,'广西壮族自治区钦州市钦南区钦州港经济技术开发区鸡墩头社区'		,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401006','金鼓社区'	  	,'广西壮族自治区钦州市钦南区钦州港经济技术开发区金鼓社区'	  	,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702401007','鹿耳环社区'		,'广西壮族自治区钦州市钦南区钦州港经济技术开发区鹿耳环社区'		,'450702401000','桂N','社区','535008','2019-11-09 21:40:00','2019-11-09 21:40:01');



insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702402201','三娘湾村'		  ,'广西壮族自治区钦州市钦南区三娘湾旅游管理区三娘湾村'		  ,'450702402000','桂N','村','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702402202','大环村'	  	  ,'广西壮族自治区钦州市钦南区三娘湾旅游管理区大环村'	  	  ,'450702402000','桂N','村','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702402204','乌雷村'	  	  ,'广西壮族自治区钦州市钦南区三娘湾旅游管理区乌雷村'	  	  ,'450702402000','桂N','村','535000','2019-11-09 21:40:00','2019-11-09 21:40:01');


insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702403498', '虚拟社区'			,'广西壮族自治区钦州市钦南区广西钦州保税港区虚拟社区'			,'450702403000','桂N','社区',	 '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');
insert into frm_administrative_division(xzqhcj,xzqhdm,xzqhmz,xxxzqhmz,sjxzqhdm,fzjg,xzqhlb,yzbm,cjsj,gxsj) values ('6','450702404498', '虚拟社区'			,'广西壮族自治区钦州市钦南区中马钦州产业园区虚拟社区'			,'450702404000','桂N','社区',  '535000','2019-11-09 21:40:00','2019-11-09 21:40:01');


drop table persistent_logins;
#存放用户验证token的表
create table persistent_logins
(
    username  varchar(64) not null comment '验证后的用户名',
    series    varchar(64) not null primary key comment '主键信息',
    token     varchar(64) not null comment '用户token',
    last_used timestamp   not null comment '最近使用时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '验证用户token存放表';


drop table ym_family;
#移民贫困人员家庭信息表
create table ym_family
(
    jtId      int auto_increment primary key comment '家庭信息表id',
    jtbh      varchar(20) unique comment '家庭编号',
    xzqhdm    varchar(20) comment '家庭地址（对应行政区划表）',
    xxxzqhmz  varchar(80) comment '详细行政区划名字',
    lxdh      varchar(20) comment '联系电话',
    khyh      varchar(32) comment '开户银行（选填）',
    yhkh      varchar(20) comment '银行卡号（选填）',
    pkhsx     varchar(30) comment '贫困户属性',
    sfdnytp   char(2) comment '是否当年预脱贫',
    jhtpnd    varchar(10) comment '计划脱贫年度',
    fpnd      varchar(10) comment '返贫年度',
    fpyy      varchar(64) comment '返贫原因',
    sfjls     char(2) comment '是否军烈属',
    sfydfpbqh varchar(64) comment '是否异地扶贫搬迁户',
    bqfs      varchar(64) comment '搬迁方式',
    bqdz      varchar(80) comment '搬迁地址'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '移民贫困家庭信息表';

insert into ym_family(jtbh,xzqhdm,xxxzqhmz,lxdh,khyh,yhkh,pkhsx,sfdnytp,jhtpnd,fpnd,fpyy,sfjls,sfydfpbqh,bqfs,bqdz) values
('b4aa05cfd980','450702404498','广西壮族自治区钦州市钦南区中马钦州产业园区虚拟社区','18200000000','中国农业银行','','','是','2020','2013','受灾','否','否','','');


drop table ym_person;
#用来存放移民信息的表
create table ym_person
(
    rybh       int auto_increment primary key comment '人员编号',
    jtbh       varchar(20) comment '家庭编号，对应家庭表',
    xm         varchar(30) not null comment '姓名',
    xb         char(2) comment '性别',
    sfzmhm     varchar(20) comment '身份证明号码',
    qfjg       varchar(64) comment '身份证签发机关',
    sfzyxqs    date comment '身份证有效期始',
    sfzyxqz    date comment '身份证有效期止',
    yhzgx      varchar(20) comment '与户主关系',
    mz         varchar(20) comment '民族',
    csrq       date comment '出生日期',
    zzmm       varchar(30) comment '政治面貌',
    whcd       varchar(20) comment '文化程度',
    zxsqk      varchar(30) comment '在校生情况',
    sxhcxyy    varchar(64) comment '失学或辍学原因',
    jkqk       varchar(20) comment '健康情况',
    ldjn       varchar(20) comment '劳动技能情况',
    sfhjpth    char(2) comment '是否会讲普通话',
    sfxyjr     char(2) comment '是否现役军人',
    sfcjylbx1  char(2) comment '是否参加城乡居民基本医疗保险',
    sfcjsybx   char(2) comment '是否参加商业补充医疗保险',
    sfxsdb     char(2) comment '是否享受低保',
    sfcjylbx2  char(2) comment '是否参加城乡居民基本养老保险',
    sfxsywbxbt char(2) comment '是否享受人身意外保险补贴',
    lxdh       varchar(20) comment '联系电话'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '移民贫困人员信息表';

insert into ym_person(jtbh,xm,xb,sfzmhm,qfjg,sfzyxqs,sfzyxqz,yhzgx,mz,csrq,zzmm,whcd,zxsqk,sxhcxyy,jkqk,ldjn,sfhjpth,sfxyjr,sfcjylbx1,sfcjsybx,sfxsdb,sfcjylbx2,sfxsywbxbt,lxdh)
values ('b4aa05cfd980','韦贞英','男','452731196205123035','大化瑶族自治县公安局','2008-12-22','2099-12-31','本人','汉','1962-05-12','团员','高中','无','无','健康','务农','否','否','否','否','否','否','否','18934943219');


drop table ym_family_status;
#贫困家庭基本原因和状况
create table ym_family_status
(
    jtzkbh       int auto_increment primary key comment '家庭状况编号',
    jtbh         varchar(20) comment '家庭编号，对应家庭表',
    zpyy1        varchar(64) comment '致贫原因1（必填）',
    zpyy2        varchar(64) comment '致贫原因2（选填）',
    zpyy3        varchar(64) comment '致贫原因3（选填）',
    ncjtrks      int comment '年初家庭人口数',
    ndjtrks      int comment '年底家庭人口数',
    gdmj         float comment '耕地面积（亩）',
    yxggmj       float comment '有效灌溉面积（亩）',
    ldmj         float comment '林地面积（亩）',
    tghlmj       float comment '退耕还林面积（亩）',
    lgmj         float comment '林果面积（亩）',
    smmj         float comment '水面面积（亩）',
    mcdmj        float comment '牧草地面积（亩）',
    sfyltqydd    char(2) comment '是否有龙头企业带动',
    sfycyzfdtrdd char(2) comment '是否有创业致富带头人带动',
    sftscyd      char(2) comment '是否通生产用电',
    sftshyd      char(2) comment '是否通生活用电',
    sftgbds      char(2) comment '是否通广播电视',
    yssfkn       char(2) comment '饮水是否困难',
    yssfaq       char(2) comment '饮水是否安全',
    zfmj         float comment '住房面积（平方米）',
    ywwscs       char(2) comment '有无卫生厕所',
    sfwfh        char(2) comment '是否危房户',
    wfdj         varchar(10) comment '危房等级',
    wgnd         varchar(10) comment '危改年度',
    zfjg         varchar(32) comment '住房结构',
    sfjrnmzyhzs  char(2) comment '是否加入农民专业合作社',
    yczgljl      float comment '与村主干路距离（公里）',
    rhllx        varchar(20) comment '入户路类型',
    zyrllx       varchar(20) comment '主要燃料类型',
    bgqksm       varchar(256) comment '变更情况说明'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '致贫原因及家庭基本条件表';


drop table ym_produce_income;
#移民贫困人员生产收入情况调查表
create table ym_produce_income(
    ryscsrbh int auto_increment primary key comment '人员生产收入编号',
    jtbh varchar(20) comment '家庭编号，对应家庭表',
    xtdl char(2) comment '类别大类：01为生产经营性收入,02为生产经营支出',
    xtxl1 char(2) comment '类别小类：01为种植业，02为林业，03为养殖业，04为其他',
    xtxl2 char(2) comment '类别小类：01为品种，02为数量，03为金额，04为其他',
    nf  varchar(10) comment '年份',
    yf13 varchar(40) comment '1-3月的收入或者其他信息',
    yf46 varchar(40) comment '4-6月的收入或者其他信息',
    yf79 varchar(40) comment '7-9月的收入或者其他信息',
    yf10 varchar(40) comment '10月的收入或者其他信息',
    yf11 varchar(40) comment '11月的收入或者其他信息',
    yf12 varchar(40) comment '12月的收入或者其他信息'
);

drop table ym_salary_income;
#工资性收入表
create table ym_salary_income(
    rygzsrbh int auto_increment primary key comment '人员工资收入编号',
    jtbh varchar(20) comment '家庭编号，对应家庭表',
    xm varchar(20) comment '姓名',
    wggz varchar(20) comment '务工工种',
    wgdz varchar(60) comment '务工省、市、县',
    wgljsj varchar(10) comment '务工累计时间（月）',
    wgqymc varchar(60) comment '务工企业名称',
    sa_nf  varchar(10) comment '年份',
    sa_yf13 varchar(40) comment '1-3月的收入或者其他信息',
    sa_yf46 varchar(40) comment '4-6月的收入或者其他信息',
    sa_yf79 varchar(40) comment '7-9月的收入或者其他信息',
    sa_yf10 varchar(40) comment '10月的收入或者其他信息',
    sa_yf11 varchar(40) comment '11月的收入或者其他信息',
    sa_yf12 varchar(40) comment '12月的收入或者其他信息'
);

drop table ym_property_income;
#财产收入表
create table ym_property_income(
    pro_bh int auto_increment primary key comment '财产性收入编号',
    jtbh varchar(20) comment '家庭编号，对应家庭表',
    pro_xtlb char(2) comment '财产收入类别：01，财产收益扶贫分红收入，02，其他',
    pro_nf  varchar(10) comment '年份',
    pro_yf13 varchar(40) comment '1-3月的收入或者其他信息',
    pro_yf46 varchar(40) comment '4-6月的收入或者其他信息',
    pro_yf79 varchar(40) comment '7-9月的收入或者其他信息',
    pro_yf10 varchar(40) comment '10月的收入或者其他信息',
    pro_yf11 varchar(40) comment '11月的收入或者其他信息',
    pro_yf12 varchar(40) comment '12月的收入或者其他信息'
);



drop table ym_transfer_income;
#转移性收入表
create table ym_transfer_income(
    tra_bh int auto_increment primary key comment '转移性收入编号',
    jtbh varchar(20) comment '家庭编号，对应家庭表',
    tra_xtlb char(4) comment '转移性财产类别:01，计划生育金；0201，低保金A；0202，低保金B；0203，低保金C；03,特困供养金；04，养老保险金；05，生态补偿金（林业补贴）；06，困难残疾人生活补贴和重度残疾人护理补贴；07，农业补贴；08，高龄补贴；09，水库移民补贴；10，其他长期性的政策性补贴',
    tra_nf  varchar(10) comment '年份',
    tra_yf13 varchar(40) comment '1-3月的收入或者其他信息',
    tra_yf46 varchar(40) comment '4-6月的收入或者其他信息',
    tra_yf79 varchar(40) comment '7-9月的收入或者其他信息',
    tra_yf10 varchar(40) comment '10月的收入或者其他信息',
    tra_yf11 varchar(40) comment '11月的收入或者其他信息',
    tra_yf12 varchar(40) comment '12月的收入或者其他信息'
);


create table ym_out_poverty_income(
    pov_bh int auto_increment primary key comment ''
);




drop table ym_relocate_petition;
#搬迁申请书
create table ym_relocate_petition
(
    sqsbh  int primary key comment '',
    sqr    varchar(32) comment '',
    sfzmhm char(20) comment '',
    xb     char(2) comment '',
    nl     int comment '',
    szs    varchar(10) comment '所在市',
    szx    varchar(20) comment '所在县',
    szc    varchar(20) comment '所在镇',
    szz    varchar(20) comment '所在村',
    szjd   varchar(20) comment '所在街道',
    jtrk   int comment '',
    ldlrs  int comment '',
    zdjbrs int comment '',
    jzsbdf float comment '',
    sslb   char(1) comment '',
    azd    varchar(20) comment '',
    sqrqm  varchar(20) comment '',
    lxdh   varchar(30) comment '',
    txrq   date comment ''
);