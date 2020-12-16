class Clothes
  attr_reader :name, :color

  def initialize(name, color)
    @name = name
    @color = color
  end

  def to_s
    "This is a #{color} #{name}."
  end
end