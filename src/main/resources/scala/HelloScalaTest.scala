import org.scalatest.FunSuite

class HelloScalaTest extends FunSuite {
  test("hello world is returned") {
    assert("hello world" == new HelloScala().sayHello())
  }
}