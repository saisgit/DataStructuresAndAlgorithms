package Arrays

import scala.collection.mutable
import scala.collection.mutable._

object IntersectionofTwoArraysII {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var num1Map:scala.collection.immutable.Map[Int,Int] = nums1.groupBy(x=>x).mapValues(_.length).toMap
    println(num1Map)
    var r = new ListBuffer[Int]()
    nums2.foreach( n => {
      if(num1Map.contains(n) && num1Map(n) != 0){
        r += n
        num1Map = num1Map.updated(n,num1Map(n)-1)
        println(num1Map)
      }
    })
    r.toArray
  }

  def main(args: Array[String]): Unit = {
    println(intersect(nums1 = Array(4,9,5), nums2 = Array(9,4,9,8,4)).toList)
    println(intersect(nums1 = Array(1,2,2,1), nums2 = Array(2,2)).toList)
  }
}
