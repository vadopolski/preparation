sealed abstract class Tree[+T] {
  def value: T
  def left: Tree[T]
  def right: Tree[T]
  def isEmpty: Boolean

  def isLeaf: Boolean = this match {
    case Node(_, _, _) => true
    case End => false
  }
  def collectLeaves: List[Tree[T]]
  def leafCount: Int
}

case object End extends Tree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException
  override def left: Tree[Nothing] = throw new NoSuchElementException
  override def right: Tree[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true

  override def isLeaf: Boolean = false
  override def collectLeaves: List[Tree[Nothing]] = List()
  override def leafCount: Int = 0

}

case class Node[+T](override val value: T, override val left: Tree[T], override val right: Tree[T]) extends Tree[T] {
  override def isEmpty: Boolean = false
  override def isLeaf: Boolean = left == End && right == End
  override def collectLeaves: List[Tree[T]] = collectHelper(List.empty[Tree[T]], this)
  override def leafCount: Int = collectLeaves.size

  def collectHelper[T](acc: List[Tree[T]], tree: Tree[T]):List[Tree[T]] = {
    if(tree.isEmpty) acc
    else if (tree.isLeaf) acc :+ tree
    else collectHelper(acc, tree.left) ++ collectHelper(acc, tree.right)

  }

}

object Tree extends App {
  val tree: Node[String] = Node("Root", Node("Left", Node("Inner1", End, End), Node("Inner2", End, End)), Node("Right", Node("Inner1", End, End), Node("Inner5", End, End)))

  println(tree.isLeaf)
  println(tree.left.isLeaf)
  println(tree.right.isLeaf)
  println(tree.collectLeaves)
  println(tree.leafCount)

}
