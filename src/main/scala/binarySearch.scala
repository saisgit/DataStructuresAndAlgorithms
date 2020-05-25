import scala.annotation.tailrec
import utils._

object binarySearch {
  def main(args: Array[String]): Unit = {

    def binarySearch_iterative(arr: Array[Int], target: Int): Int = {
      var (start, end) = (0, arr.length - 1)
      var mid = start + (end - start) / 2

      while (start <= end) {
        mid = start + (end - start) / 2
        if (arr(mid) == target)
          return mid
        if (arr(mid) > target) end = mid - 1
        else
          start = mid + 1
      }
      -1
    }

    def binarySearch_Recursive(list: Array[Int], target: Int)
                              (start: Int = 0, end: Int = list.length - 1): Int = {
      if (start > end) -1
      val mid = start + (end - start + 1) / 2
      if (list(mid) == target)
        mid
      else if (list(mid) > target)
         binarySearch_Recursive(list, target)(start, mid - 1)
      else
         binarySearch_Recursive(list, target)(mid + 1, end)
    }

    def binarySearch_tailRec(arr: Array[Int], target: Int): Int = {
      @tailrec
      def bs_helper(arr: Array[Int], target: Int, start: Int, end: Int): Int = {
        if (start > end) return -1
        val mid = start + (end - start) / 2
        arr(mid) match {
          case i if (i == target) => mid
          case i if (i > target) => bs_helper(arr, target, start, mid - 1)
          case _ => bs_helper(arr, target, mid + 1, end)
        }
      }

      bs_helper(arr, target, 0, arr.length - 1)
    }


    val arr = Array(1, 2, 4, 5, 6, 7)
    val target = 7

    val iterativeRuntime = calculateRunTime {
      println(binarySearch_iterative(arr, target) match {
        case -1 => s"$target doesn't exist in ${arr.mkString("[", ",", "]")}"
        case index => s"$target exists at index $index"
      })
    }
    println(s" Iterative binaryseach total run time =  $iterativeRuntime seconds OR ${iterativeRuntime * 1000} milliseonds")

    val recursive_runtime = calculateRunTime {
      println(binarySearch_Recursive(arr, target)() match {
        case -1 => s"$target doesnt match"
        case index => s"$target exists at $index"
      })
    }


    println(s" recursive binaryseach total run time =  $recursive_runtime seconds OR ${recursive_runtime * 1000} milliseonds")


    val tailrec_runtime = calculateRunTime {
      println(binarySearch_tailRec(arr, target) match {
        case -1 => s"$target doesnt match"
        case index => s"$target exists at $index"
      })
    }


    println(s" TailRec binaryseach total run time =  $tailrec_runtime seconds OR ${tailrec_runtime * 1000} milliseonds")


  }
}
