require 'minitest/autorun'
require_relative 'student_body'

class StudentBodyTest < Minitest::Test
  def setup
    class_list = { "Math" => ["Andy", "Bob", "Carly"], "English" => ["Fred", "Earl", "Dorothy"]}
    @students = StudentBody.new(class_list)
  end

  def test_upcase_student_names
    actual = @students.map { |student| student.upcase }
    expected = ["ANDY", "BOB", "CARLY", "FRED", "EARL", "DOROTHY"]
    assert_equal(expected, actual)
  end

  def test_reverse_student_names
    actual = @students.map { |student| student.reverse }
    expected = ["ydnA", "boB", "ylraC", "derF", "lraE", "yhtoroD"]
    assert_equal(expected, actual)
  end

  def test_all_student_names_less_than_8_characters_return_true
    actual = @students.all? { |student| student.length < 8 }
    expected = true
    assert_equal(expected, actual)
  end

  def test_all_student_names_more_than_8_characters_return_false
    actual = @students.all? { |student| student.length > 8 }
    expected = false
    assert_equal(expected, actual)
  end

  def test_any_student_names_less_than_8_characters_return_true
    actual = @students.any? { |student| student.length < 8 }
    expected = true
    assert_equal(expected, actual)
  end

  def test_total_number_of_students
    actual = @students.count
    expected = 6
    assert_equal(expected, actual)
  end

  def test_select_student_names_beginning_with_C
    actual = @students.select { |student| student.start_with?("C") }
    expected = ["Carly"]
    assert_equal(expected, actual)
  end
end