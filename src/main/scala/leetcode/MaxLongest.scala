package leetcode

object MaxLongest extends App {
  println("Test")
  val s = "abcabc"
//  val s = "aacbacaaabababacabbaaabcacbccbbcbbbaabbbbababccacbaaabaacabcccbcacccbaccabccbccbacbaaabaabbcabcbaacacacbacccababaaccbcabacbbcbabcbbaaabcabbabcabcbccbcaacaaaaacabbccbbbbabaccbaccabababaabaccbaccacabbbccabbaabaccaabaaaacbaabacaacabbcbcbcbbaacbaaabccbbbbbaabcbabacccbcbbacabaabababacccbabbababcbabaccccaaaaababcacaacabbbbaacbaccaaaabbacccbaaaccabcccccaabbcaaccabacbbcbcbcbabbabbacbcaacbcacaabbbcbacaabaacbccbcccaabbcbacbbccccbcaaaccbacabbcbcbacccbcaacccbaabbaccabcbccbbcaccacabcabcaaccccababbbabbacbaabccbacbbabccaacbcaaccabaabacabbcbcbacbbbaacbabaaaccacbcccaacbcbbccbcbaabcbbbcbbcccbacbbacabccccccabccbccbcabcccabcacbcbbbcccccabcaccbcabccacbbaacabbcbccbabbbabcabcaccbabacbaaccacabccbcbacaabbaacccbbcccaabccccbbccabcbabbcbcabccacacbbbabaaccacbccacbbcaaacbbbbaacaccbaaabbbaaaacaacabccccbbcbaccaaababbbaaabbccbabcbbbcaaaaaabbbcbabacaaabaccacbbaabcbaacacaababaaabcacbcacbbbcbbccaaaccabbcccccabcbcaccbcacbcccabaaaaabaacacbcbabaacabcabcbaccbabbababacbbcabbacbabaccabbcbcbaacbcccccccabcaabbcbabbacaabccbbbbbbbccccacaabcbbcabbbbbcbacaaacbcbacccbbcbbbbcbccaaabcacaaabccaaccbcaabaccccaaacacbacbbcbaacbabbcbcabcabbaaccbcbabccccbabbaabcccacabccbccccbcbccbcccbbbacbcacabcabcccabbbbccaaaabbbbbccbbbbabbabaaabbacbbbcbcbcbbbbacbbcbaaaaaacaabababccaaabcacacbbacacccbccabcbabcaaccabacbbccbbacbaabccaacbbccbbccacbbaaccbcbaccbbaacbbcabaababcccacccabbbbcbbbabbcbabacacccbcaacbccacabcbbbaaacbaacccacacaacacccbbbaabcaacabccbbcccbaabbaabaccabaacabbabcabaaabbcccaacbbacbabccacbbacccccbcbcbbacbcaaccaaaabbcabcbcbbabcacbaccbccccccacbbcaaacacabbbbaabbbacabbccccacacabccababccbbbbbcbaabacccaaacaccbcbccbbcacaacbaaacbbcbbccacbbbbbbbcacccaabcacacccbbcacababcabcaaabbcacbcbbbcccabbbcacbbaaabbaacaabbccbaacababbcccaccbacabacabcaaccaabcacabaaccaccccccaabbaccabacacbacaaabbbcbacaccbccbcbcacbcbabbbabcbaccacbbabbbbbbcbaaabaaacccacbcacacbbcaacaacaacbbbcaccacccaababaccbbcaabcabbcbacbacbabccacbbbcaabaacaabccacaccbacabccaccbcacaacbcbccabacaccccabbcbbbbacaacabababccbaaaccabbaaccacbcbaabccababacaabbaccacbabcccbbbbbacbabbccbacccbacbbbcaccaaccaabbbcacbcabcacbbccaabbaacacabbcbbbbcbacacabbcbccaacabbaabcccbaaabcbaccbacacbbbcaabbcaabbcacaccccccbaaaacaccacbbaabbbccbacaabaabcaaaacaacaabbabcbbbcaacaaccbcbcbbabaacccccbccbbacbaccbcccccbccccbcbabccbcbccbbbacabbbacbacbbccabbacababccabbabbbcaacabaccaacbbcbaacccaccccbbbbbcbaabacacacaacbbacacbccbacccbbbacaabbcbcbbcaccbccbbabacbacaccccbbbaaaccccaabaaaacabccaaaaacbbacacababbcccbaaabaaccbabbbaacaccaaaaabaabcaabaaacbbacabaacaaaaaccaacabcbcbacacbabbbbccbcbababbaccaaabbcbbbbbbbbbbcabababcacccaabccaaaacbabcbabbbabacbbaacbacabcaacacbcbcbcccbbcaababccaaabbcbabaabccaaaaabcbaaaabccccccbbccbacbababaaaaaaabbaabacaccaabccacbaccccaabbcaabbcbabacbccccbcbcabbbabaccbaababbbbbbabacbaabbcabbcccbcbcbcabababbccccabbabcaaccaacaaccbcbcbcaccbbabccccbaccbacbbbaccccbabbaaababcbacbbacacabcacabbabbaabaacccbaccbbbccbacccbcabcacababbccccacbbcbbaaacaacbabbabbccacacbbbbbacbaacacacabbbbcabacbbbbbcaabcbccbcababacaaabcaacabababcbbbabbcbbccbccbbbaabababacacbbbcccbccbccbbbcbcaaacacaabcabbabbbcccbababbcbcaabcbccaaacbbacbabababaaccababbbccccbaaaacaaabccababccccbcaabaaacbcbacaacbcaabcabcbabbacbacaacaccbabcaaaabbabcccccbcbabbcbbbbbcaaaaaaaacbbcbcaaacaabbbaaccbbbccacbaccbcabaaccabaabaababcabacbabcccaacccbcccbacbbcbbaaacccbaabaaacccaacbaabbcacbcbbcaccabcbbabbbbcabcaccbbbccabccbccbcccbbcabaaababbbcbaacababbccbcbacacabcabbacbcccacbaacbccccccbacbcbccaaaacaaaccbaacaaaacbccbbcabcaacbaabcbbbbaaacacbbbbcaaaaababbaabacccbabcccabbbcbaaccbcabbcaaabcabccbacbaaabcaabbcccccbbcbacbabaabbcbcaacbbcbbcabacccbccacccabbbabaabcbabccacbbacababcaacababcabaaaacbbbacbcbbacbcabcaaccabbcbcbcacbbcaaaaabbaaaccabbcaaababacbaccbccbbaaaaacbccbacabbcaaaabaccbbbbbbaaacbaaabbcbaacaaaacaccccabcacabacaaaaaabcaccbabacbbbcbbcccbbaabcbacacacabaabbabccbcacaacbcbcbcaaabcbbcacbaccccaaaabaacbbaaaaccbbaacbcacbaaabcbbccbbcabbbbbcabcaacccbaabcbabaccabbcabcabcccbacabcbcbcabcbacbabbacabcccaabcaabbbcbcbccacbcacaaababbacbcccbabbaabccaabcabaaaabaababcccaababccbaaccbbbcbbbbcaabccbabaccccccabbcbbbcbbcbbabcccccabacabcbabcbbaabaaaabaaaabcccbaabacbccabcbabbbcbbaacbcbbbcccbcbaaabbbaccbcaaccacabcabccccaabacacbbbbcacaabaaabbccbbcbbbaccaaccbaaaaaabacbbcccbccbcbacbbaaccbaccaccbcabbcaccbbcacbcbccaccbcccabbcacaaccbbabcaabcccbcacbcbccbccabccbababbcccaccacccbbbbcaccbacbbbabaacababaaaaaaacaccaabbabaabccaaccbabcbcccabcacaacbabaacacbcbccbbbacabccacccabcbabcababbabcacacaacbbcabcbbcbabacbccbaaacabbbabcabbacbaaabbaacbccaaabbcbbcbcaaabbccabaacabcaabcbcbaaabbcbcbbccbbcbbcabacbbbcaaccaacacbbbbcaabaccabcbbabcaccbacbcabbabccbbabbcbababccbbbbabbbabbcbcbcabaacabaccbabacccbaabacbcbcacaabacbaacbccabbcaaabbcccabbbaabbccbcacccabcbcaacbacbcbabababaacbbcbbabababcaaacbcaccbacbbabaccaaaccccbcccaabcacacbcaacbcbaaaacbccbccbaccbbacbcbcaccbbccbccaaccaaabacbaaccacabbbacbbaaacbbbbbbcabbbbcacbabaabababbabbacccbbbbbccbacbbbaacacbbcbcbababcaaacbbacaacacbbcbabcbcaacacaaabcaabbaabccaaacacbbaaaacbabcbacabaaacaaacccacbacbabcbaccbbccccaaccabcbbabccbbccaaabcbaccbcbbabacbcbcaacabacacabcacbbcabaccabcbcababbbacaacacbaacbbbcbacccbbacaccacacbaabcabaabcbcacaacbbbaacbabaaaaccbccbbcccaabacaacbaccabcabcacacabccbbcabbabbabacbbcaabbbcabccacbbaaaacacbbcabccbaccaaabbbbababcbaaccbcbaaabcabacacccaabacccbaaaccaaacbbbaacaabcbcbbcabbbbbbbababacabaaacbacaacbccbaccbacaaabbaacaabccbcabcbaacabacbcabbaaaccbbbbcbbccccaabbccbbcabbaabbccaabcccaacbacabccaacccbcabbaabbcbcbacbacccabbaccbccaacaaabaaccccbcbaaaaccacacaaacbabbcaabbbcacacbaccbbbccbbbbbcacccacabaaacaabaababbbbcccccacbbacaabccbacbbacccbbcbaababbbbbaccccaacbbabacaccbbbcaaccaacacccbcbbbaacbbcccbbcbabacbcbbccbbbbaabbccbcacbaaabcabacbbaaaaabccbabcbbabaacbbccbcbcacccaaacbbaabcbbabbabbccabcbabcbcacaaabbbbababaccccabcbaccbaaccabababcabbcbaaabbbbccabbccbaababaabbaccbcaacbaabaacbccabcbcbbbcccbacaaabaccaaacabaabccbbcccbcccccbbbbaccababcabaabbccabcacabcccbbacccaccbcaaaacaaacbaabbcbcbacabababbbcaacaabccaaacabcabccbcbabaabaacbaabaabccbbaaabacaacaaccbaaacbccabaababbcababcabcaabbcaabbcabcbbbaabcaccccaabccacbbaaaabacaabbcbbbbccccccbbaacbaccababaaccaacbabbcbaacacbbaccaabcaccbbbcaacbaaaaabacbbcbaacbcbbcbcbbaabbbaccbbabbcbcbcccaacabbabacacabbcbccaabacbcabbaabcaababccbccabaccbbbaccbbabcabbbcaacaabcaabcbcaacbcabbcabbcbcbbcacaacaacccbbcaacabaabcccbcbcbbbbbbbbbccbaacbbccbbcbcabcbbbabaccbaabaccccbabcbbbacacbbabbcbbabbbcabaacbaababccbcabaaacbbccbbbabaaacbbbabbbbbccbacbabaccaccbabbabbbcbbabaabbbabcaabaababbacccacacbbccbbbbbbaababacbcccbbaaabbbbbbcabcbcccaccabacababccaaacccaaacbaccccbbcbabcbbcbbbcccabcbbabbcabcaaaccaabbaabbcabccbacbaaaacbcbbabcaccacaacacaaabcbbbcbcabacbbcacbacabbacbccbbacccacbbbbbccbbbcaabbaaabacacbaaabcaacbbcbaaabcbccbcbaabbaaaabababccbcabbcabcbaaccabcabbabbbaaabacaacabbaccacacaaaabaabbabccbcbcacccaaabbacbacbabcbbaaabcaabaaaabaacbbccccbbcaaabccabababbbbccaaaaaacbcbaaccbacbcbaacbabaaababacabbccccbbaacbbbcbacbacbbcacacbbbacaabbcbcaacbabbcabbcabababbaababaccabababbccbcaccaccaabbbcbbcacccccbabccbaacbabacbbabacaabbcccbbccbabaacbccaaacacbaaabacbccbbccbabbaababcbabcbbbabbcabccacbbabcbbbcaacacaabbacabbbcaccabcbbcccbbcbbaaacbcbabccaababbccbbcbabacabacbccaaababaaabaacbaaabacbbbbacbccacaccccbaacccaabaabcbcacbbbabbabbacccabcaccbabaccaaabcbcbcaabbcbacaabcabcccbaabbbbcbcbcbcccaaacaaccbbcaaaacbacacacacaabcbcccbbbbaaccbaabaaabbabcaabccabcbaacacaaabacbcbaccaacabcababbbbaccacacabaccbccbcabbbabcccbaaacabacabbcbcbaaabaccabcccccccbbcabccbcbbabccaaaaabcbcabcbabbbbbaabaaabcccccbccbbcbbcbbabbcbacacaccaabaccbbbabbabaababcccaccbaaababcccabbcaaabacbabbacacababbcacbcccbaaaabbcaacabbcabaabcacbbcacacaacbbbcbacbaababbaacbbbbbccccacaabcaabbcbbcbabcbaabbabccbaccbccaacbbbbbaacbaaabbacccaaabbbbabaaabbaaaabcbbbbacbabbbccbababbcccaabbaabbbaaccccbbbbaabbacabacbcbabacbacbbcacaacccbcccaaacbbccbbcbcbcbcaababcbcbccaacbbcabbbcaaccccaacccbbaccaccaaccbccbccacbcaaaaaabbbaaabaaababbccabccacbbcababcabccbabcbabbbbaabcbcacabaabbbabbbcabaccaaacbbbaaaaabaababbabcabacaccaacabcbcaaacccccbcbcbcbbcccacbabaaaaaacbbcacaccabcccacccabbbcacbcbaacbaccbacbabccbcaccabaaccaacaccaaacbbacccccabbccabbbabaaacacbaccaababccbcaccccacbabacacbcbcccbbbcbcbcabcbacbacbcabccccbcbacbbaabccabcabacbababbaaabbbbaccbababcccbccaabaacababcbbaccacbcacabbcbbbabcacccaccbcccaababccaaccbccbcacabaaabbccbabccbabaccbabbbccccacababbaacbabcbbccccababbcbbbaccacaabbaaccbabcbbabaabcbacacacbbacabcababacbcbaccbbabaaccccbccbbbababababaaaaaaabbbcccbabccbaccacabcbacacccbbbcccaabaacacbabbbcacbccabaccbacccabacaabbacabcabbbcaacbccbccbbbabccccbabacbabacabcccccbacbcabcaaacabaabacababcacbcbabcaacaacbaaabaacaaccaacbcacbbabbcbaccababbcaaacbbaaaaccaaaccbccaccabaaabacbcaaabaccabcabbcccabcaacabbcacabbcbcaccaabbaababccbbccabaccacacbccbaaccbaacbbccabcababcbbacabbacabcbbacaabcbbcaccabcbcccbaccbbcbbbaaaccbcbaaabbbaccbcccbcbccacaabbbcbaabaaabaabcaacabbaacacbcaabcbabccaccaabccaacbabcccbaaccccbbcbbabbabbcbababbabcacabbbbcbabccaccaccababccccaacccabacbbccacacaacbaacaaaccaccccccacbbcacacacabbaaccbbbabbbbbbbccabacccbbcaabababcccbaacacabbccccaaaccbaccbaaacbbaacbbacaabbcacbcbbbccacaccaccacabaabaabacbccbccaccbacbbacacabacbbcaabbacbcbabbaabcacacabbcabbccaccbbcccccbbbbaaccaaabcabbcaabcbaaacacaabaabbbcacabbcaccaacbaaaccabcacaaccacbccbcabbaccbcccbaccbabccabaabbaccbbcaacbbbabbbaabbbacbbbabccaccbbaacaacabbbcababbacbbbbcbccaccabbcaacbcbaacccaacaaaaccaabcbaccabccaacacaaababccacbbbacbbbcbaaacbabbbcccbacaabbcbcabcbbccbaacaccacacbbbbcccccbbbbabcbacabccacaaabbbcbabcacacbbcabaaaabbccabaccaabaccbaccaacaccbaccaabcabacccbbaaccbabcbaacaaaccbcacbaacababacacbaaabcbbcccacacbccaacccbcbcacabcabccbccbbbbbacaaabaaccccacbacbbacabccbccbcaababbbacabcbaaccaaccacacccccaaabbabbbcabaaaaaaabcbbbacababcbbaccbccccaabbbaaabbbccbbcccaccacababbccaababcabbcababbaacacaaabcacbbccbccbbbbcbaaccbcacbbbcacaabcabaccaacacbcacbbccbabcbaccbccacbbcbaababaccaaccababbcbacabaabbaacccaaccaaaabcabcbbbabbccbcabbaaacabcaabccbcabcbabaac"
//  Output: 10
//  Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).


//  def numberOfSubstrings(s: String): Int = {
//    val length = s.length
//    var left = 0
//    var right = 2
//    var ans = 0
//    while (left < length - 2) {
//      val window = s.substring(left, right + 1)
//      println(window)
//      if (window.contains('a') && window.contains('b') && window.contains('c')) {
//        ans += length - right;
//        left += 1;
//      } else {
//        right += 1;
//        if(right == length) return ans;
//      }
//    }
//    return ans;
//  }


//  def findSubstr(s: String): Int = {
//    var left = 0
//    var right = 1
//    val length = s.length
//    var result = 0
//
//    while (left < length - 2) {
//      while (right < length) {
//        val window = s.slice(left, right)
//        println(window)
//        if (window.contains("a") && window.contains("b") && window.contains("c")) {
//          result += (length - (right - 1))
//          return
//        }
//        right += 1
//      }
//
//
//      left += 1
//
//    }
//
////    while (right < length) {
////      val window = s.slice(left, right)
////      println(window)
////      if (window.contains("a") && window.contains("b") && window.contains("c")) {
////        result += (length - (right - 1))
////        return result
////      }
////      right += 1
////    }
////
//
//
//    result
//
//  }

//  println(findSubstr(s))

  def numberOfSubstrings(s: String): Int = {
    var cnt = 0
    var left = 0
    val length = s.length
    var right = 1

    while (left < length) {
      val window = s.slice(left, right)
      println(window)
      if (window.contains("a") && window.contains("b") && window.contains("c")) {
        cnt += (length - (right - 1))
        left += 1
        right += 1
      } else {
        right += 1
        if (right == left) return cnt

      }

      }

    cnt
  }

//    def helper(s: String, cnt: Int):Int = {
//      if (s.isEmpty) cnt
//      else {
//        var acc = 0
//        for (right <- 0 to s.length) {
//          val str = s.substring(0,right)
//          if (str.contains("a") && str.contains("b") && str.contains("c")) acc += 1
//        }
//
//        helper(s.tail, cnt + acc)
//      }
//
//    }
//
//    helper(s, 0)
//  }

//  println(numberOfSubstrings(s))

}