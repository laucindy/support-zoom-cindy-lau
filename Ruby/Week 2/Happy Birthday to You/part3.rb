print "What is your name? "
name = gets.chomp

line_number = 0

until line_number == 4 do
  print "Happy birthday "

  case line_number
  when 2
    print "dear #{name}"
  when 3
    print "to you."
  else
    print "to you"
  end

  print "\n"

  line_number += 1
end
