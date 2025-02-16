insert into events.roles (id, role)
values (1, 'USER'),
       (2, 'ADMIN');

insert into events.users (id, email, password, username, first_name, last_name)
values  (1, 'admin@spge.bg', '$2a$10$SPws6apVaqMrE1c/pwhYAOx5JdRb4z/q/.fpyLGtSZdb/afxI6L1i', 'ADMIN', 'ADMIN', 'ADMIN');

insert into events.users_roles (user_id, role_id)
values  (1, 1),
        (1, 2);