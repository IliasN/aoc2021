import scala.io.Source
object Main{
  def main(args: Array[String]): Unit = {
    var x: Int = 0;
    var y: Int = 0;
    var lines = Source.fromFile("input.txt").getLines().toList
    lines.iterator.foreach((item: String) => {
      val parsed = item.split(" ")
      if(parsed(0) == "up") y -= parsed(1).toInt
      if(parsed(0) == "down") y += parsed(1).toInt
      if(parsed(0) == "forward") x += parsed(1).toInt
    })
    println(x * y)
    x = 0;
    y = 0;
    var aim = 0;
    lines.iterator.foreach((item: String) => {
      val parsed = item.split(" ")
      if(parsed(0) == "up") aim -= parsed(1).toInt
      if(parsed(0) == "down") aim += parsed(1).toInt
      if(parsed(0) == "forward") {
        x += parsed(1).toInt
        y += parsed(1).toInt * aim
      }
    })
    println(x * y)
  }
}
