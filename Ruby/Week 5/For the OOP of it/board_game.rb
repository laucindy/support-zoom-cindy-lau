require_relative 'game'
require_relative 'mixins'

class BoardGame < Game
  include Notes
  include Rating

  def initialize(name, num_players, max_players)
    super(name)
    @num_players = num_players
    @max_players = max_players
    @notes = ""
    @rating
  end

  def start_game
    super { "Setting up a game of #{@name}, with a maximum of #{@max_players} players... Let's play!" }
  end

  def playing_game?
    puts @playing ? "Still playing #{@name}" : "No one is playing #{@name} right now."
  end

  def add_player
    if @num_players >= @max_players
      puts "Can not add another player! Reached max for this game."
    else
      @num_players += 1
      puts "Added another player to the game! There are now #{@num_players} players in the game."
    end
  end

  def winner(winner)
    puts "Congrats #{winner}, you've won the game!"
  end
end
