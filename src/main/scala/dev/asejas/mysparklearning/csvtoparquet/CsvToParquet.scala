/**
 * Implemented by Alvaro Sejas
 * isoujiro@gmail.com
 */
package dev.asejas.mysparklearning.csvtoparquet

import org.apache.log4j.Logger
import org.apache.spark.sql.{DataFrame, SparkSession}


object CsvToParquet extends Serializable {
  @transient
  lazy val log: Logger = Logger.getLogger(getClass.getName)

  def main(args: Array[String]): Unit = {
    log.info("Starting Csv to Parquet!")

    if (args.length < 2) {
      log.error("Expected: sourceFilename targetPath")
      System.exit(1)
    }
    val sourceFilename = args(0)
    val destinationPath = args(1)
    val spark = createSession

    val customersDF = readCustomersCsv(spark, sourceFilename)
    customersDF.show()
    saveAsParquet(destinationPath, customersDF)

    spark.stop()
    log.info("Ending CsvToParquet!")
  }

  private def createSession = {
    SparkSession.builder()
      .appName("CsvToParquet")
      .master("local[3]")
      .getOrCreate()
  }

  def readCustomersCsv(spark: SparkSession, filename: String): DataFrame = {
    log.info("File to process: " + filename)

    spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(filename)
  }

  def saveAsParquet(Path: String, df: DataFrame): Unit = {
    log.info("Destination path: " + Path)

    df.write
      .format("parquet")
      .mode("overwrite")
      .save(Path)
  }
}
