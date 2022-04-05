package interview

object FindDuplicate extends App {
  val result = List(List("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), List("root/a/1.txt", "root/c/3.txt"))

  def testContent(input: List[List[String]]): List[List[String]] = {
    val res = input
      .map(x => (x.length, x))
      .groupBy(x => x._1)
      .mapValues(x => x.map(x => x._2))
      .filter(p => p._2.length > 1)

      List(List())
  }
}
