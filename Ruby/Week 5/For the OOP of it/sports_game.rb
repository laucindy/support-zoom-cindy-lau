require_relative 'game'

class SportsGame < Game
  def initialize(name, team_size)
    super(name)
    @team_size = team_size
    @scores = {}
  end

  def start_game
    super { "Starting a game of #{@name}, each team has #{@team_size} people." }
  end

  def playing_game?
    puts @playing ? "Yes b'y, we're still playing #{@name.downcase}!" : "Finished playing a game of #{@name.downcase}."
  end

  def add_winner(game, winner)
    raise "Winner must be a string" unless winner.is_a? String
    @scores[game] = winner
    puts "#{winner} has won #{game}"
  end

  def most_matches_won
    @scores.values.group_by { |e| e }.max_by{ |_, v| v.size }.first
  end
end