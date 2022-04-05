package strings

object ParenthesisProblems extends App {
  def testParenthesis(in: String): Boolean = {
    def testParenthesisHelper(count: Int, rest: String): Boolean = {
      if (rest.isEmpty && count == 0) true
      else if (rest.isEmpty) false
      else if (rest.head == ')' && count == 0) false
      else if (rest.head == ')') testParenthesisHelper(count - 1, rest.tail)
      else testParenthesisHelper(count + 1, rest.tail)
    }

    if (in.isEmpty) false
    else testParenthesisHelper(0, in)
  }

  println(testParenthesis("(((()))))"))
  println(testParenthesis("()"))
  println(testParenthesis(")))((("))
  println(testParenthesis("()()(())"))

  def genValidParenthesis(n: Int): List[String] = {

    def genValidParenthesisHelper(rest: Int, acc: Set[String]): Set[String] = {
      if(rest == 0) acc
      else {
        val newString = for {
          string <- acc
          index <- (0 until string.length)
        } yield {
          val (before, after) = string.splitAt(index)
          s"$before()$after"
        }

        genValidParenthesisHelper(rest - 1, newString)
      }
    }
    assert(n >= 0)

    if(n == 0) List()
    else genValidParenthesisHelper(n, Set("()")).toList


  }

  println(genValidParenthesis(1))
  println(genValidParenthesis(2))
  println(genValidParenthesis(3))







}
