def integer?(str)
  convert_to_int = str.to_i   # returns 0 if str is an actual string, an integer otherwise
  convert_to_string = convert_to_int.to_s

  if str == convert_to_string
    true
  else
    false
  end
end

def num_matches(code, guess)
  code_array = code.digits.reverse
  guess_array = guess.digits.reverse

  exact_matches = 0
  indirect_matches = 0

  # check if position and digit are exact matches
  code_array.each_with_index do |digit, index|
    if guess_array[index] == digit
      exact_matches += 1
    elsif guess_array.include?(digit)
      indirect_matches += 1
    end
  end

  return exact_matches, indirect_matches
end


#code = [rand(1..6), rand(1..6), rand(1..6), rand(1..6)].join().to_i

code = 1234               # for debugging
puts "code: #{code}"      # for debugging

num_guesses = 0;

loop do 
  print "Enter your guess: "
  guess = gets.chomp

  # if the guess isn't an exact length of 4, is a string or a negative integer, or any of its digits is greater than 6, 
  # then prompt user to guess again
  if (guess.length != 4) || (!integer?(guess)) || (guess.to_i.negative?) || !(guess.to_i.digits.all? { |digit| digit.between?(1, 6) })
    next
  end

  num_guesses += 1

  guess = guess.to_i

  if guess == code
    puts "Nice work! You took #{num_guesses} guess#{(num_guesses) == 1 ? '' : 'es'}."
    break
  else
    exact_matches, indirect_matches = num_matches(code, guess)
    exact_matches.times { |i| print "X" }
    indirect_matches.times { |i| print "x" }
    puts "\n" if exact_matches > 0 || indirect_matches > 0
  end
end