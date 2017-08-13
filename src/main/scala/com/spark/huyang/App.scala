package com.spark.huyang

import org.apache.spark.{SparkConf, SparkContext}

object App  {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val sparkContext = new SparkContext(conf)

    val file = "D:\\cache\\test.txt"
    val data = sparkContext.textFile(file)
    val numline = data.filter(line => true).count()
    println("Number of Lines in file "+ file)
    println(" is " + numline)
  }
}
