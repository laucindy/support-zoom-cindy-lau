require_relative 'game'
require_relative 'mixins'

class VideoGame < Game
  include Notes
  include Rating

  def initialize(name, price, console)
    super(name)
    @price = price
    @console = console
    @notes = ""
    @rating = nil
  end

  def playing_game?
    super
    puts "#{@name} is quite fun to play!" if @playing
  end

  def end_game
    super { "Finished playing #{@name} for the day. Powering down the #{@console}..." }
  end
end