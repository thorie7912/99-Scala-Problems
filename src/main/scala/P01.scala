package org.p99.scala

import scala.collection.immutable.::

object P01 {

  // procedural-style, getting the last element in a list
  def get_last_element_procedural[SomeDefinedType](list: List[SomeDefinedType]): SomeDefinedType = {
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
  def get_last_element_recursive[SomeDefinedType](list: List[SomeDefinedType]): SomeDefinedType = {
    if (list.tail == Nil) {
      /*return*/ list.head // the return keyword is optional
    } else {
      /*return*/ get_last_element_recursive(list.tail) // the return keyword is optional
    }
  }

  // built-in, getting the last element in a list
  def get_last_element_builtin[SomeDefinedType](list: List[SomeDefinedType]): SomeDefinedType = {
    /*return*/ list.last // the return keyword is optional
  }

  // recursive with match, getting the last element in a list
  def get_last_element_recursive_with_match[SomeDefinedType](list: List[SomeDefinedType]): SomeDefinedType = {
    list match {
      case head :: Nil => head
      case _ :: tail => get_last_element_recursive_with_match(tail)
      case _ => throw new NoSuchElementException
    }
  }

  // recursive with match and extracted cases, getting the last element in a list
  def get_last_element_recursive_with_match_extracted[SomeDefinedType](list: List[SomeDefinedType]): SomeDefinedType = {

    object ListOnlyHead {
      def unapplySeq[T](arg: List[T]): Option[List[T]] = {
        // not sure what goes here???
      }
    }

    def onlyHead[SomeDefinedType](list: List[SomeDefinedType]): Boolean = {
      list.head != Nil && list.tail == Nil
    }

    def hasNonEmptyTail[SomeDefinedType](list: List[SomeDefinedType]): Boolean = {
      list.head != Nil && list.tail != Nil
    }

    def emptyList[SomeDefinedType](list: List[SomeDefinedType]): Boolean = {
      list.head == Nil
    }

    list match {
      case ListOnlyHead(list) => list.head
      case list if hasNonEmptyTail(list) => get_last_element_recursive_with_match_extracted(list.tail)
      case list if emptyList(list) => throw new NoSuchElementException
    }
  }
}
