DROP TABLE IF EXISTS NACEDto;

CREATE TABLE NACEDto (
   order_id INT PRIMARY KEY,
    level_id INT,
  code VARCHAR(250)  ,
  parent VARCHAR(250)  ,
  description CLOB,
  itemIncludes CLOB,
  itemAlsoIncludes CLOB,
  rulings CLOB,
  itemExcludes CLOB,
  reference VARCHAR(250)
);