package com.guru.first.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by linjingu on 2018/5/18.
  */
object FirstRDD {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("FirstSpark")
    //setMaster("local") 本机的spark就用local，远端的就写ip
    //如果是打成jar包运行则需要去掉 setMaster("local")因为在参数中会指定。
    conf.setMaster("local")
    val sc = new SparkContext(conf)
    val arr = Array("cat", "dog", "lion", "monkey", "mouse")
    // create RDD by collection
    val rdd = sc.parallelize(arr)
    val result = rdd.collect()
    print(result)
  }
}
