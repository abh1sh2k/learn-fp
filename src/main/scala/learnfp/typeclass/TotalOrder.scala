package learnfp.typeclass

trait TotalOrder[A] {
  def less(lhs:A, rhs:A):Boolean
}

object TotalOrderInstances {
  implicit val intInstance:TotalOrder[Int] = new TotalOrder[Int] {
    override def less(lhs: Int, rhs: Int): Boolean = lhs < rhs
  }

  implicit val stringInstance:TotalOrder[String] = new TotalOrder[String] {
    override def less(lhs: String, rhs: String): Boolean = lhs.compareTo(rhs) < 0
  }

  implicit def listInstance[T](implicit suborder:TotalOrder[T]):TotalOrder[List[T]] = new TotalOrder[List[T]] {
    override def less(lhs: List[T], rhs: List[T]): Boolean = if(lhs.size  < rhs.size) true
    else if(rhs.size  < lhs.size) false
    else {
      lhs.zip(rhs).forall( t => suborder.less(t._1,t._2))
    }
  }
}

object Comparator {
  @annotation.implicitNotFound("No instance of TotalOrder found")
  def less[A](lhs:A, rhs:A)(implicit order:TotalOrder[A]) = {
    order.less(lhs, rhs)
  }
}