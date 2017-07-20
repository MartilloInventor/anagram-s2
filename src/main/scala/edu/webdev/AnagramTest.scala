package edu.webdev

import java.util.Arrays
import scala.util.control.Breaks._

/**
  * Created by algotrader on 7/19/17.
  */
object AnagramTest {

  def main(args: Array[String]): Unit = {
    val instancearray = new Array[Int](26)
    val src = Array[String](
      "dfgjkdjdma",
      "dnjmfzjdma",
      "dfgdqdfdma",
      "dfgjkdjdma",
      "dfgsklaama",
      "dfsjkdjdma",
      "dfgjkdjdma",
      "rfglkwhyma",
      "dfgjkdjdma",
      "qqqjkdjqma",
      "dfgjkdqwea",
      "suxjkdjdma"
    )
    val trg = Array[String](
      "fdjgdkdjma",
      "ndjmzjamda",
      "dgfqddfdma",
      "dfsjdkjmda",
      "fdgsklamaa",
      "dfjekjddma",
      "dfgjkdjdma",
      "rgfkflyhma",
      "dfgjkjdmad",
      "qqqjdgjqma",
      "dfgjkdqwea",
      "suxjdkhdma"
    )
    var count_fail: Long = 0
    // had to make this variable long
    var start_time = 0
    var end_time = 0
    val max = 0xFFFFFFF

    start_time = System.currentTimeMillis.toInt

    for (iterations:Int <- 0 until max) {
      Arrays.fill(instancearray, 0);
      for (i:Int <- 0 until 12) {
        for (j:Int <- 0 until 10) {
          instancearray(src(i).charAt(j) - 'a') += 1
        }
        breakable {
          for (j:Int <- 0 until 10) {
            instancearray(trg(i).charAt(j) - 'a') -= 1
            if (instancearray(trg(i).charAt(j) - 'a') < 0) {
              count_fail += 1;
              break; /* skip to next test */
            }
          }
        }
      }
    }

    end_time = System.currentTimeMillis.toInt
    printf("Total failures %d in %d seconds %d iterations\n",
      count_fail, (end_time - start_time) / 1000, max)
  }
}
