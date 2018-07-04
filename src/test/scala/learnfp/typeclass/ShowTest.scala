package learnfp.typeclass
import scala.language.implicitConversions

import org.scalatest.{FlatSpec, Matchers}

class ShowTest extends FlatSpec with Matchers {
  import ShowInstances._

  "show" should "show int " in {
    Printer.show(5) shouldBe "5"
  }

  it should "show double" in {
    Printer.show(5.07) shouldBe "5.07"
  }

  it should "show list size 2 of int" in {
    Printer.show(List(5, 10, 20)) shouldBe "[5, 10, 20]"
  }
  it should "show list size 1 of int " in {
    Printer.show(List(5)) shouldBe "[5]"
  }
  it should "show list size  0 of int" in {
    Printer.show(List[Int]()) shouldBe "[]"
  }
}
