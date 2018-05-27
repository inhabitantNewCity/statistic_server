create table LEB_USERS (
    user_id number(20,0),
    name varchar2(400),
    email varchar2(400),
    hash varchar2(4000),
    salt varchar2(4000),
    
    CONSTRAINT PK_LEB_USER PRIMARY KEY(user_id)
);
create table LEB_Employee (
    Employee_id number(20,0),
    owner_id    number(20,0),
    user_id number(20,0),
    type varchar2(4000),

    CONSTRAINT PK_LEB_EMPL PRIMARY KEY(Employee_id),
    CONSTRAINT FK_LEB_EMPL_USER FOREIGN KEY(user_id) REFERENCES LEB_USERS(USER_ID),
    CONSTRAINT FK_LEB_EMPL_USER_OWNER FOREIGN KEY(OWNER_ID) REFERENCES LEB_USERS(USER_ID)
);
create table LEB_RIGTHS(
    user_id number(20,0),
    owner_id number(20,0),
    type    number(20,0),
    
    CONSTRAINT PK_LEB_RIGTH PRIMARY KEY(user_id, type),
    CONSTRAINT FK_LEB_RIGTH_USER Foreign KEY(user_id) REFERENCES LEB_USERS(user_id),
    CONSTRAINT FK_LEB_RIGTH_OWNER Foreign KEY(owner_id) REFERENCES LEB_USERS(user_id)
);
create table LEB_Consultance(
    consultance_id number(20,0),
    owner_id number(20,0),
    user_id number(20,0),
    time_start TIMESTAMP,
    time_end TIMESTAMP,
    isAccepted    number(1,0),
    
    CONSTRAINT PK_LEB_Consultance PRIMARY KEY(consultance_id),
    CONSTRAINT PK_U_LEB_Consultance UNIQUE(owner_id, user_id, time_start),
    CONSTRAINT FK_LEB_Consultance_USER Foreign KEY(user_id) REFERENCES LEB_USERS(user_id),
    CONSTRAINT FK_LEB_Consultance_OWNER Foreign KEY(owner_id) REFERENCES LEB_USERS(user_id)
);
create table LEB_Consultance_res(
    consultance_id number(20,0),
    description varchar2(4000),
    
    CONSTRAINT LEB_Consultance_res PRIMARY KEY(consultance_id)
);
create table LEB_Chart(
    consultance_id number(20,0),
    owner_id number(20,0),
    user_id number(20,0),
    
    CONSTRAINT PK_LEB_Chart PRIMARY KEY(consultance_id),
    CONSTRAINT PK_U_LEB_Chart UNIQUE(owner_id, user_id, consultance_id),
    CONSTRAINT FK_LEB_Chart_USER Foreign KEY(user_id) REFERENCES LEB_USERS(user_id),
    CONSTRAINT FK_LEB_Chart_OWNER Foreign KEY(owner_id) REFERENCES LEB_USERS(user_id),
    CONSTRAINT FK_LEB_Chart_consultance Foreign KEY(consultance_id) REFERENCES LEB_Consultance(consultance_id)
);
create table LEB_Message(
    parent_id number(20,0),
    owner_id number(20,0),
    text varchar2(4000),
    message_time TIMESTAMP,
    
    CONSTRAINT PK_LEB_Message PRIMARY KEY(parent_id, message_time),
    CONSTRAINT FK_LEB_Message_Chart Foreign KEY(parent_id) REFERENCES LEB_Chart(consultance_id),
    CONSTRAINT FK_LEB_Message_OWNER Foreign KEY(owner_id) REFERENCES LEB_USERS(user_id)
);
alter table LEB_Message drop CONSTRAINT PK_LEB_Message;
alter table LEB_Message add CONSTRAINT PK_LEB_Message PRIMARY KEY(parent_id, message_time); 
insert into LEB_USERS values (1, 'user1', 'tmp@tmp.com', 'dsadasd', 'sadasdasd');
insert into LEB_USERS values (2, 'user2', 'tmpd@tmpd.com', 'waedad334dsdf', 'sadasdasd');
insert into LEB_USERS values (3, 'owner', 'tmpo@tmpo.com', 'wqewqedxcfzxcd', 'sadasdasd');
/
/*
consultance_id number(20,0),
    owner_id number(20,0),
    user_id number(20,0),
*/
insert into LEB_Employee values (1, 3, 2, 'waedad334dsdf');
insert into LEB_Consultance values (1,2,1,to_timestamp('17-05-2018 10:00', 'DD-MM-YYYY HH24:MI:SS'), to_timestamp('17-05-2018 10:00', 'DD-MM-YYYY HH24:MI:SS'), 0);
insert into LEB_Consultance values (2,2,1,to_timestamp('18-05-2018 13:00', 'DD-MM-YYYY HH24:MI:SS'), to_timestamp('18-05-2018 15:00', 'DD-MM-YYYY HH24:MI:SS'), 1);
insert into LEB_Consultance_res values (2, 'qqwdhlkjsdlj saodjasldj sdksa');
insert into LEB_CHART values (2,2,1);
insert into LEB_CHART values (1,2,1);
insert into LEB_Message values (1, 2, 'first1', to_timestamp('27-05-2018 15:55', 'DD-MM-YYYY HH24:MI:SS'));
insert into LEB_Message values (1, 2, 'first2', to_timestamp('27-05-2018 16:55', 'DD-MM-YYYY HH24:MI:SS'));
insert into LEB_Message values (2, 2, 'first3', to_timestamp('21-05-2018 16:55', 'DD-MM-YYYY HH24:MI:SS'));
insert into LEB_Message values (2, 2, 'first4', to_timestamp('29-05-2018 16:55', 'DD-MM-YYYY HH24:MI:SS'));