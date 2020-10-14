def print_triangle(number, inverted = false)
  row = 1

  while row <= number
    space_count = inverted ? (row) : (number - row)
    asterisk_count = inverted ? (number - row) : (row)

    space_count.times { print ' ' }
    asterisk_count.times { print '* ' }
    print "\n"
    row += 1
  end
end

print 'Enter a number: '
number = gets.chomp.to_i

print_triangle(number)
print_triangle(number, true)