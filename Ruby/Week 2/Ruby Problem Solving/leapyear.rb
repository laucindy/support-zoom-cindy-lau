def integer?(str)
  convert_to_int = str.to_i   # returns 0 if str is an actual string, an integer otherwise
  convert_to_string = convert_to_int.to_s

  if str == convert_to_string
    true
  else
    false
  end
end


year = nil

loop do 
  print "Enter a year: "
  year = gets.chomp

  if integer?(year) && year.to_i.positive?
    break
  else
    puts "#{year} is not a valid year"
  end
end

leapyear_str = ""
year = year.to_i

if (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))
  leapyear_str = "is a leap year"
else
  leapyear_str = "is not a leap year"
end

puts "#{year} #{leapyear_str}"