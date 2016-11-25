package com.polsys.csv

import java.text.SimpleDateFormat

import org.apache.spark.sql.Row
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.LongType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.DataFrameReader
import org.apache.spark.sql.Dataset



object MainObject {
	def main(args:Array[String]){
		    
	      val sparksess=getSparkSession()
				val sqL = new SQLContext(sparksess.sparkContext)
				val df = sparksess.read.format("com.databricks.spark.csv").option("header", "true").option("inferSchema", "true").load("Eg.csv")

				val rdd = dateRDD("DOB","dd-MM-yy","MM-dd-yyyy")(df)

				val schema = df.schema
				val dff = sqL.createDataFrame(rdd, schema)
				dff.write.mode(SaveMode.Overwrite)csv("vaij")
	}

	def getSparkSession() = {
			SparkSession
			.builder.master("local")
			.appName("Spark SQL basic example")
			.config("spark.sql.warehouse.dir", "file:///c:/temp/spark-warehouse")
			.getOrCreate()
	}
	def dateRDD(colnm:String, inFormat:String, outFormat:String)(df:Dataset[Row]) = {
			df.rdd.map { x => 
			var r = x.toSeq.toArray
			var arr = x.getString(x.schema.fieldIndex(colnm))
			r(x.schema.fieldIndex(colnm)) = new SimpleDateFormat(outFormat).format(new SimpleDateFormat(inFormat).parse(arr))
			Row.fromSeq(r.toSeq)
			}
	}
}