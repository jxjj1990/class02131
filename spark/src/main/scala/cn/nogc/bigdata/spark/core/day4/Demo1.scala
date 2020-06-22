package cn.nogc.bigdata.spark.core.day4

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * description: Demo1 
 * date: 2020/6/5 9:58 
 * author: nogc
 * version: 1.0 
 */
object Demo1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("rdd")
    val sc = new SparkContext(conf)


    // TODO Scala - 转换算子 - sample - 抽取数据
    val numRDD: RDD[Int] = sc.makeRDD(List(1,2,3,4))

    // 第一个参数表示数据抽取后是否放回到数据集中
    //   取值为true，表示放回，如果取值为false，那么表示不放回
    // 第二个参数
    //   如果抽取不放回，表示数据被抽取的几率，取值范围 [0 - 1]
    //val rdd: RDD[Int] = numRDD.sample(false, 0.5)
    //   如果抽取放回，表示数据可能被抽取的次数, 取值应该大于等于1
    //val rdd: RDD[Int] = numRDD.sample(true, 2)
    // 第三个参数表示随机数种子
    val rdd1: RDD[Int] = numRDD.sample(false, 0.5, 5)
    val rdd2: RDD[Int] = numRDD.sample(false, 0.5, 5)

    println(rdd1.collect().mkString(","))
    println(rdd2.collect().mkString(","))

    sc.stop()

  }
}
