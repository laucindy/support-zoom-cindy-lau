print "What is your name? "
name = gets.chomp

line_number = 0

while line_number < 4
  print "Happy birthday "

  if (line_number == 2)
    print "dear #{name}"
  elsif (line_number == 3)
    print "to you."
  else
     print "to you"
  end

  print "\n"

  line_number += 1
end