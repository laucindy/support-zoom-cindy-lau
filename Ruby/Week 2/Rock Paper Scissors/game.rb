def valid_input?(item1, item2)
  valid_inputs = ["rock", "paper", "scissors"]

  # check that both items contain the exact string "rock", "paper" or "scissors"
  if valid_inputs.any? {|word| item1 == word} && valid_inputs.any? {|word| item2 == word}
    return true
  end

  false
end

def play_game(item1, item2)
  items = [item1, item2]
  winner = nil

  if items[0] == items[1]
    puts "Tie!"
  elsif items.include?("rock") && items.include?("paper")
    winner = items.index("paper")
    puts "Paper covers rock."
  elsif items.include?("rock") && items.include?("scissors")
    winner = items.index("rock")
    puts "Rock crushes scissors."
  elsif items.include?('paper') && items.include?('scissors')
    winner = items.index("scissors")
    puts 'Scissors cuts paper.'
  end

  puts "Player #{winner + 1} wins." unless winner == nil
end

print "Player 1 - Enter your selection: "
player1_selected = gets.chomp.downcase

print "Player 2 - Enter your selection: "
player2_selected = gets.chomp.downcase

if valid_input?(player1_selected, player2_selected)
  play_game(player1_selected, player2_selected)
else
  puts "No cheaters! Only Rock, Paper or Scissors are allowed."
end