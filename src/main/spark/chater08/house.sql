create   database if not exists house;
    --已知csv字段名为selling_price,bedrooms_num,bathroom_num,housing_area,parking_area,floor_num,housing_rating,built_area,basement_area,year_built,year_repair,latitude,longitude,sale_data
    use house;
        create table if not exists king_county_house(
           selling_price double,
           bedrooms_num int,
           bathroom_num int,
           housing_area double,
           parking_area double,
           floor_num int,
            housing_rating double,
            built_area double,
            basement_area double,
            year_built int,
            year_repair int,
            latitude double,
            longitude double,
            sale_data string,
        )row format delimited fields terminated by ','; -- 分隔符为','
        --bash
   hive -e     load data local inpath 'house.csv' into table house.king_county_house; -- 加载数据