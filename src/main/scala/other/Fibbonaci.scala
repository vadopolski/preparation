package other

object Fibbonaci extends App {

  def fib(N: Int): Int = {
    if (N == 0) return 0
    (1 until N).foldLeft(0, 1) {
      case (fib, i) => (fib._2, fib._1+fib._2)
    }._2
  }

}
