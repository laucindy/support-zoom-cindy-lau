def integer?(str)
  convert_to_int = str.to_i   # returns 0 if str is an actual string, an integer otherwise
  convert_to_string = convert_to_int.to_s

  if str == convert_to_string
    true
  else
    false
  end
end

# rearrange if there are digits with zeros, by swapping first non-zero digit with the first digit (0)
def arrange_zeros(number_array)
  has_zeros = false

  number_array.each_with_index do |digit, index|
    if digit == 0
      has_zeros = true 
    elsif has_zeros && digit != 0
      number_array[0], number_array[index] = number_array[index], number_array[0]
      break
    elsif !has_zeros and index > 0
      break
    end
  end

  number_array
end

number = nil

loop do 
  print "Enter a number: "
  number = gets.chomp

  break if integer?(number) || number == "-0"
end

if (number.to_i.negative?)
  number_array = number.to_i.abs.digits.sort!
  number_array = arrange_zeros(number_array)  
else
  # sort by largest digit in number to smallest
  number_array = number.to_i.digits.sort! { |a, b| b <=> a }
end

largest_number = number_array.join().to_i

if (number.to_i.negative?)
  largest_number *= -1
end

# edge case: check if number is -0
if number == "-0"
  largest_number = "-0"     # not possible to have -0 as an integer
end

puts "Largest possible number: #{largest_number}"