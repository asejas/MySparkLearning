# MySparkLearning
Spark projects I implement to learn more about it.

To use the log4j configuration file for logs, the following VM options should be added:

## Hello World Spark
Location: helloworld package. [->](src/main/scala/dev/asejas/mysparklearning/helloworld/HelloWorldSpark.scala)
Description: HelloWorld example, just creates spark session and log a message.

## Csv to Parquet
Location: csvtoparquet package. [->](./src/main/scala/dev/asejas/mysparklearning/csvtoparquet/CsvToParquet.scala)
Description: Reads a compressed CSV file (sample file copied from: github.com/datablist/sample-csv-files), convert the content (dataframe) to parquet and exports to parquet. 

## Csv to Parquet Unit test
Location: csvtoparquet package in test folder. [->](./src/test/scala/dev/asejas/mysparklearning/csvtoparquet/CsvToParquetTest.scala)
Description: Test readCustomersCsv and saveAsParquet methods from CsvToParquet job.
Note: Depending on your environment this VM option can be required to run the tests without errors:
```--add-exports java.base/sun.nio.ch=ALL-UNNAMED```

