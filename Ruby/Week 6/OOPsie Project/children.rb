require_relative 'parent'
require_relative 'modules'

class Merpeople < Creature
  include Home
  prepend Recreation

  attr_reader :favorite_style, :fluency

  def initialize(name, items, favorite_style = "", fluency = Hash.new("beginner"))
    super(name, items)
    @favorite_style = favorite_style
    @fluency = fluency
  end

  def favorite_style=(favorite_style)
    raise 'favorite_style must be a String' unless favorite_style.is_a?(String)

    @favorite_style = favorite_style
  end

  def fluency=(fluency)
    raise 'fluency must be a Hash' unless fluency.is_a?(Hash)

    @fluency = fluency
  end

  def move
    puts "#{@name} is swimming"
  end

  def diving_for_treasure
    puts "#{@name}'s diving for treasure, and is in search for #{@favorite_style} things."
  end

  def output_fluency_levels
    puts "#{@name} is fluent in the following languages:"
    @fluency.each { |language, fluency| puts "\t#{language.capitalize}: #{fluency}" }
  end

  def ==(other)
    [name, items, mood, avg_hours_awake, favorite_style, fluency] == [other.name, other.items, other.mood, other.avg_hours_awake, other.favorite_style, other.fluency]
  end

end

class Dwarf < Creature
  include Home
  include Fight

  attr_reader :hungry, :jewels_found
  def initialize(name, items, hungry = false, jewels_found = Hash.new(0))
    super(name, items)
    @hungry = hungry
    @jewels_found = jewels_found
  end

  def hungry=(hungry)
    raise "hungry must be either of the class TrueClass or FalseClass" if !(hungry.is_a?(TrueClass) || hungry.is_a?(FalseClass))
    @hungry = hungry
  end

  def jewels_found=(jewels_found)
    raise "jewels_found must be a Hash" if !jewels_found.is_a?(Hash)
    @jewels_found = jewels_found
  end

  def move
    puts "#{@name} is walking around"
  end

  def mine
    jewels_list = ["alexandrite", "amethyst", "aquamarine", "citrine", "diamond", "emerald", "garnet", "iolite", "onyx", "opal", "peridot", "ruby", "sapphire", "topaz"]

    randomly_selected = rand(jewels_list.length)
    stone = jewels_list[randomly_selected]
    @jewels_found[stone] += 1

    puts "Mining jewels... found #{stone}!"
  end

  def hungry?
    @hungry = (rand(2) == 1) ? true : false
    puts "#{name} is#{@hungry ? "" : " not"} hungry."
  end

  def ==(other)
    [name, items, mood, avg_hours_awake, hungry, jewels_found] == [other.name, other.items, other.mood, other.avg_hours_awake, other.hungry, other.jewels_found]
  end
end

class Yeti < Creature
  include Fight
  prepend Recreation

  attr_reader :catch_phrase, :sports_proficiency

  def initialize(name, items, catch_phrase = "", sports_proficiency = Hash.new("beginner"))
    super(name, items)
    @catch_phrase = catch_phrase
    @sports_proficiency = sports_proficiency
  end

  def catch_phrase=(catch_phrase)
    raise "catch_phrase must be a String" if !catch_phrase.is_a?(String)
    @catch_phrase = catch_phrase
  end

  def sports_proficiency=(sports_proficiency)
    raise "sports_proficiency must be a Hash" if !sports_proficiency.is_a?(Hash)
    @sports_proficiency = sports_proficiency
  end

  def move
    puts "#{@name} is stomping around... STOMP STOMP"
  end

  def build_snowman
    puts "#{@name} is building a snowman and singing a song! #{@catch_phrase}"
  end

  def check_sports_proficiency
    puts "#{@name} is proficient at the following sports:"
    @sports_proficiency.each { |sports, proficiency| puts "\t#{sports.capitalize}: #{proficiency}" }
  end

  def ==(other)
    [name, items, mood, avg_hours_awake, catch_phrase, sports_proficiency] == [other.name, other.items, other.mood, other.avg_hours_awake, other.catch_phrase, other.sports_proficiency]
  end
end