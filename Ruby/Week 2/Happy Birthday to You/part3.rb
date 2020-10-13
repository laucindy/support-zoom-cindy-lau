print "What is your name? "
name = gets.chomp

line_number = 0

until line_number == 4 do
  birthday_string = "Happy birthday"

  case line_number
  when 2
    puts "#{birthday_string} dear #{name}"
  when 3
    puts "#{birthday_string} to you."
  else
    puts "#{birthday_string} to you"
  end

  line_number += 1
end
