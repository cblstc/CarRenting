drop table if exists admin_user;

drop table if exists joins;

drop table if exists orders;

drop table if exists orders_comment;

drop table if exists store;

drop table if exists store_car;

drop table if exists store_comment;

drop table if exists store_user;

drop table if exists user;

drop table if exists user_info;

/*==============================================================*/
/* Table: admin_user                                            */
/*==============================================================*/
create table admin_user
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   password             char(32) not null,
   role                 int not null,
   status               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: joins                                                 */
/*==============================================================*/
create table joins
(
   id                   int not null auto_increment,
   store_user_id        int,
   company              varchar(50) not null,
   name                 varchar(20) not null,
   phone                char(11) not null,
   email                varchar(50) not null,
   note                 varchar(100) not null,
   status               int,
   primary key (id)
);

/*==============================================================*/
/* Table: orders                                                */
/*==============================================================*/
create table orders
(
   id                   varchar(32) not null,
   store_car_id         int,
   price                float not null,
   insurance            float not null,
   nodeductibles        float,
   totalMoney           float not null,
   getTime              datetime not null,
   returnTime           datetime not null,
   time                 datetime not null,
   status               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: orders_comment                                        */
/*==============================================================*/
create table orders_comment
(
   id                   int not null auto_increment,
   orders_id            varchar(32),
   user_id              int,
   content              varchar(200),
   star                 int not null,
   time                 datetime not null,
   primary key (id)
);

/*==============================================================*/
/* Table: store                                                 */
/*==============================================================*/
create table store
(
   id                   int not null auto_increment,
   store_user_id        int,
   storename            varchar(50) not null,
   phone                varchar(50) not null,
   startTime            datetime not null,
   endTime              datetime not null,
   address              varchar(100) not null,
   longitude            float not null,
   latitude             float not null,
   description          varchar(200),
   traffic              varchar(200),
   totalStar            int not null,
   totalComment         int not null,
   avgStar              float not null,
   status               int not null,
   primary key (id)
);

alter table store comment '门店';

/*==============================================================*/
/* Table: store_car                                             */
/*==============================================================*/
create table store_car
(
   id                   int not null auto_increment,
   store_id             int,
   brand                varchar(100) not null,
   model                varchar(100) not null,
   configuration        varchar(100),
   carPhoto             text,
   seats                int not null,
   doors                int not null,
   displacement         varchar(10) not null,
   navigator            int not null,
   pdc                  int not null,
   drivenMode           int not null,
   fuelTankage          int not null,
   gearbox              int not null,
   skylight             int not null,
   aircell              int not null,
   price                float not null,
   insurance            float not null,
   nodeductibles        float not null,
   count                int not null,
   status               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: store_comment                                         */
/*==============================================================*/
create table store_comment
(
   id                   int not null auto_increment,
   user_id              int,
   store_id             int,
   content              varchar(200) not null,
   star                 int not null,
   time                 datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: store_user                                            */
/*==============================================================*/
create table store_user
(
   id                   int not null auto_increment,
   username             varchar(20) not null,
   password             char(32) not null,
   status               int not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   phone                varchar(50) not null,
   username             varchar(20),
   password             char(32) not null,
   email                varchar(50),
   role                 int not null,
   registTime           datetime not null,
   status               int not null,
   primary key (id)
);

alter table user comment '用户登录信息
';

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   id                   int not null auto_increment,
   user_id              int,
   name                 varchar(20) not null,
   sex                  int not null,
   idcard               char(18) not null,
   photo                varchar(100),
   idcardPhoto          varchar(100),
   licencePhoto         varchar(100),
   licenceVicePhoto     varchar(100),
   primary key (id)
);

alter table user_info comment '用户认证信息，比如身份证、驾驶证等';

alter table joins add constraint FK_Relationship_10 foreign key (store_user_id)
      references store_user (id) on delete restrict on update restrict;

alter table orders add constraint FK_Relationship_17 foreign key (store_car_id)
      references store_car (id) on delete restrict on update restrict;

alter table orders_comment add constraint FK_Relationship_12 foreign key (orders_id)
      references orders (id) on delete restrict on update restrict;

alter table orders_comment add constraint FK_Relationship_9 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table store add constraint FK_Relationship_8 foreign key (store_user_id)
      references store_user (id) on delete restrict on update restrict;

alter table store_car add constraint FK_Relationship_6 foreign key (store_id)
      references store (id) on delete restrict on update restrict;

alter table store_comment add constraint FK_Relationship_18 foreign key (user_id)
      references user (id) on delete restrict on update restrict;

alter table store_comment add constraint FK_Relationship_19 foreign key (store_id)
      references store (id) on delete restrict on update restrict;

alter table user_info add constraint FK_Relationship_1 foreign key (user_id)
      references user (id) on delete restrict on update restrict;
