package book

/**
  * Created by abhishek on 04/07/18
  */
import Test1.ImplicitTest

class Test {
   def ch() ={
     2.check
   }
}
object Test1 {

  implicit class ImplicitTest(a: Int) {
      def check():String = {
        "Hello"
      }
  }
 //implicit def getImplict(a:Int) = new ImplicitTest(a)

}
object Main{
  def main(args: Array[String]): Unit = {
    val t = new Test
    println(t.ch())
  }
}
