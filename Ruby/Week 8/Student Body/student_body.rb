class StudentBody
  include Enumerable

  def initialize(class_list)
    @class_list = class_list
  end

  def each
    @class_list.each do |_, students|
      students.each { |student| yield(student) }
    end
  end
end