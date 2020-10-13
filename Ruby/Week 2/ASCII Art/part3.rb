print 'Enter a number: '
number = gets.chomp.to_i

row = 1

while row <= number
  (number - row).times { |_i| print ' ' }
  row.times { |_i| print '* ' }
  print "\n"
  row += 1
end
