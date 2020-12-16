class GradeBook
  attr_reader :grades

  def initialize
    @grades = Hash.new(0)
  end

  def add_grade(student, grade)
    @grades[student.to_sym] = grade.to_f
  end

  def get_grade(student)
    @grades[student.to_sym]
  end

  def letter_grades
    @grades.transform_values { |number| number.to_grade }
  end

  def letter_grade(student)
    grade(student).to_grade
  end
end

class Float
  def to_grade
    number = to_f
    if number < 50
      'F'
    elsif number < 60
      'D'
    elsif number < 70
      'C'
    elsif number < 80
      'B'
    else
      'A'
    end
  end
end

=begin
grade_book = GradeBook.new
grade_book.add_grade('christine', 77)
grade_book.add_grade('andy', 80)
grade_book.add_grade('andy', 85)
puts 'Grade Book:'
puts grade_book.grades
puts 'Letter Grades:'
puts grade_book.letter_grades
puts 'Grade Book:'
puts grade_book.grades
puts 78.5.to_grade
#puts grade_book.letter_grade("christine")
=end
