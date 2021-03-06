DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS applicant;

Create Table IF NOT EXISTS user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    user_name VARCHAR(250) UNIQUE NOT NULL,
    password VARCHAR(250) NOT NULL,
    user_key CHAR(65) NOT NULL,
    address CHAR(45)
);

Create Table IF NOT EXISTS applicant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    credit INT NOT NULL
);