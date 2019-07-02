Create Table IF NOT EXISTS user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password TEXT(256) NOT NULL,
    user_key VARCHAR(250) NOT NULL,
    credit INT NOT NULL
);


Create Table IF NOT EXISTS applicant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    credit INT NOT NULL
);

Create Table IF NOT EXISTS pet_extra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pet_name VARCHAR(250),
    url VARCHAR(250) NOT NULL,
    up_descrip TEXT(50)
);