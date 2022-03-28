import scala.annotation.tailrec

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

  def size: Int
}

case object End extends Tree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException
  override def left: Tree[Nothing] = throw new NoSuchElementException
  override def right: Tree[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true

  override def isLeaf: Boolean = false
  override def collectLeaves: List[Tree[Nothing]] = List()
  override def leafCount: Int = 0
  override def size: Int = 0
}

case class Node[+T](override val value: T, override val left: Tree[T], override val right: Tree[T]) extends Tree[T] {
  override def isEmpty: Boolean = false
  override def isLeaf: Boolean = left == End && right == End
  override def collectLeaves: List[Tree[T]] = collectHelper(List.empty[Tree[T]], this)
  override def leafCount: Int = collectLeaves.size
  override def size: Int = countSize(0, this)

  def collectHelper[T](acc: List[Tree[T]], tree: Tree[T]): List[Tree[T]] = {
    if (tree.isEmpty) acc
    else if (tree.isLeaf) acc :+ tree
    else collectHelper(acc, tree.left) ++ collectHelper(acc, tree.right)
  }

  def countSize[T](acc: Int, tree: Tree[T]): Int = {
    if (tree.isEmpty || tree.isLeaf) acc
    else {
      val t = acc + 1
      println(tree)
      println(t)

      countSize(t, tree.left) + countSize(t, tree.right)
    }
  }

}

object Tree extends App {
  val tree: Node[String] =

  /**
   *                  Root
   *            /                   \
   *          Left                 Right
   *        /     \              /         \
   * Inner1_Left Inner2_Right  Inner1_Left Inner5_Right
   *    /
   *  Inner1_1_Left
   *
  * */


  Node("Root",
    Node("Left",
      Node("Inner1_Left",
        End,
//        Node("Inner1_1_Left", End, End),
        End),
      Node("Inner2_Right", End, End)),
    Node("Right",
      Node("Inner1_Left", End, End),
      Node("Inner5_Right", End, End)
    )
  )

//  println(tree.isLeaf)
//  println(tree.left.isLeaf)
//  println(tree.right.isLeaf)
//  println(tree.collectLeaves)
//  println(tree.leafCount)
  println(tree.size)

}