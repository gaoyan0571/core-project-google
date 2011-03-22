
 CREATE TABLE `info` (
  `id` bigint(11) NOT NULL default '0',
  `type` varchar(20) default '' COMMENT '����',
  `title` varchar(255) default '' COMMENT '����',
  `source_url` varchar(255) default '' COMMENT '��Դ��ַ',
  `source` varchar(255) default '' COMMENT '��Դ',
  `content` text NOT NULL,
  `add_time` datetime default NULL,
  `edit_time` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ϣ��'


create table time_info (
id bigint(11)  not null ,
title varchar(255) default '' comment '���⣬��΢��һ��������',
type varchar(20) default '' comment '����',
add_time datetime not null,
start_time datetime ,
end_time datetime,
primary key (id)
)Engine =Innodb default charset =utf8 comment ='ʱ������';

create table  test(
 id int(11) not null auto_increment,
 info varchar(255) default '',
 primary key(id)
)engine=Innodb default charset=utf8



-- ----------------------------
-- Table structure for job_task
-- ----------------------------
CREATE TABLE `job_task` (
  `TASK_ID` int(11) NOT NULL comment '���������', 
  `TASK_CODE` varchar(255) default NULL comment '������� ���������������ʱ����Ϊqz���������',
  `TASK_TYPE` varchar(255) default NULL comment '�������ͣ��������������ʱ����Ϊqz����ķ���',
  `TASK_IMPL_CLASS` varchar(255) default NULL comment '�������',
  `TASK_EXPRESS` varchar(50) default NULL comment '����ִ�б��ʽ',
  `STATE_DATE` datetime default NULL comment '�������ʱ�䣬���������������У������Ҫʹ�����е������޸�������Ч����Ҫ������ֶε�ֵ���ô��ڵ�ǰʱ�䡣',
  `STATE` varchar(2) default NULL COMMENT '����״̬  U ʹ���� O�ѽ���',
  `PARMS` varchar(500) default NULL comment '�����ʼ���������������е�ʱ�򣬿��Դ�JobDataMap�����л�ȡ���ֶε�ֵ��',
  `REMARK` varchar(2000) default NULL,
  `CREATE_DATE` datetime default NULL comment '�������ڣ�û��ʲôʵ�����塣',
  PRIMARY KEY  (`TASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf-8;


-- ----------------------------
-- Table structure for task_log
-- ----------------------------
CREATE TABLE `task_log` (
  `TASK_LOG_ID` int(8) NOT NULL comment '������־���',
  `TASK_ID` int(8) default NULL comment '������ ',
  `STATE` varchar(2) default NULL COMMENT 'ִ��״̬ O������R�����У�E�쳣���� �������E �ģ�˵���쳣�ˣ��쳣��Ϣ�����REMARKS�ֶ��� ',
  `START_DATE` datetime default NULL comment 'ִ�п�ʼʱ��',
  `FINISH_DATE` datetime default NULL comment 'ִ�н���ʱ��',
  `REMARKS` varchar(2000) default NULL comment '��ע',
  PRIMARY KEY  (`TASK_LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf-8;
