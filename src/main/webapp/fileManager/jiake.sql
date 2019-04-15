-------------------------------------------
-- Export file for user JIAKE            --
-- Created by boco on 2017/7/7, 17:40:03 --
-------------------------------------------

set define off
spool jiake.log

prompt
prompt Creating table INDICATORS
prompt =========================
prompt
create table JIAKE.INDICATORS
(
  id                     VARCHAR2(32) not null,
  name                   VARCHAR2(1000),
  item                   VARCHAR2(1000),
  is_city                VARCHAR2(32),
  is_maintain            VARCHAR2(32),
  is_grid                VARCHAR2(32),
  particle_dimension     VARCHAR2(100),
  line_basic             NUMBER,
  line_challenge         NUMBER,
  collecttime            DATE,
  legal_min              NUMBER,
  legal_max              NUMBER,
  suanfa                 NVARCHAR2(200),
  professional_dimension VARCHAR2(100),
  audience_dimesion      VARCHAR2(100),
  service_dimension      VARCHAR2(100),
  datesource_type        VARCHAR2(100),
  datesource             VARCHAR2(100),
  persion_in_charge      VARCHAR2(100),
  interface_type         VARCHAR2(10),
  model_show             VARCHAR2(1000),
  model_import           VARCHAR2(1000),
  relation_index         VARCHAR2(1000),
  unit                   VARCHAR2(10),
  indicators_type        VARCHAR2(32),
  remark                 VARCHAR2(2000),
  identifier             VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column JIAKE.INDICATORS.id
  is 'id';
comment on column JIAKE.INDICATORS.name
  is '名称';
comment on column JIAKE.INDICATORS.is_city
  is '是否分属地';
comment on column JIAKE.INDICATORS.is_maintain
  is '是否分维护部';
comment on column JIAKE.INDICATORS.is_grid
  is '是否分网格';
comment on column JIAKE.INDICATORS.particle_dimension
  is '周期维度：day,week,month,quarter';
comment on column JIAKE.INDICATORS.line_basic
  is '挑战值';
comment on column JIAKE.INDICATORS.line_challenge
  is '基本值';
comment on column JIAKE.INDICATORS.collecttime
  is '轮询时间';
comment on column JIAKE.INDICATORS.legal_min
  is '合法最大值';
comment on column JIAKE.INDICATORS.legal_max
  is '合法最小值';
comment on column JIAKE.INDICATORS.suanfa
  is '算法';
comment on column JIAKE.INDICATORS.professional_dimension
  is '专业维度';
comment on column JIAKE.INDICATORS.audience_dimesion
  is '受众维度';
comment on column JIAKE.INDICATORS.service_dimension
  is '业务维度';
comment on column JIAKE.INDICATORS.datesource_type
  is '数据源类型:人工|接口|系统|本地excel。man,interface,system,local';
comment on column JIAKE.INDICATORS.datesource
  is '数据源：系统-模块-数据表';
comment on column JIAKE.INDICATORS.persion_in_charge
  is '负责人';
comment on column JIAKE.INDICATORS.interface_type
  is '接口类型:WS|DB|excel';
comment on column JIAKE.INDICATORS.model_show
  is '展示模板';
comment on column JIAKE.INDICATORS.model_import
  is '导出模板';
comment on column JIAKE.INDICATORS.relation_index
  is '相关指标';
comment on column JIAKE.INDICATORS.unit
  is '单位';
comment on column JIAKE.INDICATORS.indicators_type
  is '指标分类id';
comment on column JIAKE.INDICATORS.remark
  is '备注';
comment on column JIAKE.INDICATORS.identifier
  is '指标编号';
alter table JIAKE.INDICATORS
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_CUSTOM_CHART
prompt ======================================
prompt
create table JIAKE.INDICATORS_CUSTOM_CHART
(
  id               VARCHAR2(32) not null,
  custom_page_id   VARCHAR2(32),
  name             VARCHAR2(500),
  swf_type         VARCHAR2(10),
  particle_type    VARCHAR2(10),
  chart_type       VARCHAR2(10),
  selectable_index VARCHAR2(2000),
  is_deleted       CHAR(1),
  custom_view_id   VARCHAR2(32),
  orders           NUMBER
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table JIAKE.INDICATORS_CUSTOM_CHART
  is '数据表4';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.id
  is '主键';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.custom_page_id
  is '定制页面id';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.name
  is '名称';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.swf_type
  is '展现类型';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.particle_type
  is '粒度周期';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.chart_type
  is '图标类型';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.selectable_index
  is '选中的指标';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.is_deleted
  is '是否已经删除';
comment on column JIAKE.INDICATORS_CUSTOM_CHART.custom_view_id
  is '定制视图id';
alter table JIAKE.INDICATORS_CUSTOM_CHART
  add constraint PK_INDICATORART_ID primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_CUSTOM_PAGE
prompt =====================================
prompt
create table JIAKE.INDICATORS_CUSTOM_PAGE
(
  id             VARCHAR2(32) not null,
  page_width     VARCHAR2(10),
  page_height    VARCHAR2(10),
  page_type      VARCHAR2(20),
  custom_view_id VARCHAR2(4000),
  is_deleted     CHAR(1),
  orders         NUMBER
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table JIAKE.INDICATORS_CUSTOM_PAGE
  is '数据表3';
comment on column JIAKE.INDICATORS_CUSTOM_PAGE.id
  is '编号';
comment on column JIAKE.INDICATORS_CUSTOM_PAGE.page_width
  is '页面宽度';
comment on column JIAKE.INDICATORS_CUSTOM_PAGE.page_height
  is '页面高度';
comment on column JIAKE.INDICATORS_CUSTOM_PAGE.page_type
  is '页面类型';
comment on column JIAKE.INDICATORS_CUSTOM_PAGE.custom_view_id
  is '所属视图id';
comment on column JIAKE.INDICATORS_CUSTOM_PAGE.is_deleted
  is '是否已经删除';
alter table JIAKE.INDICATORS_CUSTOM_PAGE
  add constraint PK_INDICATORAGE_ID primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_CUSTOM_VIEW
prompt =====================================
prompt
create table JIAKE.INDICATORS_CUSTOM_VIEW
(
  id          VARCHAR2(32) not null,
  name        VARCHAR2(500),
  create_time DATE,
  is_deleted  CHAR(1) default 0
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table JIAKE.INDICATORS_CUSTOM_VIEW
  is '数据表3';
comment on column JIAKE.INDICATORS_CUSTOM_VIEW.id
  is '编号';
comment on column JIAKE.INDICATORS_CUSTOM_VIEW.name
  is '名称';
comment on column JIAKE.INDICATORS_CUSTOM_VIEW.create_time
  is '创建时间';
comment on column JIAKE.INDICATORS_CUSTOM_VIEW.is_deleted
  is '是否已经删除';
alter table JIAKE.INDICATORS_CUSTOM_VIEW
  add constraint PK_INDICATORIEW_ID primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_DAY_STATISTICS
prompt ========================================
prompt
create table JIAKE.INDICATORS_DAY_STATISTICS
(
  id       VARCHAR2(36),
  item     VARCHAR2(1000) not null,
  area     VARCHAR2(100) not null,
  areatype VARCHAR2(100),
  year     NUMBER not null,
  month    NUMBER not null,
  set1     NUMBER default 0,
  set2     NUMBER default 0,
  set3     NUMBER default 0,
  set4     NUMBER default 0,
  set5     NUMBER default 0,
  set6     NUMBER default 0,
  set7     NUMBER default 0,
  set8     NUMBER default 0,
  set9     NUMBER default 0,
  set10    NUMBER default 0,
  set11    NUMBER default 0,
  set12    NUMBER default 0,
  set13    NUMBER default 0,
  set14    NUMBER default 0,
  set15    NUMBER default 0,
  set16    NUMBER default 0,
  set17    NUMBER default 0,
  set18    NUMBER default 0,
  set19    NUMBER default 0,
  set20    NUMBER default 0,
  set21    NUMBER default 0,
  set22    NUMBER default 0,
  set23    NUMBER default 0,
  set24    NUMBER default 0,
  set25    NUMBER default 0,
  set26    NUMBER default 0,
  set27    NUMBER default 0,
  set28    NUMBER default 0,
  set29    NUMBER default 0,
  set30    NUMBER default 0,
  set31    NUMBER default 0
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_MONTH_STATISTICS
prompt ==========================================
prompt
create table JIAKE.INDICATORS_MONTH_STATISTICS
(
  id       VARCHAR2(36),
  item     VARCHAR2(1000) not null,
  area     VARCHAR2(100) not null,
  areatype VARCHAR2(100),
  year     NUMBER not null,
  set1     NUMBER default 0,
  set2     NUMBER default 0,
  set3     NUMBER default 0,
  set4     NUMBER default 0,
  set5     NUMBER default 0,
  set6     NUMBER default 0,
  set7     NUMBER default 0,
  set8     NUMBER default 0,
  set9     NUMBER default 0,
  set10    NUMBER default 0,
  set11    NUMBER default 0,
  set12    NUMBER default 0
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_ORIGINAL
prompt ==================================
prompt
create table JIAKE.INDICATORS_ORIGINAL
(
  id         VARCHAR2(36) not null,
  item       VARCHAR2(1000) not null,
  area       VARCHAR2(100) not null,
  areatype   VARCHAR2(100),
  value      NUMBER not null,
  year       VARCHAR2(32) not null,
  month      VARCHAR2(32) not null,
  day        VARCHAR2(32) not null,
  week       VARCHAR2(32),
  quarter    VARCHAR2(32),
  timetype   VARCHAR2(100) not null,
  createtime DATE,
  filename   VARCHAR2(1000),
  datatime   DATE not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column JIAKE.INDICATORS_ORIGINAL.areatype
  is 'city,maintain,grid';

prompt
prompt Creating table INDICATORS_QUARTER_STATISTICS
prompt ============================================
prompt
create table JIAKE.INDICATORS_QUARTER_STATISTICS
(
  id       VARCHAR2(36) not null,
  item     VARCHAR2(1000) not null,
  area     VARCHAR2(100) not null,
  areatype VARCHAR2(100),
  year     NUMBER not null,
  set1     NUMBER default 0,
  set2     NUMBER default 0,
  set3     NUMBER default 0,
  set4     NUMBER default 0
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_TYPE
prompt ==============================
prompt
create table JIAKE.INDICATORS_TYPE
(
  id       VARCHAR2(32) not null,
  name     VARCHAR2(100),
  pid      VARCHAR2(32),
  isparent VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.INDICATORS_TYPE
  add constraint INDICATORS_TYPE primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_VS_ROLE
prompt =================================
prompt
create table JIAKE.INDICATORS_VS_ROLE
(
  id      VARCHAR2(32) not null,
  role_id VARCHAR2(32) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.INDICATORS_VS_ROLE
  add constraint PK_INDICATORS_VS_ROLE primary key (ID, ROLE_ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATORS_WEEK_STATISTICS
prompt =========================================
prompt
create table JIAKE.INDICATORS_WEEK_STATISTICS
(
  id       VARCHAR2(36) not null,
  item     VARCHAR2(1000) not null,
  area     VARCHAR2(100) not null,
  areatype VARCHAR2(100),
  year     NUMBER not null,
  month    NUMBER not null,
  set1     NUMBER default 0,
  set2     NUMBER default 0,
  set3     NUMBER default 0,
  set4     NUMBER default 0,
  set5     NUMBER default 0
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATOR_ACCESS_LOG
prompt ===================================
prompt
create table JIAKE.INDICATOR_ACCESS_LOG
(
  id              VARCHAR2(32) not null,
  user_id         VARCHAR2(64),
  dept            VARCHAR2(64),
  access_date     DATE,
  indicators_id   VARCHAR2(64),
  indicators_name VARCHAR2(64)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.INDICATOR_ACCESS_LOG
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATOR_DATAFLAG_REPORT
prompt ========================================
prompt
create table JIAKE.INDICATOR_DATAFLAG_REPORT
(
  id           VARCHAR2(36) not null,
  create_time  TIMESTAMP(6),
  yesnum       NUMBER not null,
  nonum        NUMBER not null,
  starttime    VARCHAR2(32),
  endtime      VARCHAR2(32),
  illegal_type VARCHAR2(1)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATOR_HISTORY_COMPUTE
prompt ========================================
prompt
create table JIAKE.INDICATOR_HISTORY_COMPUTE
(
  id            VARCHAR2(32) not null,
  index_type_id VARCHAR2(32),
  suanfa        VARCHAR2(32),
  create_time   DATE
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.INDICATOR_HISTORY_COMPUTE
  add constraint INDICATOR_HISTORY_COMPUTE_ID primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INDICATOR_NODATA
prompt ===============================
prompt
create table JIAKE.INDICATOR_NODATA
(
  id          VARCHAR2(32),
  time        VARCHAR2(32),
  name        VARCHAR2(100),
  area        VARCHAR2(1000),
  areatype    VARCHAR2(100),
  value       NUMBER,
  year        VARCHAR2(4),
  month       VARCHAR2(4),
  day         VARCHAR2(4),
  week        VARCHAR2(4),
  quarter     VARCHAR2(4),
  timetype    VARCHAR2(100),
  filename    VARCHAR2(1000),
  legal_min   NUMBER,
  legal_max   NUMBER,
  dataflag_id VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255;

prompt
prompt Creating table INFOPUB_AUDITROLE
prompt ================================
prompt
create table JIAKE.INFOPUB_AUDITROLE
(
  id        VARCHAR2(32) not null,
  roleid    VARCHAR2(50) not null,
  rolename  VARCHAR2(50) not null,
  speciesid VARCHAR2(32) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_CTPROPERTY
prompt =================================
prompt
create table JIAKE.INFOPUB_CTPROPERTY
(
  id            VARCHAR2(32) not null,
  species_id    VARCHAR2(32),
  property_name VARCHAR2(500),
  property_type VARCHAR2(10)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_ITEM
prompt ===========================
prompt
create table JIAKE.INFOPUB_ITEM
(
  id           VARCHAR2(32) not null,
  title        VARCHAR2(200) not null,
  content      VARCHAR2(4000),
  createuser   VARCHAR2(50) not null,
  createtime   VARCHAR2(100) not null,
  speciesid    VARCHAR2(32) not null,
  ranktype     CHAR(200) not null,
  alivedate    VARCHAR2(100),
  deleted      CHAR(1) not null,
  readstatus   VARCHAR2(4000),
  readdept     VARCHAR2(4000),
  readuser     VARCHAR2(4000),
  readalldept  VARCHAR2(4000),
  ifaudit      VARCHAR2(1),
  nopassreason VARCHAR2(4000),
  downstatus   VARCHAR2(4000),
  message      VARCHAR2(1)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_ITEM_PROPERTY
prompt ====================================
prompt
create table JIAKE.INFOPUB_ITEM_PROPERTY
(
  item_id        VARCHAR2(32),
  property_id    VARCHAR2(32),
  property_name  VARCHAR2(500),
  property_value VARCHAR2(4000),
  id             VARCHAR2(32),
  create_time    DATE
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 384K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_ITEM_ROLE
prompt ================================
prompt
create table JIAKE.INFOPUB_ITEM_ROLE
(
  id       VARCHAR2(32) not null,
  roleid   VARCHAR2(50) not null,
  rolename VARCHAR2(255) not null,
  itemid   VARCHAR2(32) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_SPECIES
prompt ==============================
prompt
create table JIAKE.INFOPUB_SPECIES
(
  id         VARCHAR2(32) not null,
  name       VARCHAR2(50) not null,
  createuser VARCHAR2(50),
  createtime VARCHAR2(32) not null,
  parentid   VARCHAR2(32) not null,
  deleted    CHAR(1) not null,
  describe   VARCHAR2(200),
  alldept    VARCHAR2(400)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_SPECIES_ROLE
prompt ===================================
prompt
create table JIAKE.INFOPUB_SPECIES_ROLE
(
  id        VARCHAR2(32) not null,
  roleid    VARCHAR2(50) not null,
  rolename  VARCHAR2(255) not null,
  speciesid VARCHAR2(32) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INFOPUB_VIEWROLE
prompt ===============================
prompt
create table JIAKE.INFOPUB_VIEWROLE
(
  id        VARCHAR2(32) not null,
  roleid    VARCHAR2(50) not null,
  rolename  VARCHAR2(50) not null,
  speciesid VARCHAR2(32) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table INTERFACE_ACCESS_LOG
prompt ===================================
prompt
create table JIAKE.INTERFACE_ACCESS_LOG
(
  id            VARCHAR2(32) not null,
  user_id       VARCHAR2(64),
  dept          VARCHAR2(64),
  access_class  VARCHAR2(128),
  access_method VARCHAR2(32),
  access_date   DATE,
  detail        VARCHAR2(256),
  result        VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.INTERFACE_ACCESS_LOG
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_APPCLICK_LOG
prompt =================================
prompt
create table JIAKE.JIAKE_APPCLICK_LOG
(
  id         VARCHAR2(36) not null,
  app_id     VARCHAR2(36) not null,
  app_name   VARCHAR2(64) not null,
  click_time DATE not null,
  click_user VARCHAR2(64) not null,
  dept_name  VARCHAR2(30),
  app_status VARCHAR2(30)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.JIAKE_APPCLICK_LOG
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_MENU
prompt =========================
prompt
create table JIAKE.JIAKE_MENU
(
  id          VARCHAR2(32) not null,
  in_url      VARCHAR2(500) not null,
  out_url     VARCHAR2(500) not null,
  name        VARCHAR2(100) not null,
  app_id      VARCHAR2(32) not null,
  create_time DATE,
  create_user VARCHAR2(100),
  type        VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_MENUCLICK_LOG
prompt ==================================
prompt
create table JIAKE.JIAKE_MENUCLICK_LOG
(
  id         VARCHAR2(36) not null,
  menu_id    VARCHAR2(36) not null,
  menu_name  VARCHAR2(64) not null,
  click_time DATE not null,
  click_user VARCHAR2(64) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.JIAKE_MENUCLICK_LOG
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_MENU_ROLE
prompt ==============================
prompt
create table JIAKE.JIAKE_MENU_ROLE
(
  id        VARCHAR2(32) not null,
  menu_id   VARCHAR2(32) not null,
  menu_name VARCHAR2(100) not null,
  role_id   VARCHAR2(500) not null,
  role_name VARCHAR2(500) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_REPORTFORM
prompt ===============================
prompt
create table JIAKE.JIAKE_REPORTFORM
(
  id              VARCHAR2(32) not null,
  name            VARCHAR2(32) not null,
  createtime      VARCHAR2(32),
  dimension       VARCHAR2(32),
  statistfromdate VARCHAR2(32),
  statisttodate   VARCHAR2(32),
  area            VARCHAR2(256),
  indicators      VARCHAR2(256)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.JIAKE_REPORTFORM
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_REPORTFORM_ROLE
prompt ====================================
prompt
create table JIAKE.JIAKE_REPORTFORM_ROLE
(
  id           VARCHAR2(32) not null,
  reportformid VARCHAR2(32) not null,
  roleid       VARCHAR2(32) not null,
  rolename     VARCHAR2(255)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.JIAKE_REPORTFORM_ROLE
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table JIAKE_UNDO
prompt =========================
prompt
create table JIAKE.JIAKE_UNDO
(
  id            VARCHAR2(32) not null,
  undo_id       VARCHAR2(32) not null,
  undo_name     VARCHAR2(32) not null,
  source_system VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column JIAKE.JIAKE_UNDO.undo_id
  is '工单类型编号';
comment on column JIAKE.JIAKE_UNDO.undo_name
  is '工单类型名称';
comment on column JIAKE.JIAKE_UNDO.source_system
  is '来源系统';

prompt
prompt Creating table JIAKE_UNDO_CUSTOM
prompt ================================
prompt
create table JIAKE.JIAKE_UNDO_CUSTOM
(
  id        VARCHAR2(32) not null,
  undo_id   VARCHAR2(32) not null,
  undo_name VARCHAR2(32) not null,
  user_id   VARCHAR2(32) not null,
  user_name VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column JIAKE.JIAKE_UNDO_CUSTOM.undo_id
  is '工单类型编号';
comment on column JIAKE.JIAKE_UNDO_CUSTOM.undo_name
  is '工单类型名称';
comment on column JIAKE.JIAKE_UNDO_CUSTOM.user_id
  is '用户id';
comment on column JIAKE.JIAKE_UNDO_CUSTOM.user_name
  is '用户名称';

prompt
prompt Creating table LOGIN_LOGS
prompt =========================
prompt
create table JIAKE.LOGIN_LOGS
(
  id          VARCHAR2(64) not null,
  userid      VARCHAR2(64),
  username    VARCHAR2(64),
  user_ip     VARCHAR2(64),
  area        VARCHAR2(64),
  department  VARCHAR2(64),
  login_time  VARCHAR2(128),
  logout_time VARCHAR2(128),
  attribute1  VARCHAR2(256),
  attribute2  VARCHAR2(256),
  attribute3  VARCHAR2(256)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.LOGIN_LOGS
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_ATTACH
prompt ============================
prompt
create table JIAKE.PORTAL_ATTACH
(
  id        VARCHAR2(32) not null,
  item_id   VARCHAR2(50),
  file_name VARCHAR2(200),
  path      VARCHAR2(200)
)
tablespace SYSTEM
  pctfree 10
  pctused 40
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_ATTACH
  add primary key (ID)
  using index 
  tablespace SYSTEM
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CAROUSEL_IMAGES
prompt =====================================
prompt
create table JIAKE.PORTAL_CAROUSEL_IMAGES
(
  id         VARCHAR2(32) not null,
  http_url   VARCHAR2(256),
  orderno    NUMBER(11),
  image_url  VARCHAR2(100),
  image_name VARCHAR2(32),
  title      VARCHAR2(32),
  status     VARCHAR2(1)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_CAROUSEL_IMAGES
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_APP
prompt ===================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_APP
(
  id              VARCHAR2(50) not null,
  createtime      VARCHAR2(50),
  systemname      VARCHAR2(50),
  specialty       VARCHAR2(50),
  apptag          VARCHAR2(200),
  appurlin        VARCHAR2(500),
  appicon         VARCHAR2(200),
  appmold         NUMBER,
  openmode        NUMBER,
  integrator      VARCHAR2(50),
  supportno       VARCHAR2(50),
  appsize         NUMBER,
  appnote         VARCHAR2(500),
  ifpush          NUMBER,
  pushtime        DATE,
  isspecialtymust VARCHAR2(1),
  appcode         VARCHAR2(32),
  appaverage      VARCHAR2(10) default '0',
  isaudit         VARCHAR2(2),
  createuser      VARCHAR2(32),
  appurlout       VARCHAR2(500),
  typeid          VARCHAR2(32),
  appname         VARCHAR2(100),
  parentid        VARCHAR2(5),
  describe        BLOB,
  hasmenu         NUMBER default 0,
  sourcesystem    VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_CUSTOMIZE_APP
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_COMMENT
prompt =======================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_COMMENT
(
  id       CHAR(32) not null,
  appid    VARCHAR2(32) not null,
  userid   VARCHAR2(32),
  username VARCHAR2(100),
  content  VARCHAR2(500),
  starnum  VARCHAR2(1),
  score    VARCHAR2(2),
  time     VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column JIAKE.PORTAL_CUSTOMIZE_COMMENT.id
  is '主键id';
comment on column JIAKE.PORTAL_CUSTOMIZE_COMMENT.appid
  is '应用id';
comment on column JIAKE.PORTAL_CUSTOMIZE_COMMENT.userid
  is '用户userId';
comment on column JIAKE.PORTAL_CUSTOMIZE_COMMENT.username
  is '用户名称';
comment on column JIAKE.PORTAL_CUSTOMIZE_COMMENT.content
  is '评论内容';
comment on column JIAKE.PORTAL_CUSTOMIZE_COMMENT.time
  is '评价时间';
alter table JIAKE.PORTAL_CUSTOMIZE_COMMENT
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_GROUP
prompt =====================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_GROUP
(
  id            VARCHAR2(50) not null,
  groupname     VARCHAR2(100),
  userid        VARCHAR2(50),
  deleted       VARCHAR2(2),
  parentgroupid VARCHAR2(50),
  apptype       VARCHAR2(5)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_CUSTOMIZE_GROUP
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_ROLE
prompt ====================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_ROLE
(
  id       CHAR(32) not null,
  appid    VARCHAR2(50) not null,
  appname  VARCHAR2(50),
  roleid   VARCHAR2(32),
  rolename VARCHAR2(100)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_CUSTOMIZE_ROLE
  add constraint PK_PORTAL_CUSTOMIZE_ROLE primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_STA
prompt ===================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_STA
(
  appid    VARCHAR2(50) not null,
  appname  VARCHAR2(50),
  appcount NUMBER
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_CUSTOMIZE_STA
  add constraint PK_PORTAL_CUSTOMIZE_STA primary key (APPID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_TYPE
prompt ====================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_TYPE
(
  id         VARCHAR2(32) not null,
  name       VARCHAR2(100),
  parentid   VARCHAR2(32),
  parentname VARCHAR2(64),
  describe   VARCHAR2(500),
  comments   VARCHAR2(500),
  createtime VARCHAR2(20)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_CUSTOMIZE_TYPE
  add constraint PK_PORTAL_CUSTOMIZE_TYPE primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_CUSTOMIZE_USER
prompt ====================================
prompt
create table JIAKE.PORTAL_CUSTOMIZE_USER
(
  id            CHAR(32) not null,
  userid        VARCHAR2(50) not null,
  username      VARCHAR2(50),
  appid         CHAR(32) not null,
  appname       VARCHAR2(50),
  addtime       TIMESTAMP(6),
  location      NUMBER,
  pageid        CHAR(32),
  usertypeid    VARCHAR2(32),
  formenupage   VARCHAR2(10),
  position      NUMBER(3),
  parentgroupid VARCHAR2(50),
  apptypeflag   VARCHAR2(5)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column JIAKE.PORTAL_CUSTOMIZE_USER.formenupage
  is '鏄惁鏄椤靛畾鍒? 鏄? 1  涓嶆槸 0';
alter table JIAKE.PORTAL_CUSTOMIZE_USER
  add constraint PK_PORTAL_CUSTOMIZE_USER primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_LDAP_USER
prompt ===============================
prompt
create table JIAKE.PORTAL_LDAP_USER
(
  userid   VARCHAR2(200) not null,
  username VARCHAR2(200) not null,
  areaname VARCHAR2(200),
  deptname VARCHAR2(200),
  mobile   VARCHAR2(200),
  email    VARCHAR2(200)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_REPORT_CUSTOM
prompt ===================================
prompt
create table JIAKE.PORTAL_REPORT_CUSTOM
(
  id          VARCHAR2(32) not null,
  index_ids   VARCHAR2(300),
  tab_name    VARCHAR2(100),
  tab_order   VARCHAR2(2),
  chart_type  VARCHAR2(32),
  create_time DATE
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255;
alter table JIAKE.PORTAL_REPORT_CUSTOM
  add constraint PORTAL_REPORT_CUSTOM_ID primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_SYSTEM_AREA
prompt =================================
prompt
create table JIAKE.PORTAL_SYSTEM_AREA
(
  id           VARCHAR2(32) not null,
  areaid       VARCHAR2(254),
  areaname     VARCHAR2(100),
  leaf         INTEGER,
  remark       VARCHAR2(254),
  parentareaid VARCHAR2(254),
  ordercode    INTEGER,
  areacode     VARCHAR2(32),
  capital      VARCHAR2(32)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_SYSTEM_AREA
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_SYSTEM_AREA_USER
prompt ======================================
prompt
create table JIAKE.PORTAL_SYSTEM_AREA_USER
(
  id          VARCHAR2(32) not null,
  area_id     VARCHAR2(32),
  user_id     VARCHAR2(32),
  area_name   VARCHAR2(255),
  user_name   VARCHAR2(32),
  create_time DATE
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_SYSTEM_AREA_USER
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_SYSTEM_DEPT
prompt =================================
prompt
create table JIAKE.PORTAL_SYSTEM_DEPT
(
  deptid            VARCHAR2(32) not null,
  deleted           VARCHAR2(10) default 0,
  deptemail         VARCHAR2(100),
  deptfax           VARCHAR2(100),
  deptmanager       VARCHAR2(100),
  deptmobile        VARCHAR2(100),
  deptname          VARCHAR2(100),
  deptphone         VARCHAR2(100),
  depttype          VARCHAR2(100),
  operremoteip      VARCHAR2(100),
  opertime          VARCHAR2(100),
  operuser          VARCHAR2(100),
  ordercode         NUMBER default 0,
  parentdeptid      VARCHAR2(32),
  regionflag        NUMBER default 0,
  remark            VARCHAR2(100),
  tmporarybegintime VARCHAR2(50),
  tmporarymanager   VARCHAR2(100),
  tmporarystoptime  VARCHAR2(100),
  updatetime        VARCHAR2(100),
  leaf              VARCHAR2(10),
  area              VARCHAR2(100),
  linkid            VARCHAR2(100),
  tmpdeptid         VARCHAR2(50),
  ispartners        VARCHAR2(100),
  isdaiweiroot      VARCHAR2(10),
  parentlinkid      VARCHAR2(100),
  centerid          VARCHAR2(200),
  centername        VARCHAR2(200)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_SYSTEM_DEPT
  add constraint ADMIN primary key (DEPTID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_SYSTEM_ROLE
prompt =================================
prompt
create table JIAKE.PORTAL_SYSTEM_ROLE
(
  id                NUMBER not null,
  deleted           VARCHAR2(10),
  role_name         VARCHAR2(255),
  naruralname       VARCHAR2(255),
  description       VARCHAR2(255),
  role_id           VARCHAR2(64),
  belongingness     VARCHAR2(255),
  role_type         VARCHAR2(64),
  role_class        VARCHAR2(64),
  system_id         VARCHAR2(32),
  create_time       DATE,
  update_time       DATE,
  professional_id   VARCHAR2(64),
  professional_name VARCHAR2(64)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table JIAKE.PORTAL_SYSTEM_ROLE
  is '系统中角色管理表';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.id
  is '记录id';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.deleted
  is '删除标识';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.role_name
  is '角色名称';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.naruralname
  is '角色名称，查询AD以这个为准';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.description
  is '角色描述';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.role_id
  is '角色ID';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.belongingness
  is '角色在AD的OU';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.role_type
  is '角色属性';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.role_class
  is '角色类型';
comment on column JIAKE.PORTAL_SYSTEM_ROLE.system_id
  is '系统ID';

prompt
prompt Creating table PORTAL_SYSTEM_ROLE_USER
prompt ======================================
prompt
create table JIAKE.PORTAL_SYSTEM_ROLE_USER
(
  id          VARCHAR2(32) not null,
  role_id     VARCHAR2(32),
  user_id     VARCHAR2(32),
  role_name   VARCHAR2(255),
  user_name   VARCHAR2(32),
  create_time DATE
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table JIAKE.PORTAL_SYSTEM_ROLE_USER
  is '系统中地区用户对应表';
comment on column JIAKE.PORTAL_SYSTEM_ROLE_USER.id
  is '记录id';
comment on column JIAKE.PORTAL_SYSTEM_ROLE_USER.role_id
  is '地区ID';
comment on column JIAKE.PORTAL_SYSTEM_ROLE_USER.user_id
  is '用户ID';
comment on column JIAKE.PORTAL_SYSTEM_ROLE_USER.role_name
  is '地区名称';
comment on column JIAKE.PORTAL_SYSTEM_ROLE_USER.user_name
  is '用户名称';

prompt
prompt Creating table PORTAL_SYSTEM_USER
prompt =================================
prompt
create table JIAKE.PORTAL_SYSTEM_USER
(
  id                 VARCHAR2(32) not null,
  user_id            VARCHAR2(100) not null,
  user_name          VARCHAR2(100),
  password           VARCHAR2(255),
  dept_id            VARCHAR2(100),
  dept_name          VARCHAR2(100),
  mobile             VARCHAR2(32),
  phone              VARCHAR2(32),
  fetion             VARCHAR2(32),
  email              VARCHAR2(100),
  family_address     VARCHAR2(100),
  fax                VARCHAR2(100),
  postal_code        VARCHAR2(30),
  remark             VARCHAR2(1000),
  sex                VARCHAR2(20),
  deleted            VARCHAR2(10) default 0,
  area_id            VARCHAR2(32),
  account_locked     VARCHAR2(2),
  pwd_create_time    DATE,
  account_start_time DATE,
  account_end_time   DATE,
  user_status        VARCHAR2(2) default '0',
  user_degree        VARCHAR2(100),
  oper_user_id       VARCHAR2(100),
  operremot_ip       VARCHAR2(100),
  create_time        DATE default sysdate,
  update_time        DATE,
  id_card_number     VARCHAR2(32),
  employee_number    VARCHAR2(32),
  area_name          VARCHAR2(100),
  city_remark        VARCHAR2(1000),
  dept_remark        VARCHAR2(1000),
  professional       VARCHAR2(200)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table JIAKE.PORTAL_SYSTEM_USER
  is '系统用户信息表-20130403用户数3336，AD上2941';
comment on column JIAKE.PORTAL_SYSTEM_USER.id
  is '记录Id';
comment on column JIAKE.PORTAL_SYSTEM_USER.user_id
  is '用户id';
comment on column JIAKE.PORTAL_SYSTEM_USER.user_name
  is '用户名称';
comment on column JIAKE.PORTAL_SYSTEM_USER.password
  is '密码';
comment on column JIAKE.PORTAL_SYSTEM_USER.dept_id
  is '部门id';
comment on column JIAKE.PORTAL_SYSTEM_USER.dept_name
  is '部门名称';
comment on column JIAKE.PORTAL_SYSTEM_USER.mobile
  is '手机号';
comment on column JIAKE.PORTAL_SYSTEM_USER.phone
  is '固定电话';
comment on column JIAKE.PORTAL_SYSTEM_USER.fetion
  is '飞信号';
comment on column JIAKE.PORTAL_SYSTEM_USER.email
  is '邮件地址';
comment on column JIAKE.PORTAL_SYSTEM_USER.family_address
  is '地址';
comment on column JIAKE.PORTAL_SYSTEM_USER.fax
  is '传真';
comment on column JIAKE.PORTAL_SYSTEM_USER.postal_code
  is '邮编';
comment on column JIAKE.PORTAL_SYSTEM_USER.remark
  is '备注';
comment on column JIAKE.PORTAL_SYSTEM_USER.sex
  is '性别 1是男，0是女';
comment on column JIAKE.PORTAL_SYSTEM_USER.deleted
  is '删除标识 1表示已删除  0表示未删除';
comment on column JIAKE.PORTAL_SYSTEM_USER.area_id
  is '地域';
comment on column JIAKE.PORTAL_SYSTEM_USER.account_locked
  is '帐号是否锁定 锁定 是''Y'' 未锁定是''N''';
comment on column JIAKE.PORTAL_SYSTEM_USER.pwd_create_time
  is '密码生效时间';
comment on column JIAKE.PORTAL_SYSTEM_USER.account_start_time
  is '账号生效时间';
comment on column JIAKE.PORTAL_SYSTEM_USER.account_end_time
  is '账号失效时间';
comment on column JIAKE.PORTAL_SYSTEM_USER.user_status
  is '用户状态';
comment on column JIAKE.PORTAL_SYSTEM_USER.user_degree
  is '用户等级';
comment on column JIAKE.PORTAL_SYSTEM_USER.oper_user_id
  is '操作人id';
comment on column JIAKE.PORTAL_SYSTEM_USER.operremot_ip
  is '操作ip地址';
comment on column JIAKE.PORTAL_SYSTEM_USER.create_time
  is '记录插入时间';
comment on column JIAKE.PORTAL_SYSTEM_USER.update_time
  is '记录更新时间';
comment on column JIAKE.PORTAL_SYSTEM_USER.id_card_number
  is '身份证号';
comment on column JIAKE.PORTAL_SYSTEM_USER.employee_number
  is '工号';
alter table JIAKE.PORTAL_SYSTEM_USER
  add constraint SYS08110802 primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PORTAL_SYSTEM_USERREFROLE
prompt ========================================
prompt
create table JIAKE.PORTAL_SYSTEM_USERREFROLE
(
  id                VARCHAR2(32) not null,
  role_id           VARCHAR2(255),
  role_name         VARCHAR2(100),
  user_id           VARCHAR2(100),
  user_name         VARCHAR2(100),
  remark            VARCHAR2(100),
  subroleid         VARCHAR2(32),
  status            VARCHAR2(10),
  currentsheetcount INTEGER,
  grouptype         VARCHAR2(10),
  roletype          VARCHAR2(10),
  version           VARCHAR2(50) default ''
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.PORTAL_SYSTEM_USERREFROLE
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYSTEM_GROUP
prompt ===========================
prompt
create table JIAKE.SYSTEM_GROUP
(
  group_id        VARCHAR2(32) not null,
  group_name      VARCHAR2(100) not null,
  parent_group_id VARCHAR2(32),
  group_type      VARCHAR2(1) not null,
  describes       VARCHAR2(200),
  create_time     DATE,
  deleted         VARCHAR2(1) not null
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.SYSTEM_GROUP
  add primary key (GROUP_ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYSTEM_GROUP_INCLUDE
prompt ===================================
prompt
create table JIAKE.SYSTEM_GROUP_INCLUDE
(
  id           VARCHAR2(32) not null,
  group_id     VARCHAR2(32),
  include_id   VARCHAR2(32),
  create_time  DATE,
  include_type VARCHAR2(1)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table JIAKE.SYSTEM_GROUP_INCLUDE
  add primary key (ID)
  using index 
  tablespace PORTALDB
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SYSTEM_USER
prompt ==========================
prompt
create table JIAKE.SYSTEM_USER
(
  id                  VARCHAR2(32) not null,
  cptroomid           VARCHAR2(100),
  cptroomname         VARCHAR2(100),
  dept_id             VARCHAR2(100),
  dept_name           VARCHAR2(100),
  email               VARCHAR2(100),
  familyaddress       VARCHAR2(100),
  fax                 VARCHAR2(100),
  mobile              VARCHAR2(100),
  operuser_id         VARCHAR2(100),
  phone               VARCHAR2(100),
  remark              VARCHAR2(100),
  sex                 VARCHAR2(20),
  user_degree         VARCHAR2(100),
  user_id             VARCHAR2(100),
  user_name           VARCHAR2(100),
  operremot_ip        VARCHAR2(100),
  create_time         DATE,
  update_time         DATE,
  account_enabled     VARCHAR2(2),
  account_expired     VARCHAR2(2),
  account_locked      VARCHAR2(2),
  credentials_expired VARCHAR2(2),
  password            VARCHAR2(255),
  postal_code         VARCHAR2(50),
  deleted             VARCHAR2(10),
  isfullemploy        VARCHAR2(10),
  isrest              VARCHAR2(10),
  user_status         VARCHAR2(2) default '0',
  portalrolename      VARCHAR2(100),
  flag                INTEGER default 0,
  fail_count          INTEGER,
  ispartners          VARCHAR2(100),
  userno              VARCHAR2(50),
  centerdept          VARCHAR2(50),
  nation              VARCHAR2(50),
  staffnature         VARCHAR2(50),
  birthdate           VARCHAR2(50),
  firsteducation      VARCHAR2(50),
  highesteducation    VARCHAR2(50),
  languageability     VARCHAR2(50),
  jobname             VARCHAR2(50),
  joblevel            VARCHAR2(50),
  specialty           VARCHAR2(50),
  worktime            VARCHAR2(50),
  inspecialtytime     VARCHAR2(50),
  transferredtime     VARCHAR2(50)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TAW_SYSTEM_WORKFLOW
prompt ==================================
prompt
create table JIAKE.TAW_SYSTEM_WORKFLOW
(
  id                VARCHAR2(32) not null,
  name              VARCHAR2(255),
  flowid            VARCHAR2(20),
  sheetid           VARCHAR2(30),
  remark            VARCHAR2(255),
  mainservicebeanid VARCHAR2(50),
  roleid            VARCHAR2(10),
  state             INTEGER,
  taskservicebeanid VARCHAR2(50),
  portalmark        VARCHAR2(2) default '0',
  portalsort        VARCHAR2(32) default '0',
  usenumber         NUMBER(10) default 0
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TAW_SYSTEM_WORKFLOW_USER
prompt =======================================
prompt
create table JIAKE.TAW_SYSTEM_WORKFLOW_USER
(
  id      VARCHAR2(32) not null,
  userid  VARCHAR2(255),
  flowid  VARCHAR2(20),
  orderby VARCHAR2(255),
  deleted VARCHAR2(2),
  name    VARCHAR2(255)
)
tablespace PORTALDB
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );


spool off
