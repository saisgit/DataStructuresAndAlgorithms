
object romanToInt {
  def romanToInt(s: String): Int = {
    val romans = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
    var res = 0
    for (i <- 0 until s.length - 1) {
      if (romans(s(i)) < romans(s(i + 1))) {
        res = res - romans(s(i))
      }
      else {
        res = res + romans(s(i))
      }
    }
    res = res + romans(s(s.length - 1))
    return res
  }
}
