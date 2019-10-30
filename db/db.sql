drop table frm_sysuser;
create table frm_sysuser
(
    userId     int auto_increment =1001 primary key comment '用户ID',
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
    cjsj       date comment '创建时间',
    gxsj       date comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户信息表';

insert into frm_sysuser
values ('1000', 'admin', '$2a$10$b7FbBNdjQDgQNbBbn.bCLeEntO6WBm3Ail/zOSJvM7nCTSr/ZBosq', '451229000000', '1',
        '1989-08-09', '', '', '', '', '2020-01-01', '2020-01-01', '1', '', '', '1', now(), now());
drop table frm_role;
create table frm_role
(
    roleId      int auto_increment =1001 primary key comment '角色id',
    roleName    varchar(32) comment '角色名称',
    description varchar(60) comment '描述',
    zt          char(1) comment '角色状态：0代表删除，1代表正常，2代表停用',
    cjsj        date comment '创建时间',
    gxsj        date comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色表';

insert into frm_role
values (1000, '系统管理员', '系统管理员，拥有所有权限', '1', now(), now());

drop table frm_menu;
create table frm_menu
(
    menuId     int primary key comment '菜单id',
    parentId   int not null comment '上级菜单',
    menuName   varchar(32) comment '菜单名称',
    css        varchar(30) comment '图标样式',
    url        varchar(100) comment '图标url',
    type       char(1) COMMENT '菜单类型 1：菜单 2：按钮',
    permission varchar(10) COMMENT '按钮权限 a,d,u,s 分别代表增删改查',
    sequence   int not null comment '排序',
    zt         char(1) comment '菜单状态：0代表删除，1代表正常，2代表停用',
    cjsj       date comment '创建时间',
    gxsj       date comment '更新时间'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '菜单表';

insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (1000, '', '系统管理', 0, '/admin', '1', 'a,d,u,s', 1, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (1001, '', '用户管理', 1000, '/admin/user', '1', 'a,d,u,s', 2, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (1002, '', '部门管理', 1000, '/admin/dept', '1', 'a,d,u,s', 3, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (1003, '', '角色管理', 1000, '/admin/role', '1', 'a,d,u,s', 4, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (1004, '', '权限管理', 1000, '/admin/permit', '1', 'a,d,u,s', 5, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (2000, '', '移民管理', 0, '/ym', '1', 'a,d,u,s', 11, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (2001, '', '移民信息采集', 2000, '/ym/add', '1', 'a,d,u,s', 12, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (2002, '', '移民信息管理', 2000, '/ym/mgr', '1', 'a,d,u,s', 13, '1', now(), now());
insert into frm_menu(menuId, css, menuName, parentId, url, type, permission, sequence, zt, cjsj, gxsj)
values (2003, '', '影像化采集', 2000, '/ym/img', '1', 'a,d,u,s', 14, '1', now(), now());



drop table frm_sysuser_role;
create table frm_sysuser_role
(
    userId int not null,
    roleId int not null,
    primary key (userid, roleid)
) comment '用户与角色关联表';

insert into frm_sysuser_role
values (1000, 1000);

drop table frm_role_menu;
create table frm_role_menu
(
    roleId int not null,
    menuId int not null,
    primary key (roleId, menuId)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '角色-菜单-权限关联表';
insert into frm_role_menu
values (1000, 1000);
insert into frm_role_menu
values (1000, 1001);
insert into frm_role_menu
values (1000, 1002);
insert into frm_role_menu
values (1000, 1003);
insert into frm_role_menu
values (1000, 1004);
insert into frm_role_menu
values (1000, 2000);
insert into frm_role_menu
values (1000, 2001);
insert into frm_role_menu
values (1000, 2002);
insert into frm_role_menu
values (1000, 2003);

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
    jtbh      varchar(20) primary key comment '家庭id',
    szs       varchar(10) comment '所在市',
    szx       varchar(20) comment '所在县',
    szz       varchar(20) comment '所在镇',
    szc       varchar(20) comment '所在村',
    szjd      varchar(20) comment '所在街道',
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

insert into ym_family(jtbh,szs,szx,szc,szz,szjd,lxdh,khyh,yhkh,pkhsx,sfdnytp,jhtpnd,fpnd,fpyy,sfjls,sfydfpbqh,bqfs,bqdz) values
('b4aa05cfd980','河池市','大化县','雅龙乡','竹山村','弄母屯','18200000000','中国农业银行','','','是','2020','2013','受灾','否','否','','');


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
    jtzkbh       int primary key comment '家庭状况编号',
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