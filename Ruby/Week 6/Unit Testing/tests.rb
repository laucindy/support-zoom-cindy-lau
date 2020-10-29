require 'minitest/autorun'

require_relative 'grade_book'

class GradeBookTest < Minitest::Test
  def setup
    @grade_book = GradeBook.new
    @grade_book.add_grade('christine', 77)
  end

  def test_creates_new_hash
    assert_kind_of(Hash, @grade_book.grades)
  end

  def test_grade_book_values_default_to_zero
    assert_equal(0, @grade_book.grades[:andy])
  end

  def test_add_grades_to_grade_book
    expected = { :christine => 77.0 }
    actual = [@grade_book.grades.first].to_h
    assert_equal(expected, actual)
  end

  def test_get_grade_from_grade_book
    assert_equal(77, @grade_book.get_grade("christine"))
  end

  def test_convert_single_numerical_grade_to_letter
    assert_equal("B", 78.5.to_grade)
  end

  def test_convert_all_numerical_grades_to_letter
    @grade_book.add_grade("andy", 85)
    expected = { :christine => "B", :andy => "A" }
    actual = @grade_book.letter_grades
    assert_equal(expected, actual)
  end

  def test_letter_grade_undefined_method
    assert_raises(NoMethodError) { @grade_book.letter_grade("christine") }
  end

  # Failing tests

  def test_get_grade_two_students_with_same_name
    @grade_book.add_grade('christine', 85)
    assert_equal(77, @grade_book.get_grade("christine"))
  end

  def test_get_specific_student_grade
    @grade_book.add_grade("andy", 85)
    assert_equal(77, @grade_book.letter_grade("christine"))
  end
end