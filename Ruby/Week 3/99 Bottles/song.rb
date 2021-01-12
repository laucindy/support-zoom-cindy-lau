def verse(number)
  puts "#{number} bottle of beer on the wall,"
  puts "#{number} bottle of beer."
  puts "Take one down and pass it around,"
  puts "#{(number - 1 == 0) ? 'no more' : number - 1} bottle#{(number - 1) == 0 ? 's' : ''} of beer on the wall."

  puts
  
  puts 'No more bottles of beer on the wall,'
  puts 'no more bottles of beer.'
  puts 'Go to the store and buy some more,'
  puts '99 bottles of beer on the wall.'
end

verse(1)