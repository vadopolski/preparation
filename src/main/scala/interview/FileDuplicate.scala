package interview

import scala.collection.immutable

object FileDuplicate extends App {

  println("Test")

  val params = List(
    ("test1.parquet", "s3://20140101"),
    ("test2.parquet", "s3://20140102"),
    ("test3.parquet", "s3://20140103"),
    ("test4.parquet", "s3://20140103"),
    ("test5.parquet", "s3://20140104"),
    ("test5.parquet", "s3://20140105"),
    ("test6.parquet", "s3://20140106"))

  val params2 = List(
    "s3://20140101/test1.parquet",
    "s3://20140102/test2.parquet",
    "s3://20140103/test3.parquet",
    "s3://20140103/test4.parquet",
    "s3://20140104/test5.parquet",
    "s3://20140105/test5.parquet",
    "s3://20140106/test6.parquet")

    // file storage - nfs, ftp
    // block storage - СХД, дисковые массивы, как подключаемые
    // object storage - key, value (s3, hdfs)

  val result: List[List[(String, String)]] = List(
    List(
      ("test5.parquet", "s3://20140104"),
      ("test5.parquet", "s3://20140105")),
    List(
      ("test3.parquet", "s3://20140103"),
      ("test5.parquet", "s3://20140105")
    )
  )

  case class Meta(size: Int, etag: Int)

  val tuples: Seq[(Meta, String)] = params2.map(p => (getFileMetaData(p), p))



  def readGetSize(fileName: String): String = ???
  def readHashContent(fileName: String): String = ???
  def getFileMetaData(fileName: String): Meta = ???
  /**
   * hash от контента, читать начало, читать конец и брать хэш
   * читать первый и последний блок, можно ли кусками читать
   * паркет футер статистики по колонкам
   *
   * I
   * size -> 1
   * checksum (hash + tag) -> ETAG S3: https://stackoverflow.com/questions/12186993/what-is-the-algorithm-to-compute-the-amazon-s3-etag-for-a-file-larger-than-5gb
   * все равно read -> ???
   *
   * II
   * паралельную коллекцию
   * коты, зио - паралельная обработка
   * akka
   * RDD[String] - адреса
   *
   *
   *
   * */











}

/**
 * Duplicate file with the same size
 * Duplicate file with the same name
 * Dup
 *
* */
