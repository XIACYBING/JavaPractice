# Hibernate学习
## 概念
    ORM
    PO
    VO
    DTO
## 数据库方言

## 第一个Hibernate流程
    - 导入对应的Hibernate和数据库连接包。
    - 创建主配置文件hibernate.cfg.cml，作用是包含数据库连接、
    事务管理和类表管理等相关信息。
    - 创建用户类和对应的xml文件，xml文件中书写用户类和数据库表
    的对应关系，Hibernate借此创建对应的数据表。