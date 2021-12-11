import scala.io.Source
import scala.math.pow
object Main{
  def main(args: Array[String]): Unit = {
    val lines = Source.fromFile("input.txt").getLines().toList
    val lineSize = lines(0).size
    val counts = Array.fill(lineSize){0}
    lines.foreach(item => {
      item.zipWithIndex.foreach((values) => {
        val (c, i) = values
        if(c == '1') counts(i) += 1
        else counts(i) -= 1
      })
    })
    val newBin = counts.map(v => {
      if(v < 0) 0
      else 1
    })
    val reverseBin = newBin.map(v => {
      if(v == 0) 1
      else 0
    })
    val v1 = Integer.parseInt(newBin.mkString, 2)
    val v2 = Integer.parseInt(reverseBin.mkString, 2)
    println(v1, v2, v1*v2)

    var mostCommon = lines
    var i = 0
    var count = 0
    while(mostCommon.length != 1){
      count = 0
      mostCommon.foreach(v => {
        if(v(i) == '1') count += 1
        else count -= 1
      })
      if(count < 0) count = '0'
      else count = '1'
      mostCommon = mostCommon.filter(v => v(i) == count)
      i += 1
    }
    var leastCommon = lines
    i = 0
    while(leastCommon.length != 1){
      count = 0
      leastCommon.foreach(v => {
        if(v(i) == '1') count += 1
        else count -= 1
      })
      if(count < 0) count = '1'
      else count = '0'
      leastCommon = leastCommon.filter(v => v(i) == count)
      i += 1
    }
    val v3 = Integer.parseInt(mostCommon(0), 2)
    val v4 = Integer.parseInt(leastCommon(0), 2)
    println(v3, v4, v3*v4)
  }
}
