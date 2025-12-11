ThisBuild / name := "MySparkLearningProject"
ThisBuild / organization := "dev.asejas.mysparklearning"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "MySparkLearning"
  )

val sparkVersion = "3.5.0"

val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.19" % "test"
)

libraryDependencies ++= sparkDependencies ++ testDependencies

logBuffered in Test := false