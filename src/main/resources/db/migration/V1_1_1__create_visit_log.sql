CREATE TABLE tb_visit_log (
    `id` int(30) primary key auto_increment,
    `url` VARCHAR(100) NOT NULL COMMENT '网站url',
    `method` VARCHAR(255) NOT NULL COMMENT '方法名',
    `user_code` VARCHAR(30) DEFAULT NULL COMMENT '用户code',
    `user_name` VARCHAR(30) DEFAULT NULL COMMENT '用户姓名',
    `user_phone` VARCHAR(20) DEFAULT NULL COMMENT '用户登陆手机号',
    `user_agent` VARCHAR(255) DEFAULT NULL COMMENT '用户客户端',
    `user_ip` VARCHAR(100) DEFAULT NULL COMMENT '用户ip',
    `request_type` VARCHAR(20) DEFAULT NULL COMMENT '请求方式GET或者POST',
    `use_time` VARCHAR(50) DEFAULT NULL COMMENT '请求处理时间',
    `create_time` datetime DEFAULT NULL COMMENT '用户访问时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;