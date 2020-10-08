# Get My Number game
# Written by: Head First Ruby

puts "Welcome to 'Get My Number!'"
print "What's your name? "

name = gets.chomp

puts "Welcome, #{name}!"

# Store a random number for the player to guess
puts "I've got a random number between 1 and 100."
puts "Can you guess it?"
target = rand(100) + 1

# Track how many guesses the player has made
num_guesses = 0

puts "You've got #{10 - num_guesses} guesses left."