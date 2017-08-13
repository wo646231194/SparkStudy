package com.spark.huyang

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

object Sql {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val sparkContext = new SparkContext(conf)
    val sqlContext = new SQLContext(sparkContext)

    val path = "D:\\cache\\data.json"
    val data = sparkContext.textFile(path)

    val dataFrame = sqlContext.read.json(path)

    dataFrame.registerTempTable("T")
    dataFrame.printSchema()

    println("Print all records")
    sqlContext.sql("select * from T").collect().foreach(println)

    println("Print name of records")
    sqlContext.sql("select name from T").collect().foreach(println)

    println("Print total age of name")
    sqlContext.sql("select * from T").groupBy("name").agg(Map("age"->"sum")).collect().foreach(println)
  }
}
