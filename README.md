# DS_it21909_it21921_it219146
This is the repository for the semester assignment of the subject "Distributed Systems" of Department of Infomatics and Telematics, Harokopio University of Athens

## **Docker database creation**

Type the following to create the db:
docker run --name mysqldb -v mysqldbvol:/var/lib/mysql -p 3306:3306 -e MYSQL_USER=hbcitizen -e MYSQL_PASSWORD=password123 -e MYSQL_DATABASE=citizens -e MYSQL_ROOT_PASSWORD=pass123 
--rm -d mysql/mysql-server:latest

To connect as a root user:
mysql -u root  -P 3306 -p

  *If you are using windows:
  docker exec -it mysqldb bash
  mysql -u root  -P 3306 -p*
  
To create a user, type:
CREATE USER 'hbcitizen'@'localhost' IDENTIFIED BY 'password123';
GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'localhost';
CREATE USER 'hbstudent'@'%' IDENTIFIED BY 'changeit';
GRANT ALL PRIVILEGES ON * . * TO 'hbstudent'@'%';

After that you will have to initialize the database using the init.sql file.
