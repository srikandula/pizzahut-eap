
# Create pizzauser with password as techm123
CREATE USER 'pizzauser'@'localhost' IDENTIFIED BY 'techm123';
GRANT ALL PRIVILEGES ON *.* TO 'pizzauser'@'localhost'   WITH GRANT OPTION;
CREATE USER 'pizzauser'@'%' IDENTIFIED BY 'techm123';
GRANT ALL PRIVILEGES ON *.* TO 'pizzauser'@'%'  WITH GRANT OPTION;
FLUSH PRIVILEGES;

