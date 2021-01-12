def verse(number)

  puts "#{number} bottle of beer on the wall,"
  puts "#{number} bottle of beer."
  puts "Take one down and pass it around,"
  puts "#{(number - 1 == 0) ? 'no more' : number - 1} bottle#{(number - 1) == 0 ? 's' : ''} of beer on the wall."

  while number > 0
    plural = (number == 1) ? '' : 's'
    next_number = (number - 1 == 0) ? 'no more' : number - 1
    next_number_plural = (number - 1 == 1) ? '' : 's'

    puts "#{number} bottle#{plural} of beer on the wall,"
    puts "#{number} bottle#{plural} of beer."
    puts 'Take one down and pass it around,'
    puts "#{next_number} bottle#{next_number_plural} of beer on the wall."
    puts

    number -= 1
  end
  
  puts 'No more bottles of beer on the wall,'
  puts 'no more bottles of beer.'
  puts 'Go to the store and buy some more,'
  puts '99 bottles of beer on the wall.'
end

print "How many bottles are on the wall? "
bottles = gets.chomp.to_i

verse(bottles)