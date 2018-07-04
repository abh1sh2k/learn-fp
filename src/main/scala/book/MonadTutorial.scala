package book
import cats.Eval
import cats.data.{State, WriterT}

/**
  * Created by abhishek on 02/07/18
  */
object MonadTutorial {
  def main(args: Array[String]): Unit = {


    val a = State[Int, String] { state =>
      (state, s"The state is $state")
    }
    /*for {d <- a} {
      print(d)
    }*/
    val b: Eval[(Int, String)] = a.run(1)
    val c: (Int, String) = b.value
    WriterT
  }
}
