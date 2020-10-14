def select_items
  print "Player 1 - Enter your selection: "
  player1_selected = gets.chomp.downcase

  print "Player 2 - Enter your selection: "
  player2_selected = gets.chomp.downcase

  [player1_selected, player2_selected]
end

def valid_items?(item1, item2)
  valid_items = ["rock", "paper", "scissors"]

  # check that both items contain the exact string "rock", "paper" or "scissors"
  if valid_items.any? {|word| item1 == word} && valid_items.any? {|word| item2 == word}
    true
  else
    puts "No cheaters! Only Rock, Paper or Scissors are allowed."
    false
  end
end

def compare_items(item1, item2)
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

  winner
end

def play_game
  player1_selected = nil
  player2_selected = nil

  loop do
    player1_selected, player2_selected = select_items
    break if valid_items?(player1_selected, player2_selected)
  end

  winner = compare_items(player1_selected, player2_selected)

  if winner.nil?
    play_game
  else
    puts "Player #{winner + 1} wins."
  end
end

play_game