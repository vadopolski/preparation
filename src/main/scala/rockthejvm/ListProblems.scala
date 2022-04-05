package rockthejvm

import scala.annotation.tailrec
import scala.util.Random

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

  def map[S](f: T => S): RList[S]

  def flatMap[S](f: T => RList[S]): RList[S]

  def filter(f: T => Boolean): RList[T]

  def rle: RList[(T, Int)]

  def duplicateEach(k: Int): RList[T]

  def rotate(k: Int): RList[T]

  def sample(k: Int): RList[T]
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

  override def map[S](f: Nothing => S): RList[S] = RNil

  override def flatMap[S](f: Nothing => RList[S]): RList[S] = RNil

  override def filter(f: Nothing => Boolean): RList[Nothing] = RNil

  override def rle: RList[(Nothing, Int)] = RNil

  override def duplicateEach(k: Int): RList[Nothing] = RNil

  override def rotate(k: Int): RList[Nothing] = RNil

  override def sample(k: Int): RList[Nothing] = RNil
}

case class ::[+T](override val head: T, override val tail: RList[T]) extends RList[T] {
  override def isEmpty: Boolean = false

  override def headOption: Option[T] = Some(head)

  /**
   * O(N)
   * */
  override def toString: String = {
    def toStringTailRec(acc: String, tail: RList[T]): String = {
      if (tail.isEmpty) acc
      else if (tail.tail.isEmpty) acc + s"${tail.head},"
      else toStringTailRec(acc + s"${tail.head},", tail.tail)
    }

    toStringTailRec("", this)
  }

  /**
  * O(i)
  * */
  override def apply(i: Int): T = {
    if (i < 0) throw new NoSuchElementException

    @tailrec
    def applyTailRec(count: Int, rest: RList[T]): T = {
      if (count == i) rest.head
      else applyTailRec(count + 1, rest.tail)
    }

    applyTailRec(0, this)
  }

  /**
   * O(N)
   *  */
  override def length: Int = {
    @tailrec
    def lengthTailRec(rest: RList[T], acc: Int): Int = {
      if (rest.isEmpty) acc
      else lengthTailRec(rest.tail, acc + 1)
    }

    lengthTailRec(this.tail, 1)
  }

  /** O(N)
   *  */
  override def reverse: RList[T] = {
    @tailrec
    def reverseTailRec(reversed: RList[T], rest: RList[T]): RList[T] = {
      if (rest.isEmpty) reversed
      else reverseTailRec(rest.head :: reversed, rest.tail)
    }

    reverseTailRec(RNil, this)
  }

  /** O(N) + O(N)
  * */
  override def ++[S >: T](anotherList: RList[S]): RList[S] = {
    @tailrec
    def addTailRec(toAdd: RList[S], tail: RList[S]): RList[S] = {
      if (toAdd.isEmpty) tail
      else addTailRec(toAdd.tail, toAdd.head :: tail)
    }

    addTailRec(this.reverse, anotherList)
  }


/**
 * O(K) + O(K)
 * */
  override def removeAt(index: Int): RList[T] = {
    @tailrec
    def removeAtTailRec(begin: RList[T], end: RList[T], i: Int): RList[T] = {
      if (i == index) begin.tail.reverse ++ end
      else removeAtTailRec(end.head :: begin, end.tail, i + 1)
    }

    removeAtTailRec(RNil, this, 0)
  }
  override def map[S](f: T => S): RList[S] = {
    @tailrec
    def mapTailRec(mapped: RList[S], rest: RList[T]): RList[S] = {
      if (rest.isEmpty) mapped
      else mapTailRec(f(rest.head) :: mapped, rest.tail)
    }

    mapTailRec(RNil, this).reverse
  }

  override def flatMap[S](f: T => RList[S]): RList[S] = {

    /**
     * Z - sum of all elements
     * O(Z^2)
     * */
    @tailrec
    def mapTailRec(flatMapped: RList[S], rest: RList[T]): RList[S] = {
      if (rest.isEmpty) flatMapped
      else mapTailRec(f(rest.head).reverse ++ flatMapped, rest.tail)
    }


      /**
       * [1, 2, 3] => [[6,3],[4,2],[2,1]]
       * concatenateAll( [6,3],[4,2],[2,1], [], [])
       * concatenateAll( [4,2],[2,1], [6,3], [])
       * concatenateAll( [4,2],[2,1], [3], [6])
       * concatenateAll( [4,2],[2,1], [], [3, 6])
       * concatenateAll( [2,1], [4,2], [3, 6])
       * concatenateAll( [2,1], [2], [4, 3, 6])
       * concatenateAll( [2,1], [], [2, 4, 3, 6])
       * concatenateAll( [], [2,1], [2, 4, 3, 6])
       * concatenateAll( [], [], [1, 2, 2, 4, 3, 6])
       * */
    /**
     * O(Z)
     * */
      @tailrec
    def concatenateAll(in: RList[RList[S]], current: RList[S], acc: RList[S]):RList[S] = {
      if (in.isEmpty && current.isEmpty) acc
      else if (current.isEmpty) concatenateAll(in.tail, in.head, acc)
      else concatenateAll(in, current.tail, current.head :: acc)
    }

    /**
     * O(Z)
     * */
    @tailrec
    def betterConcatenate(rest: RList[T], acc: RList[RList[S]]):RList[S]  = {
      if(rest.isEmpty) concatenateAll(acc, RNil, RNil)
      else {
        val value = f(rest.head).reverse :: acc
        betterConcatenate(rest.tail, value)
      }
    }

//    mapTailRec(RNil, this).reverse
    betterConcatenate(this, RNil)

  }
  override def filter(f: T => Boolean): RList[T] = {
    @tailrec
    def mapTailRec(filtered: RList[T], rest: RList[T]): RList[T] = {
      if (rest.isEmpty) filtered
      else if (f(rest.head)) mapTailRec(rest.head :: filtered, rest.tail)
      else mapTailRec(filtered, rest.tail)
    }

    mapTailRec(RNil, this).reverse
  }
  override def rle: RList[(T, Int)] = {
    @tailrec
    def rleTailRec(rest: RList[T], acc: RList[(T, Int)]): RList[(T, Int)] = {
      if (rest.isEmpty) acc
      else if (rest.head == acc.head._1) rleTailRec(rest.tail, (acc.head._1, acc.head._2 + 1) :: acc.tail)
      else rleTailRec(rest.tail, (rest.head, 1) :: acc)
    }

    rleTailRec(this, (this.head, 0) :: RNil).reverse
  }
  override def duplicateEach(k: Int): RList[T] = {
    @tailrec
    def duplicateTailRec(rest: RList[T], acc: RList[T], i: Int): RList[T] = {
      if (rest.isEmpty) acc
      else if (i == 0) duplicateTailRec(rest.tail, acc, k)
      else duplicateTailRec(rest, rest.head :: acc, i - 1)
    }

    duplicateTailRec(this, RNil, k).reverse
  }
  override def rotate(k: Int): RList[T] = {
    /**
     * 3
     * rotateTailRec([1, 2, 3, 4, 5, 6], [], 0 )
     * rotateTailRec([2, 3, 4, 5, 6], [1], 1 )
     * rotateTailRec([3, 4, 5, 6], [2, 1], 2 )
     * rotateTailRec([4, 5, 6], [3, 2, 1], 3 )
     * [4, 5, 6, 1, 2, 3]
     * */

    if (k > this.length) throw new NoSuchElementException

    @tailrec
    def rotateTailRec(rest: RList[T], acc: RList[T], count: Int): RList[T] = {
      if (count == k) rest ++ acc.reverse
      else rotateTailRec(rest.tail, rest.head :: acc, count + 1)
    }

    rotateTailRec(this, RNil, 0)

  }
  override def sample(k: Int): RList[T] = {
    val random = new Random(System.currentTimeMillis())

    @tailrec
    def sampleTailrec(count: Int, acc: RList[T]): RList[T] = {
      if (count == 0) acc
      else {
        val i = random.nextInt(this.length)
        sampleTailrec(count - 1, this.apply(i) :: acc)
      }
    }

    sampleTailrec(k, RNil)
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

  //  println(smallList.removeAt(3))
  //  println(largeList.map(x => x * x))
  //  println(largeList.filter(x => x % 2 == 0))
  //  println(largeList.flatMap(x => x :: 2*x :: RNil))

//  val rleList = 1 :: 1 :: 2 :: 3 :: 3 :: 3 :: 3 :: 3 :: 4 :: 4 :: 4 :: 5 :: 6 :: RNil

  //  println(rleList.rle)
  //  println(rleList.duplicateEach(2))
  //  println(rleList.rotate(4))
  //println(rleList.sample(4))

  val time = System.currentTimeMillis()
  println(largeList.flatMap(x => x :: (x * 2) :: RNil))
  println(System.currentTimeMillis() - time)

  // 1728
  // 1557
}