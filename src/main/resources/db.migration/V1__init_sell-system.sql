create table commodities
(
    id          varchar(50)  not null comment '商品ID'
        primary key,
    name        varchar(50)  not null comment '水果名称',
    price       double       not null comment '价格',
    locality    varchar(100) not null comment '产地',
    create_time datetime     not null comment '录单时间'
)
    comment '水果商品信息表';

create table accessory
(
    id             varchar(50) not null comment '附属品ID'
        primary key,
    commodities_id varchar(50) not null comment '商品ID',
    name           varchar(50) not null comment '附属品名称',
    price          varchar(50) not null comment '价格',
    create_time    datetime    not null comment '创建时间',
    constraint accessory_commodities_id_fk
        foreign key (commodities_id) references commodities (id)
)
    comment '附属品信息表';

create table retailer
(
    id          varchar(50)  not null comment '零售商ID'
        primary key,
    name        varchar(50)  not null comment '零售商姓名',
    telephone   varchar(50)  not null comment '零售商电话',
    address     varchar(100) not null comment '零售商地址',
    status      int          not null comment '状态(0:停用,1:启用)',
    create_time datetime     not null comment '创建时间'
)
    comment '零售商信息表';

create table contract
(
    id          varchar(50) not null comment '合同ID'
        primary key,
    barcode     varchar(50) not null comment '合同号',
    type        int         not null comment '运输类型(1:省内,2:省外)',
    retailer_id varchar(50) not null comment '零售商ID',
    create_time datetime    not null comment '创建时间',
    constraint contract_retailer_id_fk
        foreign key (retailer_id) references retailer (id)
)
    comment '采购合同表';

create table middle_tab
(
    id             varchar(50) not null comment '中间表ID'
        primary key,
    contract_id    varchar(50) not null comment '合同ID',
    commodities_id varchar(50) not null comment '商品ID',
    number         int         not null comment '商品数量',
    constraint middle_tab_commodities_id_fk
        foreign key (commodities_id) references commodities (id),
    constraint middle_tab_contract_id_fk
        foreign key (contract_id) references contract (id)
)
    comment '中间表';

create table user
(
    id        varchar(50)  not null comment '用户ID'
        primary key,
    username  varchar(50)  not null comment '账号',
    password  varchar(255) not null comment '密码',
    name      varchar(50)  not null comment '姓名',
    telephone varchar(20)  not null comment '手机号'
)
    comment '用户表';

