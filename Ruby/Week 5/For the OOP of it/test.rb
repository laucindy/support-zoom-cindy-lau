require_relative 'board_game'
require_relative 'sports_game'
require_relative 'video_game'

# Test VideoGame class
mario = VideoGame.new("Mario", 75, "Nintendo Switch")
mario.start_game
puts

mario.add_time_played(7)
mario.add_time_played(10)
mario.add_time_played(15)
puts

mario.check_time_played_per_session
mario.total_time_played
puts

mario.remove_time_played_at_index(1)
mario.add_time_played(7)
mario.add_time_played(20)
mario.remove_all_times_played_with_value(7)
puts

mario.playing_game?
mario.check_time_played_per_session
mario.total_time_played
puts

#mario.add_score("2") # outputs an error, since 2 is a string, instead of a number

mario.rate_game(4)
mario.end_game

puts

# Test SportsGame class
soccer = SportsGame.new("sockqer", 11)
soccer.name = "Soccer"
soccer.start_game
puts

soccer.add_winner("Game 1", "Toronto")
soccer.add_winner("Game 2", "Ottawa")
soccer.playing_game?
soccer.add_winner("Game 3", "Toronto")
soccer.add_winner('Game 4', 'Montreal')
puts

soccer.end_game
soccer.playing_game?
puts "#{soccer.most_matches_won} has won the most matches."

puts

# Test BoardGame class
monopoly = BoardGame.new("Monopoly", 4, 6)
monopoly.start_game
monopoly.start_game    # error, as a game has already started
monopoly.playing_game?
puts

monopoly.add_player
monopoly.add_player
monopoly.add_player
puts

monopoly.winner("Player 3")

monopoly.end_game
monopoly.end_game     # error, as game has already ended
monopoly.playing_game?