require_relative 'domino'
require_relative 'print_domino'

class DominoSet
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

  def print_one_suit_of_dominoes(dominoes)
    print_suit_dominoes(dominoes)
  end
end

def swap_tops_and_bottoms(dominoes)
  dominoes.map do |domino| 
    domino.sides[0], domino.sides[1] = domino.sides[1], domino.sides[0]
    domino
  end
end

def find_dominoes_with(dominoes, number)
  dominoes.find_all { |domino| (domino.sides[0] == number) || (domino.sides[1] == number) }
end

set = DominoSet.new
set.initialize_dominoes

puts 'Printing original order: '
set.print_dominoes(set.dominoes, true)
puts

puts 'Printing new order: '
new_order = swap_tops_and_bottoms(set.dominoes)
set.print_dominoes(new_order, false)
puts

puts 'Find all dominoes with 3 dots: '
matching_dominoes = find_dominoes_with(set.dominoes, 3)
set.print_one_suit_of_dominoes(matching_dominoes)
puts

puts 'Find all dominoes with 5 dots: '
matching_dominoes = find_dominoes_with(set.dominoes, 5)
set.print_one_suit_of_dominoes(matching_dominoes)
puts
