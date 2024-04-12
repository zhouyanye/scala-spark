CREATE DATABASE IF NOT EXISTS studentProject;
USE studentProject;

CREATE TABLE IF NOT EXISTS student (
                                       s_id INT,
                                       s_name STRING,
                                       s_birth DATE,
                                       s_sex STRING
)
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ',';

-- LOAD DATA LOCAL INPATH 'student.txt' INTO TABLE studentProject.student;

CREATE TABLE IF NOT EXISTS score (
                                     c_id INT,
                                     s_id INT,
                                     s_score INT
)
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ',';

-- LOAD DATA LOCAL INPATH 'score.txt' INTO TABLE studentProject.score;

CREATE TABLE IF NOT EXISTS course (
                                      c_id INT,
                                      c_name STRING,
                                      t_id INT
)
    ROW FORMAT DELIMITED
    FIELDS TERMINATED BY ',';

-- LOAD DATA LOCAL INPATH 'course.txt' INTO TABLE studentProject.course;
