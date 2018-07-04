package learnfp.typeclass

trait Show[A] {
  def show(x:A):String
}

object Printer {
  def show[A](x:A)(implicit showInstance:Show[A]):String = {
    showInstance.show(x)
  }
}

object ShowInstances {
  implicit val intInstance:Show[Int] = new Show[Int] {
    override def show(x: Int): String = x.toString
  }

  implicit val doubleInstance:Show[Double] = new Show[Double] {
    override def show(x: Double): String = x.toString
  }

  implicit def listInstance[T](implicit xShow:Show[T]):Show[List[T]] = new Show[List[T]] {
    def listShowHelper(acc : String, xs:List[T]) : String= {
      xs match {
        case a :: b =>
          if(acc.equals(""))
            listShowHelper(xShow.show(a) , b)
          else
            listShowHelper(acc+", "+xShow.show(a) , b)
        case _ => acc
      }
    }
    override def show(xs:List[T]): String = {
     "["+listShowHelper("", xs)+"]"
    }
  }
}