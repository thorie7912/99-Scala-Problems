package org.p99.scala

object P01 {

  // procedural-style, getting the last element in a list
  // this is NOT an ideal solution in a functional programming paradigm
  def get_last_element_procedural[Type](list: List[Type]): Type = {

    if (list.length == 0) {
      throw new Exception("Cannot get last item in an empty list.")
    }

    var i = 0

    for (i <- 0 until list.length) {
      if (i == list.length-1) {
        return list(i)
      }
    }

    throw new Exception("Unable to get last item.")
  }

  // recursive-style, getting the last element in a list
  // better solution, but Scala has more tools
  def get_last_element_recursive[Type](list: List[Type]): Type = {
    if (list.tail == Nil) {
      // Note: the return keyword should be avoided, see: https://tpolecat.github.io/2014/05/09/return.html
      /*return*/ list.head
    } else {
      // Note: the return keyword should be avoided, see: https://tpolecat.github.io/2014/05/09/return.html
      /*return*/ get_last_element_recursive(list.tail)
    }
  }

  // built-in, getting the last element in a list
  def get_last_element_builtin[Type](list: List[Type]): Type = {
    // Note: the return keyword should be avoided, see: https://tpolecat.github.io/2014/05/09/return.html
    /*return*/ list.last
  }

  // recursive with match, getting the last element in a list
  def get_last_element_recursive_with_match[Type](list: List[Type]): Type = {

    // The following import is not required, because it is automatically added by the compiler
    //import scala.collection.immutable.::

    // Perform a pattern match on the list to recursively find the last element.
    // Since all Lists are made up of a two components (head element and tail List),
    // we can use this fact to recursively process the tail until there is no tail
    // left to process. In Scala, a List can be represented by its two components
    // using the :: (or cons) method, as in head :: tail.
    list match {
      // Base case:
      // If list matches the pattern "head :: Nil" meaning a List with head element
      // and a Nil (empty) tail element, then return the head. The type of head is Type,
      // but the type of Nil is List[_]. Since List[Type] ++ List[Nothing] = List[Type], it
      // is able to match a pattern that is List[Type] :: List[Nothing], or head :: Nil.
      // Note: the return keyword should be avoided, see: https://tpolecat.github.io/2014/05/09/return.html
      case head :: Nil => /*return*/ head

      // Recursive case:
      // Else if list matches the pattern "_ :: tail" meaning a List with any head element
      // and a tail element, then recurse to get last element of the tail.
      // The _ represents an unnamed wildcard; we could use a variable name "head" but we
      // don't need to use the variable later so a wildcard will suffice.
      // Note: the return keyword should be avoided, see: https://tpolecat.github.io/2014/05/09/return.html
      case _ :: tail => /*return*/ get_last_element_recursive_with_match(tail)

      // Else in all other cases, treat as an error (e.g. empty list).
      // The _ represents an unnamed wildcard.
      case _ => throw new NoSuchElementException
    }
  }
}
