require_relative 'clothes'
require_relative 'accessorizable'

class Shirt < Clothes
  include Accessorizable

  def initialize(name, color)
    super(name, color)
  end

  def to_s
    "A #{color} #{name}, with #{accessories_to_s}"
  end
end