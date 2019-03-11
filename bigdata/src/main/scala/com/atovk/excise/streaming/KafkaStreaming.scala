package com.atovk.excise.streaming

import kafka.common.OffsetAndMetadata
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.TopicPartition
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

object KafkaStreaming {


  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    val sparkStreaming = new StreamingContext(sc, Seconds(2))


    val zks = "10.0.37.226:2181,10.0.37.227:2181,10.0.37.228:2181,10.0.37.229:2181,10.0.37.230:2181"
    val bokers = "10.0.37.226:9092,10.0.37.227:9092,10.0.37.228:9092,10.0.37.229:9092,10.0.37.230:9092"
    val groupId = "group_"
    val topic = "".split(",").toSet

    val offsets = Map[TopicPartition, Long]()


    val kafkaParams = Map[String, Object](
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> bokers,
      ConsumerConfig.GROUP_ID_CONFIG -> groupId,
      ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer],
      ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG -> classOf[StringDeserializer])

    val messages = KafkaUtils.createDirectStream(sparkStreaming, LocationStrategies.PreferConsistent,
      ConsumerStrategies.Subscribe(topic, kafkaParams, offsets))
    sparkStreaming.start()
    sparkStreaming.awaitTermination()

  }


}
