require_relative 'toy'
require_relative 'accessorizable'

class MrPotatoHead < Toy
  include Accessorizable

  def initialize(name)
    super(name)
  end

  def to_s
    accessories_to_s
  end
end