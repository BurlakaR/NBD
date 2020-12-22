package Cw9

class Container[A](value:A) {
  private val _value: A = value
  def getContent: A = _value
  def applyFunction[R](f:A=>R): R = f(_value)
}
