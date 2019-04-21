CREATE TABLE IF NOT exists users (
	empId INT AUTO_INCREMENT,
    fName VARCHAR(25) NOT NULL,
    lName VARCHAR(25) NOT NULL,
    pass_word VARCHAR(25) NOT NULL,
    email VARCHAR(30),
    phone VARCHAR(12),
    roles VARCHAR(20) NOT NULL,
    PRIMARY KEY(empId)
    );
    
create table if not exists address(
	empId int not null,
    zipcode varchar(5) not null,
    street varchar(25) not null,
    city varchar(25) not null,
    state varchar(25) not null,
    lat varchar(50),
    longtiude varchar(50),
    primary key(empid),
    foreign key (empId) references users(empId)
	);
    
create table if not exists task(
	taskId int not null auto_increment,
    taskName varchar(25) not null,
    dueDate date not null,
    priority tinyint not null,
    catagory varchar(15) not null,
    taskDescription text,
    taskStatus varchar(30) not null,
    taskAssigned date,
    primary key(taskId)
    );
    
INSERT INTO `taskmanagerdb`.`users` (`fName`, `lName`, `pass_word`, `email`, `phone`, `roles`) VALUES ('dawit', 'asefa', '123', 'dawit@gmail.com', '0912345678', 'admin');
    
    