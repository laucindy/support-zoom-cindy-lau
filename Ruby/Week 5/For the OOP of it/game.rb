require_relative 'mixins'

class Game
  include ArrayFunctions

  def initialize(name)
    @name = name
    @time_played_per_session_minutes = []
    @playing = false
  end

  @@is_numeric = Proc.new { |time| time.is_a? Numeric }

  def name=(name)
    if name == "" || !(name.is_a?(String))
      raise "Name can't be blank and must be a string!"
    end

    @name = name
  end

  def total_time_played
    total = get_sum(@time_played_per_session_minutes)
    puts "Total time spent playing #{@name} to date: #{total} minutes"
  end

  def add_time_played(time_played)
    add_number(@time_played_per_session_minutes, time_played)
    puts "Added #{time_played} minutes played to session history."
  end

  def remove_times_played_by_index(index)
    remove_number_by_index(@time_played_per_session_minutes, index)
    puts "Removed time played at index #{index}."
  end

  def remove_times_played(time_played)
    remove_number(@time_played_per_session_minutes, time_played)
    puts "Removed all values that match #{time_played} from session history."
  end

  def check_time_played_per_session
    puts "Time played per session: #{@time_played_per_session_minutes.inspect}"
  end

  def start_game
    if @playing
      puts "You are already playing a game!" 
      return
    end

    @playing = true
    puts block_given? ? yield : "Starting #{@name} game. Ready, set, go!"
  end

  def playing_game?
    puts @playing ? "Still playing #{@name}." : "Not currently playing #{@name}."
  end

  def end_game
    if !@playing
      puts "There currently isn't a game in progress! Unable to end game." 
      return
    end

    @playing = false
    puts block_given? ? yield : "Ending game."
  end
end