-- Drone�� �����ϱ� ���� SQL ��
drop table drone;
drop sequence drone_seq;

create table drone
(
	serialnum number primary key,
	name varchar2(50) not null,
	price number not null,
	wingcount number(3) not null
);

create sequence drone_seq;