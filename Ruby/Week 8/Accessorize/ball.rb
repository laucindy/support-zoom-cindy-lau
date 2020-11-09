require_relative 'toy'

class Ball < Toy
  def initialize(name)
    super(name)
  end

  def to_s
    "This is a ball, it's safe for children 6+."
  end
end