CREATE TABLE products (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  short_description VARCHAR(300),
  price NUMERIC(10, 2) NOT NULL,
  thumbnail_url VARCHAR(500)
);

CREATE TABLE product_details (
  product_id BIGINT PRIMARY KEY REFERENCES products(id) ON DELETE CASCADE,
  description TEXT,
  brand VARCHAR(100),
  sku VARCHAR(50),
  weight_grams INTEGER,
  dimensions VARCHAR(100),
  material VARCHAR(100),
  color VARCHAR(50),
  stock INTEGER,
  image_url VARCHAR(500)
);
