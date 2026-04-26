create table if not exists db_test.student
(
    id    bigint auto_increment
    primary key,
    stuno varchar(100) not null,
    name  varchar(100) not null,
    age   int          not null
);

insert into db_test.student (id, stuno, name, age)
values  (1, '10001', '张三', 19),
        (2, '10002', '李四', 20),
        (3, '10003', '沈月', 21),
        (4, '10004', '张建诚', 20),
        (5, '10005', '刘凯', 19),
        (6, '10006', '沈军华', 29),
        (7, '10007', '李超', 34),
        (8, '10008', '陈艳华', 20),
        (9, '10009', '王伊', 26),
        (10, '10010', '刘康', 35),
        (11, '10011', '邹凯', 28),
        (12, '10012', '曾庆存', 26),
        (13, '10013', '陈洁洁', 21),
        (14, '10014', '胡建峰', 44),
        (15, '10015', '刘梅兰', 54);


