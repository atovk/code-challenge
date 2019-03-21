package com.atovk.excise.streaming

import java.io.PrintWriter

import kafka.utils.ZkUtils
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable.ListBuffer

/**
  * https://www.jianshu.com/p/d2a61be73513
  */

object RealTimeSalesOffline {


  def main(args: Array[String]): Unit = {

    // set spark
    val sparkConf = new SparkConf()
      .setMaster("local[4]")
      .setAppName("TestSparkStreamingKafka_HD")
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("spark.dynamicAllocation.enabled", "true")
      .set("spark.streaming.blockInterval", "200")
      .set("spark.streaming.stopGracefullyOnShutdown", "true")
      .set("spark.streaming.backpressure.enabled", "true")
      .set("spark.streaming.backpressure.initialRate", "2")
      .set("spark.streaming.kafka.maxRatePerPartition", "1")

    val sparkContext = new SparkContext(config = sparkConf)
    sparkContext.setLogLevel("warn")
    val ssc = new StreamingContext(sparkContext, Seconds(14))
    //    val sparkSession = SparkSession.builder().enableHiveSupport().getOrCreate()
    // set zk
    val zkServers = "10.0.37.226:2181,10.0.37.227:2181,10.0.37.228:2181,10.0.37.229:2181,10.0.37.230:2181"
    val zkClient = ZkUtils.createZkClient(zkServers, 30000, 30000)


    // set kafka
    val brokers = "10.0.37.226:9092,10.0.37.227:9092,10.0.37.228:9092,10.0.37.229:9092,10.0.37.230:9092"
    val topics = "bms133"
    val groupId = "Group_bms133_SparkRealTimeSalesOffline_fresh"

    val topicsSet = topics.split(",").toSet
    val kafkaParams = Map[String, Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers,
      ConsumerConfig.GROUP_ID_CONFIG -> groupId,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer]
//      ConsumerConfig.AUTO_OFFSET_RESET_CONFIG -> "earliest"
    )

    val offsets = Map[TopicPartition, Long](
      new TopicPartition(topics, 0) -> 32604068 ,
      new TopicPartition(topics, 1) -> 32608032 ,
      new TopicPartition(topics, 2) -> 32607120 ,
      new TopicPartition(topics, 3) -> 32604444 ,
      new TopicPartition(topics, 4) -> 32604787
    )

    val messages = KafkaUtils.createDirectStream[String, String](
      ssc, LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe[String, String](topicsSet, kafkaParams, offsets))


    var offsetRanges: Array[OffsetRange] = Array.empty[OffsetRange]
    val printWriter = new PrintWriter("file:records_sheet.txt")
    messages.transform(rdd => {
      offsetRanges = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      rdd
    }).mapPartitions(records => {
      var result = new ListBuffer[String] ()
      records.foreach(tx => {
        println("RECORDS:   ")
        println(tx.value().trim)
        result.+=(tx.value().trim)
        printWriter.write(tx.value().trim)
      })
      result.toIterator
    }).foreachRDD(rdd => {
      if (!rdd.isEmpty()) {
        println("COUNT: " + rdd.count())
//        println(" DATASET: " + rdd.collect().reduce(_+_).toString)
        rdd.collect().foreach(corder => {
          //println(corder.toString)
        })
      }
      offsetRanges.foreach(offsets => println(offsets.toString()))
    })

    ssc.start()
    ssc.awaitTermination()
  }
}
