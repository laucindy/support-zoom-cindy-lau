class Toy
  attr_reader :name

  def initialize(name)
    @name = name
  end

  def to_s
    "This is a #{name}."
  end
end