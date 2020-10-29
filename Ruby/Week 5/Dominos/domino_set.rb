require_relative 'domino'
require_relative 'print_domino'

class DominoSet
  include PrintDomino
  include PrintMultipleDominoes

  SET_SIZE = 28
  SUIT_SIZE = 7

  attr_reader :dominoes

  def initialize
    @dominoes = []
  end

  def initialize_dominoes
    k = 0

    (0...SUIT_SIZE).each do |i|
      j = 0

      while j <= i do
        @dominoes << Domino.new(i, j)
        j += 1
        k += 1
      end
    end
  end

  def print_dominoes(dominoes, sort_left)
    new_line_indexes = [0, SET_SIZE]

    (0...dominoes.length - 1).each do |i|
      if sort_left
        if dominoes[i + 1].sides[0] > dominoes[i].sides[0]
            new_line_indexes.insert(-2, i + 1)
        end
      else
        if dominoes[i + 1].sides[1] > dominoes[i].sides[1]
            new_line_indexes.insert(-2, i + 1)
        end
      end
    end
    
    (1..SUIT_SIZE).each do |i|
      print_domino(dominoes, new_line_indexes[i-1], new_line_indexes[i])
    end
  end

  
  
end

def swap_tops_and_bottoms(dominoes)
  new_order = dominoes.map do |domino| 
    domino.sides[0], domino.sides[1] = domino.sides[1], domino.sides[0]
    domino
  end

  new_order
end


set = DominoSet.new
set.initialize_dominoes

puts "Printing original order: "
set.print_dominoes(set.dominoes, true)

new_order = swap_tops_and_bottoms(set.dominoes)

puts "Printing new order: "
set.print_dominoes(new_order, false)
#p new_order