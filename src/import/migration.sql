use adlister_db;


DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS user;



CREATE TABLE user(
  id INT unsigned NOT NULL AUTO_INCREMENT,
  role INT NOT NULL,
  username VARCHAR(240) NOT NULL,
  email VARCHAR(50) NOT NULL,

  password VARCHAR(120) NOT NULL,
  activate TINYINT(1) NOT NULL ,
  deactivate TINYINT(1) NOT NULL,
  PRIMARY KEY (id)

);

CREATE TABLE ads(
  id INT unsigned NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL,
  title VARCHAR(50) NOT NULL ,
  description VARCHAR(140) NOT NULL ,
  category VARCHAR (100) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user(id)
    ON DELETE CASCADE

);



