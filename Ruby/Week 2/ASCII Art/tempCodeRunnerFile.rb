while row <= number
  (number - row).times { print " " }
  row.times { print "* " }
  print "\n"
  row += 1
end