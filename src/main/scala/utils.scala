object utils {

  def calculateRunTime[T](operation: => T): Float = {
    val start = System.currentTimeMillis()
    operation
    val end = System.currentTimeMillis()
    (end - start) / 1000.toFloat
  }
}
