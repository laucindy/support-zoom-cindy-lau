print "What is your name? "
name = gets.chomp

line_number = 0

while line_number < 4
  print "\nHappy birthday "

  if (line_number == 2)
    print "dear #{name}"
  else
    print "to you"
  end

  line_number += 1
end

print ".\n"