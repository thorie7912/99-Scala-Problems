package org.p99.scala

object P01 {

  // procedural-style, getting the last element in a list
  def get_last_element_procedural[Type](list: List[Type]): Type = {
      var i = 0
      if (list.length == 0) {
        throw new Exception("Cannot get last item in an empty list.")
      }
      for (i <- 0 until list.length) {
        if (i == list.length-1) {
          return list(i)
        }
      }
    throw new Exception("Unable to get last item.")
  }

  // recursive-style, getting the last element in a list
  def get_last_element_recursive[Type](list: List[Type]): Type = {
    if (list.tail == Nil) {
      /*return*/ list.head // the return keyword is optional
    } else {
      /*return*/ get_last_element_recursive(list.tail) // the return keyword is optional
    }
  }

  // built-in, getting the last element in a list
  def get_last_element_builtin[Type](list: List[Type]): Type = {
    /*return*/ list.last // the return keyword is optional
  }

  // recursive with match, getting the last element in a list
  def get_last_element_recursive_with_match[Type](list: List[Type]): Type = {

    import scala.collection.immutable.::

    // Perform a pattern match on the list to recursively find the last element.
    // Since all Lists are made up of a two components (head element and tail List),
    // we can use this fact to recursively process the tail until there is no tail
    // left to process. In Scala, a List can be represented by its two components
    // using the :: (or cons) method, as in head :: tail.
    list match {
      // Base case:
      // If list matches the pattern "head :: Nil" meaning a List with head element
      // and a Nil (empty) tail element, then return the head
      case head :: Nil => /*return*/ head // the return keyword is optional

      // Recursive case:
      // Else if list matches the pattern "_ :: tail" meaning a List with any head element
      // and a tail element, then recurse to get last element of the tail.
      // The _ represents an unnamed wildcard; we could use a variable name "head" but we
      // don't need to use the variable later so a wildcard will suffice.
      case _ :: tail => /*return*/ get_last_element_recursive_with_match(tail) // the return keyword is optional

      // Else in all other cases, treat as an error (e.g. empty list).
      // The _ represents an unnamed wildcard.
      case _ => throw new NoSuchElementException
    }
  }
}
