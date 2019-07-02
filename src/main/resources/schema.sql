Create Table IF Not Exists user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    userName VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    userKey VARCHAR(250) NOT NULL,
    remainingCredit INT NOT NULL
);