package Arrays

object ContainsDuplicate {
  def containsDuplicate(nums: Array[Int]): Boolean = {
    val num = nums.sorted
    for(i <- 0 until num.length-1){
      println(num(i),num(i+1))
        if(num(i)==num(i+1)){
          return true
        }
    }
    false
  }

  def main(args: Array[String]): Unit = {
    println(containsDuplicate(Array(1,2,3,1)))
  }
}
