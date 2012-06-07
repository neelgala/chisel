package Tutorial {

import Chisel._
import scala.collection.mutable.HashMap
import util.Random

class Sequential extends Component {
  val io = new Bundle {
    val in  = Bool(INPUT)
    val out = UFix(8, OUTPUT)
  }
  // COUNT INCOMING TRUES 
  // FILL IN HERE ...
  io.out := UFix(0)

  defTests(io) {
    var allGood = true
    val vars    = new HashMap[Node, Node]()
    val rnd     = new Random()
    var tot     = 0
    for (t <- 0 until 16) {
      vars.clear()
      val in       = rnd.nextInt(2) == 1
      vars(io.in)  = Bool(in)
      vars(io.out) = UFix(tot)
      allGood      = test(vars) && allGood
      if (t > 0 && in) tot += 1
    }
    allGood
  }
}

}