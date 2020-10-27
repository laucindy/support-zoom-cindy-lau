def customized_list_of_multiples(multiples_of, size)
  list = []
  size.times { |i| list << i * multiples_of }

  block_given? ? list = yield(list) : list
end

puts "Original list, no block:"
p customized_list_of_multiples(3, 6)
puts

puts "Block that duplicates the original list:"
p customized_list_of_multiples(3, 6) { |list| list * 2 }
puts

puts "Block that multiples the original list by 5:"
p customized_list_of_multiples(3, 6) { |list|  list.map { |i| i * 5 } }
puts