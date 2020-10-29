require_relative 'print_domino'

class Domino
  include PrintDomino

  attr_reader :sides

  def initialize(left, right)
    @sides = [left, right]
  end

  def to_s
    print_domino
  #  "#{@sides[0]}|#{@sides[1]} "     # string representation, eg 3|4
  end
end