package chater08

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._

object studentProject extends Serializable {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .config("hive.metastore.uris", "thrift://master:9083")
      .appName("studentProject")
      .config("spark.sql.shuffle.partitions", "4")
      .config("spark.some.config.option", "some-value")
      .master("local[2]")
      .enableHiveSupport()
      .getOrCreate()

    // 加载数据表并去除空值
    val student = spark.table("studentProject.student").na.drop()
    val course = spark.table("studentProject.course").na.drop()
    val score = spark.table("studentProject.score").na.drop()

    // 查询所有学生的学号和姓名
    val studentInfo = student.select("s_id", "s_name")
    studentInfo.show()

    // 查询每个学生的选课总数
    val courseCount = score.select("s_id", "c_id").groupBy("s_id").count()
    courseCount.show()

    // 查询所有课程的总成绩
    val totalScore = score.groupBy("c_id").sum("s_score")
    totalScore.show()

    // 查询课程分数低于60的姓名和分数
    val lowScore = score
      .join(student, score("s_id") === student("s_id"))
      .join(course, score("c_id") === course("c_id"))
      .filter(course("c_name") === "数学")
      .filter(score("s_score") < 60)
      .select(student("s_name"), score("s_score"), course("c_name"))
    lowScore.show()
    //查询学生的平均成绩以及名次
    val avgScore=score.groupBy("s_id").avg("s_score")
      .withColumnRenamed("avg(s_score)","avg_score")
      .sort("s_id","avg_score")
    avgScore.show()

    //使用join和where语句查询课程名称为“数学”的课程 分数低于60的学生的姓名和分数
    val lowScore2 = score
      .join(student, score("s_id") === student("s_id"))
      .join(course, score("c_id") === course("c_id"))
      .where(course("c_name") === "数学" and score("s_score") < 60)
      .select(student("s_name"), score("s_score"), course("c_name"))
    lowScore2.show()

    //使用groupBy join sum count withColumn col selectExpr drop cast 查询学生的平均成绩以及名次
val avgScoreRanking = score.groupBy("s_id")
  .agg(avg("s_score").as("avg_score"))
  .withColumn("rank", row_number().over(
    Window.partitionBy().orderBy(desc("avg_score"))))
  .selectExpr("s_id", "avg_score", "rank as student_rank")
    avgScoreRanking.show()



  }
}
