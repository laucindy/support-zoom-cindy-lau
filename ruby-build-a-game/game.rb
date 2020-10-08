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
guessed_it = false

puts "You've got #{10 - num_guesses} guesses left."

print "Make a guess: "
guess = gets.to_i

# Compare the guess to the target
# Print the appropriate message

if guess < target
  puts "Oops. Your guess was LOW."
elsif guess > target
  puts "Oops. Your guess was HIGH."
end