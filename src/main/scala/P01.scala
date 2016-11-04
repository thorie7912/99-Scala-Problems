package org.p99.scala

object P01 {

  // procedural-style, getting the last element in a list
  def get_last_element_procedural(list: List[Any]): Any = {
      var i = 0
      if (list.length == 0) {
        throw new Exception("Cannot get last item in an empty list.")
      }
      for (i <- 0 until list.length) {
        println(list(i))
        if (i == list.length-1) {
          return list(i)
        }
      }
    throw new Exception("Unable to get last item.")
  }

  // recursive-style, getting the last element in a list
  def get_last_element_recursive(list: List[Any]): Any = {
    if (list.tail == Nil) {
      return list.head
    } else {
      return get_last_element_recursive(list.tail)
    }
  }

}
