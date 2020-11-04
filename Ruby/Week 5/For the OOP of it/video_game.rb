require_relative 'game'

class VideoGame < Game
  def initialize(name, price, console)
    super(name)
    @price = price
    @console = console
    @rating = nil
  end

  def playing_game?
    super
    puts "#{@name} is quite fun to play!" if @playing
  end

  def end_game
    super { "Finished playing #{@name} for the day. Powering down the #{@console}..." }
  end

  def rate_game(rating)
    @rating = rating
    puts "Sucessfully rated game! #{@name} is now rated #{@rating} stars."
  end
end