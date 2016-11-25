package com.polsys.csv

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row

object MainMethod {
  def main (args:Array[String]){
    
    val row = Row(1, true, "a string", null)
    
// row: Row = [1,true,a string,null]
val firstValue = row(0)
// firstValue: Any = 1
val fourthValue = row(3)
    printf(firstValue+"\t"+fourthValue)
    
  }
}