INSERT INTO users (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES
  (1, 'Zone A', 'Desk 1', '1-Jan-2022'),
  (2, 'Zone B', 'Desk 2', '1-Jan-2022'),
  (3, 'Zone C', 'Desk 3', '1-Jan-2022');

INSERT INTO zones (id, name) VALUES
    (1,'Zone A'),
    (2,'Zone B'),
    (3,'Zone C');

INSERT INTO desks (id, name, zone_id) VALUES
    (1,'A1',1),
    (2,'A2',1),
    (3,'HotDesk 1',2),
    (4,'HotDesk 2',2),
    (5,'B1', 2),
    (6,'Window 1', 3),
    (7,'Window 2', 3),
    (8,'C1', 3),
    (9,'C2', 3),
    (10,'C3', 3);

INSERT INTO bookings (id, start_time, end_time, desk_id, users_id) VALUES
 (1, '2021-02-21 08:15:24.977', '2021-02-21 17:40:24.977' ,1,1),
 (2, '2021-02-22 08:15:24.977', '2021-02-22 17:40:24.977' ,1,1),
 (3, '2021-02-22 08:15:24.977', '2021-02-22 17:40:24.977' ,2,1);
