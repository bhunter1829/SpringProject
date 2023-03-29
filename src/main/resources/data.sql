INSERT INTO departments (department) VALUES 'Food', 'Utility', 'Personal Care', 'Pet Care';


INSERT INTO inventory (name, amount, departmentFK) VALUES ('Apples',10,1),('Bread',5,1),('Cheese',15,1),('Eggs',20,1),
('Chicken breasts',15,1),('Milk',13,1),('Salmon',18,1),
('Yogurt',30,1),('Cereal',20,1),('Spinach',5,1),
('Bananas',15,1),('Carrots',30,1),('Tomatoes',30,1),
('Pasta',12,1),('Canned corn',10,1),('Frozen pizza',15,1),
('Ground beef',5,1),('Orange juice',10,1),
('Honey',5,1),('Almonds',19,1);


INSERT INTO inventory (name, amount, departmentFK)
VALUES
('Flashlight', 10, 2),
('Batteries', 50, 2),
('Duct Tape', 20, 2),
('Light Bulbs', 30, 2),
('Trash Bags', 40, 2),
('Cleaning Spray', 15, 2),
('Paper Towels', 25, 2),
('Toilet Paper', 35, 2),
('Hand Soap', 20, 2),
('Dish Soap', 20, 2),
('Sponges', 30, 2),
('All-Purpose Cleaner', 15, 2),
('Laundry Detergent', 25, 2),
('Dryer Sheets', 30, 2),
('Vacuum Bags', 10, 2),
('Windex', 10, 2),
('Broom', 15, 2),
('Dustpan', 15, 2),
('Mop', 20, 2),
('Floor Cleaner', 10, 2);


INSERT INTO inventory (name, amount, departmentFK)
VALUES
('Toothbrush', 15, 3),
('Toothpaste', 20, 3),
('Mouthwash', 10, 3),
('Shampoo', 20, 3),
('Conditioner', 20, 3),
('Body Wash', 25, 3),
('Deodorant', 15, 3),
('Razors', 10, 3),
('Shaving Cream', 10, 3),
('Hand Sanitizer', 20, 3);


INSERT INTO inventory (name, amount, departmentFK)
VALUES
('Dog Food', 40, 4),
('Cat Food', 30, 4),
('Pet Treats', 20, 4),
('Litter Box', 5, 4),
('Litter', 15, 4),
('Dog Leash', 10, 4),
('Dog Collar', 10, 4),
('Cat Collar', 10, 4),
('Pet Shampoo', 10, 4),
('Flea & Tick Prevention', 15, 4);


--To return everything with their related department
--select a.name, b.department from inventory a inner join departments b on a.departmentfk = b.department_id


--Add a where clause for individual department return
--
--where b.department = 'Food'
--
--where b.department = 'Utility'
--
--where b.department = 'Personal Care'
--
--where b.department = 'Pet Care'