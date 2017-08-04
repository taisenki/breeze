package breeze.math

/*
 Copyright 2012 David Hall

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/

import org.scalatest._
import org.scalatest.junit._
import org.scalatest.prop._
import org.scalacheck._
import org.junit.runner.RunWith
import LogDouble._
import breeze.linalg.RandomInstanceSupport

@RunWith(classOf[JUnitRunner])
class LogDoubleTest extends FunSuite with Checkers {

  implicit val ad: Arbitrary[Double] = Arbitrary(
    RandomInstanceSupport.genReasonableDouble.arbitrary.map(_.abs)
  )

  implicit class ae(x: Double) {
    def =~=(y: Double) = math.abs(x - y) / x < 1E-6
  }

  test("addition") {
    check {
      Prop.forAll {
        (d: Double, e: Double) =>
          (d.toLogDouble + e.toLogDouble).value =~= d + e
      }
    }
    check {
      Prop.forAll {
        (d: Double, e: Double) =>
          e <= 0 || (d.toLogDouble + e).value =~= d + e
      }
    }
  }
  test("multiplication") {
    check {
      Prop.forAll {
        (d: Double, e: Double) =>
          (d.toLogDouble * e.toLogDouble).value =~= d * e
      }
    }
    check {
      Prop.forAll {
        (d: Double, e: Double) =>
          e <= 0 || (d.toLogDouble * e).value =~= d * e
      }
    }
  }
  test("division") {
    check {
      Prop.forAll {
        (d: Double, e: Double) =>
          (d.toLogDouble / e.toLogDouble).value =~= d / e
      }
    }
    check {
      Prop.forAll {
        (d: Double, e: Double) =>
          e <= 0 || (d.toLogDouble / e).value =~= d / e
      }
    }
  }
}
