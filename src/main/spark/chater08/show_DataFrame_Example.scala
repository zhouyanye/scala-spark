package chater08

/**
 * @Author： 小周
 * @Date： 2024/3/9 20:19
 * @Describe：
 */
object show_DataFrame_Example {
  def main(args: Array[String]): Unit = {

  }

}

/**
 * 启动hadoop
 * master start-dfs.sh
 * slave1 start-yarn.sh
 * 启动元数据 hive --service metastore &
 * 启动spark集群 $SPARK_HOME/sbin/start-all.sh
 * spark-shell --master spark://master:7077 | spark-shell local[2]
 * dsl 风格
 * dataframe 提供了一个领域特定语言(DSL) 来操作数据。方便操作结构化数据
 * sql风格
 * 在程序中直接使用spark.sql()方法来执行sql语句 结果是一个DataFrame返回,使用sql风格操作的前提是将dataframe注册成一个临时表
 *
 * sql风格操作dataframe
 *  1. 使用createOrReplaceTempView()方法将dataframe注册成一个临时表
 *  2. 使用spark.sql()方法来执行sql语句
 *
 * dsl 风格操作dataframe
 *  show 方法 查看数据
 *  where/filter  过滤数据 条件查询
 *  select/selectExpr/col/apply  查询指定字段的数据信息
 *  limit  查询指定条数的数据
 *  distinct  去重
 *  count  统计
 *  orderBy/sort  排序查询
 *  groupBy  分组查询
 *  join  连接查询
 *  union  合并查询
 *  agg  聚合查询
 *  查看以及获取数据常用函数或者方法*
 *  show()  查看数据 默认显示前20行数据
 *  查看多行 show(numRows: Int,Boolean false)
 *  printSchema()  查看数据的schema 打印数据模式
 *  first/head/take/takeAsList   获取若干行数据
 *  collect/collectAsList  获取所有数据
 *
 *  查询年龄最大的前两名人的信息
 *  scala> val personDF=spark.read.option("header","true").csv("/datas/people.csv")
 *  personDF.createOrReplaceTempView("t_person")
 *  scala> spark.sql("select * from t_person order by age desc limit 2").show()
 +----+---+---------+
|name|age|      job|
+----+---+---------+
| DDD| 43|      CEO|
|CCCC| 40|Developer|
+----+---+---------+
 将文件rating.dat中的数据保存为DataFrame数据集
 val rating=sc.textFile("/datas/ratings.dat").map(_.split("::"))
 case class Rating(userId: String, movieID: String,rating: String, timestamp: Long)
 val rdd1=rating.map(x=>Rating(x(0),x(1),x(2),x(3).trim.toLong))
val ratingsDF=rdd1.toDF()

 users.dat
 val user=sc.textFile("/datas/users.dat").map(_.split("::"))
 case class User(userId: String, gender: String,age:Int, occupation: String, zip: String)
 val rdd2=user.map(x=>User(x(0),x(1),x(2).trim.toInt,x(3),x(4)))
val usersDF=rdd2.toDF()

 使用sql风格来查看rating.dat 中评分为5分的数据信息
ratingsDF.createOrReplaceTempView("rating_temp")
spark.sql("select * from rating_temp where rating=5.0").show()

 使用sql语句来查看user.dat中年龄大于20岁的用户数据信息
 usersDF.createOrReplaceTempView("user_temp")
 spark.sql("select * from user_temp where age>20").show()

 val data=spark.read.option("header","true").csv("/datas/student_info.txt")
data.printSchema()
 data.select("stu_no","stu_name").show(3)


 # 使用dsl风格来查看rating.dat中用户ID,电影ID,评分等数据信息
 scala> ratingsDF.printSchema
root
 |-- userId: string (nullable = true)
 |-- movieID: string (nullable = true)
 |-- rating: string (nullable = true)
 |-- timestamp: long (nullable = false)


scala> ratingsDF.select("userID","movieID","rating").show(3)
+------+-------+------+
|userID|movieID|rating|
+------+-------+------+
|     1|   1193|     5|
|     1|    661|     3|
|     1|    914|     3|
+------+-------+------+
only showing top 3 rows


 */