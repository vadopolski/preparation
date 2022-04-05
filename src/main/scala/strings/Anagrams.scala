package strings

object Anagrams extends App {
  def checkAnagrams2(sa: String, sb: String): Boolean = sa.sorted == sb.sorted
  def checkAnagrams(sa: String, sb: String): Boolean = countCharacters(sa) == countCharacters(sb)

  def countCharacters(s: String): Map[Char, Int] = {
    s.foldLeft(Map.empty[Char, Int]) {
      case(acc, el) if acc.contains(el) => acc + (el -> (acc(el) + 1))
      case(acc, el) => acc + (el -> 1)
    }
  }

  assert(countCharacters("desserts") == countCharacters("stressed"))
  assert(countCharacters("Scala") != countCharacters("Haskell"))
  assert(countCharacters("desserts") == countCharacters("stressed"))
  assert(countCharacters("Scala") != countCharacters("Haskell"))
  assert(countCharacters("test") != countCharacters("testa"))
  assert(countCharacters("test") == countCharacters("stet"))


}
