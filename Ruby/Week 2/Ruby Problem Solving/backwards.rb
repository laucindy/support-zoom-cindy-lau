print "Input your first and last name: "
name = gets.chomp

name_array = name.split(' ')

first_name = name_array[0]
last_name = name_array[1]

puts "Hello #{last_name} #{first_name}"