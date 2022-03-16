INSERT INTO 
`user` (`user_id`, `user_name`, `user_address`) 
VALUES 
(100, 'Filippo Castellana', 'Kensal Rise'), 
(101, 'John Doe', 'Westminster'), 
(102, 'Chris Perrins', 'Baker Street');

INSERT INTO 
`restaurant` (`restaurant_id`, `restaurant_name`, `restaurant_address`) 
VALUES 
(100, 'Sacro Cuore', 'Kensal Rise'), 
(101, 'Gales', 'Westminster'), 
(102, 'Da Michele', 'Baker Street');

INSERT INTO 
`product` (`product_id`, `product_name`, `product_price`, `restaurant_id`) 
VALUES 
(100, 'Bruschetta', '100', 100),
(101, 'Pizza', '1000', 100),
(102, 'Bun', '600', 101),
(103, 'Coffee', '1000', 101),
(104, 'Tiramisu', '850', 102),
(105, 'Limoncello', '1000', 102);

INSERT INTO 
`order` (`order_id`, `user_user_id`, `restaurant_restaurant_id`) 
VALUES 
(100, 100, 100),
(101, 101, 100),
(102, 101, 101),
(103, 102, 102);


INSERT INTO 
`orderProduct` (`order_product_id`, `order_order_id`, `product_product_id`) 
VALUES 
(100, 100, 101),
(101, 101, 100),
(102, 102, 102),
(103, 103, 104);