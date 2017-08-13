package com.spark.huyang

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming._
import org.apache.spark.storage.StorageLevel._
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.dstream.ForEachDStream

object Streaming {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    val streamContext = new StreamingContext(conf,Seconds(3))
    val lines = streamContext.socketTextStream("localhost", 9090, MEMORY_AND_DISK_SER_2)
    val words = lines.flatMap(x => x.split(" "))
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)

    //wordCounts.print()
    def printValues(stream:DStream[(String, Int)], streamContext : StreamingContext) {
      stream.foreachRDD(myPrint)
      def myPrint = (rdd : RDD[(String, Int)]) => {
        val array = rdd.collect()
        println("----------------Starting print--------------")
        for(res <- array){
          println(res)
        }
        println("----------------Finished print--------------")
      }
    }

    printValues(wordCounts, streamContext)
    streamContext.start()
    streamContext.awaitTermination()
  }
}
