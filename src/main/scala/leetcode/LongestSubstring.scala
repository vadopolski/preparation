package leetcode

object LongestSubstring extends App {

  val s = "abcabcbb"


  def lengthOfLongestSubstring(s: String): Int = {
    val strings = s.foldLeft(List("")) {
      case (acc, el) if acc.head.contains(el) =>
        List(el.toString) ++ acc
      case (acc, el) =>
        (acc.head + el) :: acc.tail
    }

    strings.map(_.length).max
  }

  println(lengthOfLongestSubstring(s))


}
