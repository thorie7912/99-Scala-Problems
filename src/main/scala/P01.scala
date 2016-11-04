package org.p99.scala

import scala.collection.immutable.::

object P01 {

  // procedural-style, getting the last element in a list
  def get_last_element_procedural[T](list: List[T]): T = {
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
  def get_last_element_recursive[T](list: List[T]): T = {
    if (list.tail == Nil) {
      /*return*/ list.head // the return keyword is optional
    } else {
      /*return*/ get_last_element_recursive(list.tail) // the return keyword is optional
    }
  }

  // built-in, getting the last element in a list
  def get_last_element_builtin[T](list: List[T]): T = {
    /*return*/ list.last // the return keyword is optional
  }

  // recursive with match, getting the last element in a list
  def get_last_element_recursive_with_match[T](list: List[T]): T = {
    list match {
      case head :: Nil => head
      case _ :: tail => get_last_element_recursive_with_match(tail)
      case _ => throw new NoSuchElementException
    }
  }

  // recursive with match and extracted cases, getting the last element in a list
  def get_last_element_recursive_with_match_extracted[T](list: List[T]): T = {

    def onlyHead[T](list: List[T]): List[T] = {
      list.head :: Nil
    }

    def hasNonEmptyTail[T](list: List[T]): Boolean = {
      _ :: list.tail
    }

    def everythingElse[T](list: List[T]): Boolean = {
      _
    }

    list match {
      case onlyHead(list) => list.head
      case hasNonEmptyTail(list) => get_last_element_recursive_with_match_extracted(list.tail)
      case everythingElse(list) => throw new NoSuchElementException
    }
  }
}
