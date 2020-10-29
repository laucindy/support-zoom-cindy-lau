require_relative 'domino_set'

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
