package Programs
/*
* Check if given number is prime or not
*
* Prime number is a number that is divisible only by itself and 1 (e.g. 2, 3, 5, 7, 11).*/
object PrimeNumberCheck {
 def isPrime(num:Int):Boolean = {
   for (i <- 2 to num/2){
     if (i%num == 0) false
   }
   true
 }

  def main(args: Array[String]): Unit = {
    println(isPrime(19))
  }
}
