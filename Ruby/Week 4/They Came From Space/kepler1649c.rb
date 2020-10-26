require_relative 'spaceship'
require_relative 'utils'

require 'active_support/inflector'  # for pluralize support

class Kepler1649c
  def initialize
    @number_moons = 3
    @distance_from_sun_km = 12785068
    @atmosphere = "65% nitrogen, 15% oxygen, 19% carbon dioxide, 0.9% argon, 0.1% other gasses"
    @surface_notes = "cold, but prone to solar flares"
    @organisms = nil
  end
  
  def transfer_organisms_from(spaceship)
    @organisms = spaceship.organisms
    spaceship.organisms = nil

    puts "Successfully transfered organisms from the spaceship to Kepler-1649c" if !@organisms.nil?
  end

  def jump_one_million_years
    if @organisms.nil?
      puts "No organisms exist one million years later"
      return
    end

    @organisms_count = @organisms.map { |organism| rand(100000) - rand(75000) }

    puts "One million years later, there are now: "
    @organisms.each_with_index do |organism, i| 
      count_string = "#{(@organisms_count[i] < 0) ? 0 : @organisms_count[i]} #{organism.class.name.downcase.pluralize}"
      Utils.typing_animation(count_string)
      sleep 0.25
      print "\n"
    end
  end

  def to_s
    "Kepler-1649c"
  end
end