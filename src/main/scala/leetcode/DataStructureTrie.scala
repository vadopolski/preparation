package leetcode

import scala.collection.mutable

object DataStructureTrie extends App {

  case class TrieNode(
                       children: mutable.HashMap[Character, TrieNode] = new mutable.HashMap[Character, TrieNode](),
                       var isWord: Boolean = false)

  case class WordDictionary(var trie: TrieNode = TrieNode()) {

    def addWord(word: String): Unit = {
      var node = trie
      word.foreach { ch =>
        if (!node.children.contains(ch)) {
          node.children.put(ch, TrieNode())
        }
        node = node.children(ch)
      }
      node.isWord = true
    }


    def searchInNode(word: String, n: TrieNode): Boolean = {
      var node = n
      /** Для каждой буквы из слова проверяем есть ли она в цепочке */
      for (i <- 0 until word.length) {
        val char = word.charAt(i)
        if (node.children.contains(char)) node = node.children(char)
        else {
          if (char == '.') {
            node.children.values.foreach { child =>
              if (searchInNode(word.substring(i + 1), child)) return true
            }
          }
          return false
        }
      }
      node.isWord
    }
  }

  val wordDictionary = WordDictionary()

  wordDictionary.addWord("oath")
  wordDictionary.addWord("dig")
  wordDictionary.addWord("dog")
  wordDictionary.addWord("dogs")

  println(wordDictionary.searchInNode("dogs", wordDictionary.trie))
  println(wordDictionary.searchInNode(".ags", wordDictionary.trie))


}
