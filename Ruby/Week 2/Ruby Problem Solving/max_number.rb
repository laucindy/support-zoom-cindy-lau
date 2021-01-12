def integer?(str)
  convert_to_int = str.to_i   # returns 0 if str is an actual string, an integer otherwise
  convert_to_string = convert_to_int.to_s

  if str == convert_to_string
    true
  else
    false
  end
end

number1 = nil
number2 = nil

loop do 
  print "Enter a number: "
  number1 = gets.chomp

  break if integer?(number1)
end

loop do 
  print "Enter another number: "
  number2 = gets.chomp

  break if integer?(number2)
end

puts "Max: #{number1 > number2 ? number1 : number2}"