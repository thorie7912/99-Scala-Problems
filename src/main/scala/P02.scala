package org.p99.scala

object P02 {

  // procedural-style, getting the second to last element in a list
  // this is NOT an ideal solution in a functional programming paradigm
  def get_second_to_last_element_procedural[Type](list: List[Type]): Type = {

    if (list.length == 0) {
      throw new Exception("Cannot get last item in an empty list.")
    }

    var i = 0

    for (i <- 0 until list.length) {
      if (i == list.length-2) {
        return list(i)
      }
    }

    throw new Exception("Unable to get last item.")
  }

  // recursive-style, getting the second last element in a list
  // better solution, but Scala has more tools
  def get_second_to_last_element_recursive[Type](list: List[Type]): Type = {
    if (list.tail == Nil) {
      throw new Exception("List needs at least 2 items to get 2nd-to-last item.")
    } else if (list.tail.length == 1) {
      list.head
    } else {
      get_second_to_last_element_recursive(list.tail)
    }
  }

  // built-in, getting the second to last element in a list
  def get_second_to_last_element_builtin[Type](list: List[Type]): Type = {
    // the init method selects all elements except for the last
    list.init.last
  }

  // recursive with match, getting the second to last element in a list
  def get_second_to_last_element_recursive_with_match[Type](list: List[Type]): Type = {

    // Perform a pattern match on the list to recursively find the second to last element.
    list match {
      // Base case pattern:
      // If list matches the pattern "head :: _ :: Nil" meaning a List with head element
      // and another List containing another (unnamed) head element, and finally a Nil (empty) tail,
      // then return the first head (actual second to last element).
      // `head :: _ :: Nil` is equivalent to `head :: ( _ :: Nil )`
      case secondToLastHead :: lastHead :: Nil => secondToLastHead

      // Recursive case pattern:
      // Else if list matches the pattern "_ :: tail" meaning a List with any head element
      // and a tail element, then recurse to get second to last element of the tail.
      case anyHead :: tailSize3Plus => get_second_to_last_element_recursive_with_match(tailSize3Plus)

      // Else in all other cases, treat as an error (e.g. list size 2 or smaller).
      case _ => throw new NoSuchElementException
    }
  }

  // recursive with match, getting the second to last element in a list
  // same as above, written more compactly
  def get_second_to_last_element_recursive_with_match_compact[T](list: List[T]): T = {
    list match {
      case h :: _ :: Nil => h
      case _ :: t => get_second_to_last_element_recursive_with_match_compact(t)
      case _ => throw new NoSuchElementException
    }
  }

}
