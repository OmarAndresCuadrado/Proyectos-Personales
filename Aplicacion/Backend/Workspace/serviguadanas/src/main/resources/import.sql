INSERT INTO `users` (name, password, enabled, last_name, email,phone) VALUES ('milena','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1,'Talero','milena@gmail.com',3105800497);
INSERT INTO `users` (name, password, enabled, last_name, email,phone) VALUES ('admin','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1,'admin','admin@gmail.com',3205478965);
INSERT INTO `users` (name, password, enabled, last_name, email,phone) VALUES ('omar','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1,'cuadrado','omillar@gmail.com',3105800497);

INSERT INTO `roles` (role_name) VALUES ('ROLE_USER');
INSERT INTO `roles` (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_roles` (user_id, role_id) VALUES (1, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (3, 1);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 2);
INSERT INTO `users_roles` (user_id, role_id) VALUES (2, 1);
