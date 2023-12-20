select product_name
from netology.orders o
         join netology.customers c on
    o.customer_id = c.id and LOWER(c.name) = :name