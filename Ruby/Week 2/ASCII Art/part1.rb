print "Enter a number: "
number = gets.chomp.to_i

row = 1

while row <= number
  row.times { print "*" }
  print "\n"
  row += 1
end