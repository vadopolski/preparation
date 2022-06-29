package interview

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}

object FindDuplicateScala extends App {

  println("Test")

  /**
   * Example 1:
   *
   * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"]
   * Output: [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
   * Example 2:
   *
   * Input: paths = ["root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"]
   * Output: [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
   *
   *
   * */

  def findDuplicate(paths: Array[String]): List[List[String]] = {

    val tuples = paths.foldLeft(List.empty[(String, String)]) {
      case (acc, el) =>
        val l = el.split(" ")

        val res: List[(String, String)] = l.tail.map { x =>
          val Array(name, value) = x.split("\\(")

          val address = s"${l.head}/$name"
          value.replace(")", "") -> address
        }.toList

        acc ++ res
    }

    println(tuples
      .groupBy(x => x._1)
      .collect {
        case x if x._2.length > 1 => x._2.map(x => x._2)
      }
    )


    "Test".hashCode

    // checksum + hash = emdb - ??? || size
    // contents

    List(List())
  }



//  def getHashCheckSum(path: String): Int = ???
//  def getRead(path: String): Int = ???  // 1 ~ hour
//
//  val tuples = List("root/a/2.txt", "root/c/d/4.txt", "root/4.txt")
//
//def getRead(path: String): Int = ???  // 1 ~ hour

//  val eventualTuples = tuples.map(x => Future(getRead(x)).map(r => (r, x)))
//
//  val eventualInts: Future[List[(Int, String)]] = Future.sequence(eventualTuples)
//
//  val eventualIntToTuples: Future[Map[Int, List[String]]] = eventualInts.map(x => x.groupBy(t => t._1).mapValues(l => l.map { case (_, n) => n}) )
//
//  import scala.concurrent.duration._
//
//  val intToStrings: Map[Int, List[String]] = Await.result(eventualIntToTuples, 1 second)
//
//
//  // ZIO, monix, cats effect, FS2, .... courutins(GO), Completable Future(Java)
//  //
//
//





  val strings: Array[String] = Array("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)")

  val result: List[List[String]] = findDuplicate(strings)


  println(result)

}
