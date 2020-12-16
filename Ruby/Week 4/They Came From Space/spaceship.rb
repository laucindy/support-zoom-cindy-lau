class Spaceship
  attr_accessor :organisms

  def initialize(gas, *organisms)
    @gas = gas
    @organisms = nil
    @current_planet = nil
  end

  def load_onto_ship(*organisms)
    @organisms = organisms
    @organisms.nil? ? "Failed" : "Sucessful"
  end

  def blast_off
    @current_planet = nil
    gas_required = rand(@gas / 2)

    puts "Blast off!"

    while @gas > gas_required
      puts "Gas left: #{@gas}"
      @gas -= 1
      sleep 1
    end

  end

  def land_on(planet)
    puts "Landed on #{planet}"
    @current_planet = planet
  end

  def print_info
    puts "I'm a spaceship"
  end
end