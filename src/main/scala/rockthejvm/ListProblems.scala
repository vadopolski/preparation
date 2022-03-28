package rockthejvm

import scala.annotation.tailrec

sealed abstract class RList[+T] {
  def head: T
  def tail: RList[T]
  def isEmpty: Boolean
  def headOption: Option[T]
  def ::[S >: T](elem: S): RList[S] = new ::(elem, this)
  def apply(i: Int): T
  def length: Int
  def reverse: RList[T]
  def ++[S >: T](anotherList: RList[S]): RList[S]
  def removeAt(index: Int): RList[T]
}

case object RNil extends RList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: RList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def headOption: Option[Nothing] = None
  override def apply(i: Int): Nothing = throw new NoSuchElementException
  override def length: Int = 0
  override def reverse: RList[Nothing] = RNil
  override def ++[T](anotherList: RList[T]): RList[T] = anotherList
  override def removeAt(index: Int): RList[Nothing] = throw new NoSuchElementException
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false
  override def headOption: Option[T] = Some(head)
  override def toString: String = {
    def toStringTailRec(acc: String, tail: RList[T]): String = {
      if (tail.isEmpty) acc
      else if (tail.tail.isEmpty) acc + s"${tail.head},"
      else toStringTailRec(acc + s"${tail.head},", tail.tail)
    }

    toStringTailRec("", this)
  }
  override def apply(i: Int): T = {
    if (i < 0) throw new NoSuchElementException

    @tailrec
    def applyTailRec(count: Int, rest: RList[T]): T = {
      if (count == i) rest.head
      else applyTailRec(count + 1, rest.tail)
    }

    applyTailRec(0, this)
  }
  override def length: Int = {
    @tailrec
    def lengthTailRec(rest: RList[T], acc: Int): Int = {
      if (rest.isEmpty) acc
      else lengthTailRec(rest.tail, acc + 1)
    }

    lengthTailRec(this.tail, 1)
  }
  override def reverse: RList[T] = {
    @tailrec
    def reverseTailRec(reversed: RList[T], rest: RList[T]): RList[T] = {
      if (rest.isEmpty) reversed
      else reverseTailRec(rest.head :: reversed, rest.tail)
    }

    reverseTailRec(RNil, this)
  }
  override def ++[S >: T](anotherList: RList[S]): RList[S] = {
    val toAdd = this.reverse

    @tailrec
    def addTailRec(toAdd: RList[S], tail: RList[S]): RList[S] = {
      if(toAdd.isEmpty) tail
      else addTailRec(toAdd.tail, toAdd.head :: tail)
    }

    addTailRec(toAdd, anotherList)
  }
  override def removeAt(index: Int): RList[T] = {

    @tailrec
    def removeAtTailRec(begin: RList[T], end: RList[T], i: Int): RList[T] = {
      if (i == index) begin.tail.reverse ++ end
      else removeAtTailRec(end.head :: begin, end.tail, i + 1)
    }

    removeAtTailRec(RNil, this, 0)


  }
}

object RList {
  def from[T](it: Iterable[T]): RList[T] = {
    @tailrec
    def iterableTailRec(reversed: RList[T], rest: Iterable[T]): RList[T] = {
      if (rest.isEmpty) reversed
      else iterableTailRec(rest.head :: reversed, rest.tail)
    }

    iterableTailRec(RNil, it).reverse
  }
}


object ListProblems extends App {
  val smallList = 1 :: 2 :: 3 :: RNil
  val smallList2 = 3 :: 4 :: 5 :: RNil
  val largeList: RList[Int] = RList.from(1 to 10000)

//  println(largeList.toString)
//  println(largeList.apply(8888))
//  println(largeList.length)
//  println(largeList.reverse.toString)
//
//  println((1 :: 2 :: 3 :: RNil) ++ (3 :: 4 :: 5 :: RNil))
//  println((1 :: 2 :: 3 :: RNil) ++ largeList)
//  println(largeList ++ (1 :: 2 :: 3 :: RNil))

  println(smallList.removeAt(3))
}