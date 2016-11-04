package org.p99.scala

class P01Spec extends UnitSpec {

  "get_last_element_procedural" should "get last element of normal list" in {
    assert(3 == P01.get_last_element_procedural(List(1, 2, 3)))
  }

  "get_last_element_recursive" should "get last element of normal list" in {
    assert(3 == P01.get_last_element_recursive(List(1, 2, 3)))
  }

  "get_last_element_builtin" should "get last element of normal list" in {
    assert(3 == P01.get_last_element_builtin(List(1, 2, 3)))
  }

  "get_last_element_recursive_with_match" should "get last element of normal list" in {
    assert(3 == P01.get_last_element_recursive_with_match(List(1, 2, 3)))
  }
}

