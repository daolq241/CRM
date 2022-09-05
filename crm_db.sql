
drop database crm;
create database crm;
use crm;

create table role(
	id int auto_increment,
	name varchar(50),
    description varchar(255),
    
    primary key(id)
);

create table user(
	id int auto_increment,
    code varchar(50),
    name varchar(50),
    email varchar(50),
    password varchar(50),
    address varchar(255),
    phone varchar(20),
    role_id int,
    
    primary key(id),
    foreign key(role_id) references role(id)
);


create table project(
	id int auto_increment,
    name varchar(255),
    description varchar(255),
    start_date date,
    end_date date,
    user_code_create varchar(50),
    progress varchar(255),

    primary key(id)
);


create table user_project(
	user_id int,
    project_id int,
    foreign key(user_id) references  user(id),
    foreign key (project_id) references project(id)
);

create table task(
	id int auto_increment,
    name varchar(255),
    description varchar(255),
    start_date date,
    end_date date,
    status varchar(50),
    project_id int,
    
    primary key(id),
    foreign key(project_id) references project(id)
);

create table user_task(
	user_id int,
    task_id int,
    description varchar(255),
    foreign key(user_id) references user(id),
    foreign key(task_id) references task(id)
);

insert into role(name) values("ADMIN");
insert into role(name) values("LEADER");
insert into role(name) values("MEMBER");

insert into user(code, name, email, password, phone, role_id) values("NV1", "Lê Quang Đạo", "dao@gmail.com", "dao123", "0943824198", 3);
insert into user(code, name, email, password, phone, role_id) values("NV2", "Nguyễn Văn A", "a@gmail.com", "a123", "0912345678", 3);
insert into user(code, name, email, password, phone, role_id) values("NV3", "Nguyễn Văn B", "b@gmail.com", "b123", "0912345678", 3);
insert into user(code, name, email, password, phone, role_id) values("NV4", "Nguyễn Văn C", "c@gmail.com", "c123", "0912345678", 3);
insert into user(code, name, email, password, phone, role_id) values("NV5", "Nguyễn Văn D", "d@gmail.com", "d123", "0912345678", 3);
insert into user(code, name, email, password, phone, role_id) values("NV6", "Trần Văn E", "e@gmail.com", "e123", "0812345678", 2);
insert into user(code, name, email, password, phone, role_id) values("NV7", "Trần Văn F", "f@gmail.com", "f123", "0812345678", 2);
insert into user(code, name, email, password, phone, role_id) values("NV100", "Admin", "admin@gmail.com", "admin123", "0123456789", 1);

insert into project(name, description, start_date, end_date, progress) values ("Dự án CRM", "Quản lý nhân sự", "2022-08-15", "2022-10-15", "Chưa bắt đầu");
insert into project(name, description, start_date, end_date, progress) values ("Dự án Spring", "Spring ", "2022-08-15", "2022-10-15", "Đang thực hiện");
insert into project(name, description, start_date, end_date, progress) values ("Dự án ecommerce", "Quản lý bán hàng", "2022-08-15", "2022-10-15", "Đã hoàn thành");

insert into user_project(user_id, project_id) values(1,1);
insert into user_project(user_id, project_id) values(2,1);
insert into user_project(user_id, project_id) values(6,1);
insert into user_project(user_id, project_id) values(3,2);
insert into user_project(user_id, project_id) values(4,2);
insert into user_project(user_id, project_id) values(7,2);

insert into task(name, description, start_date, end_date, status, project_id) values ("Lấy yêu cầu", "Gặp khách hàng lấy yêu cầu", "2022-08-15", "2022-08-20", "Đã hoàn thành", 1);
insert into task(name, description, start_date, end_date, status, project_id) values ("Phân tích", "Phân tích dự án", "2022-8-25", "2022-9-1", "Đang thực hiện", 1);
insert into task(name, description, start_date, end_date, status, project_id) values ("Thiết kế", "Thiết kế", "2022-9-2", "2022-9-10", "Chưa bắt đầu", 1);
insert into task(name, description, start_date, end_date, status, project_id) values ("Code", "Cài đặt mã nguồn", "2022-9-11", "2022-10-11", "Chưa bắt đầu", 1);
insert into task(name, description, start_date, end_date, status, project_id) values ("Kiểm thử", "Test toàn hệ thống", "2022-10-11", "2022-10-15", "Chưa bắt đầu", 1);

insert into task(name, description, start_date, end_date, status, project_id) values ("Lấy yêu cầu", "Gặp khách hàng lấy yêu cầu", "2022-08-15", "2022-08-20", "Đã hoàn thành", 2);
insert into task(name, description, start_date, end_date, status, project_id) values ("Phân tích", "Phân tích dự án", "2022-8-25", "2022-9-1", "Đang thực hiện", 2);
insert into task(name, description, start_date, end_date, status, project_id) values ("Thiết kế", "Thiết kế", "2022-9-2", "2022-9-10", "Chưa bắt đầu", 2);

insert into task(name, description, start_date, end_date, status, project_id) values ("Code", "Cài đặt mã nguồn", "2022-9-11", "2022-10-11", "Chưa bắt đầu", 3);
insert into task(name, description, start_date, end_date, status, project_id) values ("Kiểm thử", "Test toàn hệ thống", "2022-10-11", "2022-10-15", "Chưa bắt đầu", 3);

insert into user_task(user_id, task_id) values(1,1);
insert into user_task(user_id, task_id) values(2,2);
insert into user_task(user_id, task_id) values(3,3);
insert into user_task(user_id, task_id) values(4,4);
insert into user_task(user_id, task_id) values(5,4);
insert into user_task(user_id, task_id) values(6,4);
insert into user_task(user_id, task_id) values(7,5);