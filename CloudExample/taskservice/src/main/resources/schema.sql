create table tasks (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         description VARCHAR(100) NOT NULL,
                         status varchar(50),
                         create_time timestamp
);