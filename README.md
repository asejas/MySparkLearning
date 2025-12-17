# MySparkLearning
Spark projects I implement to learn more about it.

To use the log4j configuration file for logs, the following VM options should be added:

```
-Dlog4j.configuration=file:log4j.properties 
-Dspark.yarn.app.container.log.dir=local-logs 
-Dlogfile.name=your_log_file_name
```
## Hello World Spark
Location: helloworld package. [->](src/main/scala/dev/asejas/mysparklearning/helloworld/HelloWorldSpark.scala)     
Description: HelloWorld example, just creates spark session and log a message.

## Csv to Parquet
Location: csvtoparquet package. [->](./src/main/scala/dev/asejas/mysparklearning/csvtoparquet/CsvToParquet.scala)    
Description: Reads a compressed CSV file (sample file copied from: github.com/datablist/sample-csv-files), convert the content (dataframe) to parquet and exports to parquet. 

## Csv to Parquet Unit test
Location: csvtoparquet package in test folder. [->](./src/test/scala/dev/asejas/mysparklearning/csvtoparquet/CsvToParquetTest.scala)   
Description: Test readCustomersCsv and saveAsParquet methods from CsvToParquet job.  

Note: Runs fine using JDK8 but with JDK22 there is an exception that can be solved adding the following VM option:
```--add-exports java.base/sun.nio.ch=ALL-UNNAMED```

