DROP TABLE IF EXISTS user;
Create Table user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password TEXT(256) NOT NULL,
    user_key VARCHAR(250) NOT NULL,
    credit INT NOT NULL
);
DROP TABLE IF EXISTS applicant;

Create Table applicant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    credit INT NOT NULL
);