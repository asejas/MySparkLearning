package dev.asejas.mysparklearning.helloworld

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession


object HelloWorldSpark extends Serializable {
  @transient
  lazy val log: Logger = Logger.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.info("Starting Hello World Spark!")

    val spark = SparkSession.builder()
      .appName("Hello World Spark!")
      .master("local[3]")
      .getOrCreate()
    spark.stop()
    log.info("Ending Hello World Spark!")
  }
}
