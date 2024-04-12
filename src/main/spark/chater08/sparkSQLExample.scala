package chater08

/**
 * @Author： 小周
 * @Date： 2024/2/11 21:44
 * @Describe：
 */
object sparkSQLExample {


}

/**
 * sparkSQL可从各种结构化数据源读取数据
 * 包含行业标准的JDBC和ODBC连接方式
 * 可以无缝地将SQL查询与Spark程序进行结合,他能将结构化数据作为Spark RDDs和DataFrame对象
 * spark sql架构与hive架构相比 把底层的Mapreduce执行引擎改成spark，还修改了catalyst优化器
 * spark sql cli 配置
 * 将hive-site.xml 复制到$SPARK_HOME/conf目录下
 * cp $HIVE_HOME/conf/hive-site.xml $SPARK_HOME/conf/
 * 将mysql驱动包复制到$SPARK_HOME/jars目录下
 * 在$SPARK_HOME/conf/spark-env.sh中添加mysql驱动
 * export SPARK_CLASSPATH=$SPARK_CLASSPATH=/opt/module/spark-3.2.1/jars/mysql-connector-java-5.1.32-bin.jar
 * mysql-connector-java-5.1.32-bin.jar
 * 并且分发其他节点
 * 启动mysql服务 systemctl start mysqld
 * 启动hive的metastore服务 hive --service metastore &
 * 修改日志级别 log4j.rootCategory=WARN, console
 * 启动spark集群 ./sbin/start-all.sh
 * 启动spark sql $SPARK_HOME/bin/ ./spark-sql [我默认是local]
 * ./spark-sql --master spark://master:7077
  spark-sql> show databases;
  default
  example
  my_hive_db
  Time taken: 6.5 seconds, Fetched 3 row(s)

 spark sql与shell交互
 create database user;
 use user;
spark-sql> create table user_info(
         > id string,
         > name string,
         > age int
         > )
         > row format delimited fields terminated by ',';
 desc table user_info;
 id: string
 name: string
 age: int
 Time taken: 0.11 seconds
spark-sql> select  * from user_info limit 5 ;
hdfs : /opt/module/hive-3.1.2/warehouse/user.db/user_info 上传user.txt
 spark-sql> select  * from user_info limit 5 ;
4       David   42
6       Fran    50
2       Bob     27
1       Alice   28
3       Charlie 65
Time taken: 4.44 seconds, Fetched 5 row(s)
 spark sql框架集成在spark-shell中 启动spark-shell即可以使用spark sql的交互接口
 spark查询数据可以使用两个对象 SqlContext 和 HiveContext
 SPARK2.x版本之后 开始spark将SqlContext和HiveContext进行整合一种全新的创建方式SparkSession
spark-shell启动的过程会初始化一个SparkSession对象，这个对象是spark的入口，可以使用spark.sql()方法来执行sql语句和HiveQL语句
spar-shell |spark-shell --master spark://master:7077

scala> val df1=spark.sql("show databases")
24/02/22 09:44:07 WARN HiveConf: HiveConf of name hive.metastore.event.db.notification.api.auth does not exist
24/02/22 09:44:07 WARN HiveConf: HiveConf of name hive.server2.active.passive.ha.enable does not exist
24/02/22 09:44:07 WARN HiveConf: HiveConf of name hive.optimize.dynamic.partition.pruning does not exist
24/02/22 09:44:07 WARN HiveConf: HiveConf of name hive.log.perf.output does not exist
24/02/22 09:44:07 WARN HiveConf: HiveConf of name hive.server2.thrift.heap.size does not exist
df1: org.apache.spark.sql.DataFrame = [namespace: string]

scala> df1.show()
+----------+
| namespace|
+----------+
|   default|
|   example|
|my_hive_db|
|      user|
+----------+


scala> val df2=spark.sql("use user")
df2: org.apache.spark.sql.DataFrame = []

scala> val df3=spark.sql("show tables")
df3: org.apache.spark.sql.DataFrame = [namespace: string, tableName: string ... 1 more field]

scala> df3.show()
+---------+---------+-----------+
|namespace|tableName|isTemporary|
+---------+---------+-----------+
|     user|user_info|      false|
+---------+---------+-----------+
scala> val df4=spark.sql("select * from user_info")
df4: org.apache.spark.sql.DataFrame = [id: string, name: string ... 1 more field]

scala> df4.show()
+---+-------+---+
| id|   name|age|
+---+-------+---+
|  4|  David| 42|
|  6|   Fran| 50|
|  2|    Bob| 27|
|  1|  Alice| 28|
|  3|Charlie| 65|
|  5|     Ed| 55|
+---+-------+---+


 */