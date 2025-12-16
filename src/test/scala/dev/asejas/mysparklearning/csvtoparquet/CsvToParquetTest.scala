package dev.asejas.mysparklearning.csvtoparquet

import org.apache.spark.sql.SparkSession
import org.scalatest.BeforeAndAfterAll
import org.scalatest.funsuite.AnyFunSuite
import dev.asejas.mysparklearning.csvtoparquet.CsvToParquet.readCustomersCsv
import dev.asejas.mysparklearning.csvtoparquet.CsvToParquet.saveAsParquet

class CsvToParquetTest extends AnyFunSuite with BeforeAndAfterAll {
  @transient var spark: SparkSession = _

  override def beforeAll(): Unit = {
    spark = SparkSession.builder()
      .appName("CsvToParquetTest")
      .master("local[3]")
      .getOrCreate()
  }

  override def afterAll(): Unit = {
    spark.stop()
  }

  test("Load sample compressed csv file") {
    val sourcePath = "./data/customers-100.csv.gz"
    val customerSampleDF = readCustomersCsv(spark, sourcePath)
    assert(customerSampleDF.count() == 100, " the file should have 100 rows")
  }

  test("Save dataframe as parquet") {
    val destinationPath = "./test_results/csv_to_parquet/"

    //Sample DF
    val sampleData = Seq(
      ("Alvaro", 20),
      ("Sara", 10),
      ("Rafael", 3),
      ("Carol", 10)
    )
    val sampleRDD = spark.sparkContext.parallelize(sampleData)
    val sampleDataDF = spark.createDataFrame(sampleRDD)

    //Save as one parquet file
    val repartitionedDF = sampleDataDF.repartition(1)
    saveAsParquet(destinationPath, repartitionedDF)

    //Read result
    val resultDF = spark.read.parquet(destinationPath + "*.parquet")
    resultDF.show()
    assert(resultDF.count() == 4, " result parquet file should contain 4 rows")

  }
}
