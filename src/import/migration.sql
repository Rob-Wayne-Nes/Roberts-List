use adlister_db;


DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS ads;


CREATE TABLE role(
  id INT unsigned NOT NULL AUTO_INCREMENT,
  user_role VACHAR(50)
  PRIMARY KEY (id)
)

CREATE TABLE user(
  id INT unsigned NOT NULL AUTO_INCREMENT,
  user_role VARCHAR UNSIGNED NOT NULL,
  username VARCHAR(240) NOT NULL,
  email VARCHAR(50),
  password VARCHAR(20),
  activate BIT(1),
  deactivate BIT(1)
  PRIMARY KEY (id),
  FOREIGN KEY (user_role) REFERENCES role(id)
    ON DELETE CASCADE

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


