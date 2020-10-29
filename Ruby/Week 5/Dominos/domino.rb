require_relative 'print_domino'

class Domino
  include PrintDomino

  attr_reader :sides

  def initialize(left, right)
    @sides = [left, right]
  end

  def to_s
  #  print_domino
    "#{@sides[0]}|#{@sides[1]} "
  end
end

=begin
puts " ------------ "
puts "|     ||     |"
puts "|  *  ||  *  |"
puts "|     ||     |"
puts " ------------ "

domino = Domino.new(4, 3)
domino.to_s
=end