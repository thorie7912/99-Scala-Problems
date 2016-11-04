package org.p99.scala

class P02Spec extends UnitSpec {

  "get_second_to_last_element_procedural" should "get second to last element of normal list" in {
    assert(2 == P02.get_second_to_last_element_procedural(List(1, 2, 3)))
  }

  "get_second_to_last_element_recursive" should "get second to last element of normal list" in {
    assert(2 == P02.get_second_to_last_element_recursive(List(1, 2, 3)))
  }

  "get_second_to_last_element_builtin" should "get second to last element of normal list" in {
    assert(2 == P02.get_second_to_last_element_builtin(List(1, 2, 3)))
  }

  "get_second_to_last_element_with_match" should "get second to last element of normal list" in {
    assert(2 == P02.get_second_to_last_element_recursive_with_match(List(1, 2, 3)))
  }

  "get_second_to_last_element_with_match_compact" should "get second to last element of normal list" in {
    assert(2 == P02.get_second_to_last_element_recursive_with_match_compact(List(1, 2, 3)))
  }

}

