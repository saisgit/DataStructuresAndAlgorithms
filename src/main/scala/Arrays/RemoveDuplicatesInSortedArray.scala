package Arrays

object RemoveDuplicatesInSortedArray {

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0
    var unique = 0  //initialize unique pointer
    for (i <- 1 until nums.length) { //Starting loop from index-1
      if (nums(i) != nums(unique)) { //Check for non-duplicates
        unique += 1 //Increment the pointer for non-duplicates
        nums(unique) = nums(i) //overwrite duplicate value
        println(nums.toList)
      }
    }
    unique+1 //return the length
  }

  def main(args: Array[String]): Unit = {
    println(removeDuplicates(Array(0,0,1,1,1,2,2,3,3,4)))
  }
}
