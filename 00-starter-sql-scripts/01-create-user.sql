-- Drop user first if they exist
DROP USER if exists 'userName'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'userName'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON * . * TO 'userName'@'password';