class Organism
  attr_reader :name, :age, :advantage

  def initialize(name, age)
    @name = name
    @age = age
  end

  def eat
    puts "eating"
  end

  def drink
    puts "drinking"
  end 

  def mate
    puts "mating"
  end

  def print_info
    skills = (methods - Object.new.methods) - [:print_info]
    puts "#{@name} the #{self.class.name.downcase} is #{@age} years old. They have been chosen because #{@advantage}. #{@name} can do the following: #{skills.sort!.join(', ')} \n\n"
  end
end

class Gorilla < Organism
  def initialize(name, age)
    super(name, age)
    @advantage = "they are extremely strong and smart"
  end

  def attack(weapon)
    if weapon.nil?
      puts "Attacking with bare fists, #{name} doesn't have a weapon" 
    else
      puts "Attacking enemy with #{weapon}"
    end
  end

  def create_shelter
    puts 'creating a shelter'
  end

  def kill
    puts 'killing'
  end
end

class Alligator < Organism
  def initialize(name, age)
    super(name, age)
    @advantage = "alligators are great swimmers"
  end

  def attack
    puts 'Attacking enemy by biting them'
  end

  def kill
    puts 'killing prey'
  end

  def run
    puts 'running'
  end

  def swim
    puts 'swimming'
  end

  def walk
    puts 'walking'
  end
end


class Eagle < Organism
  def initialize(name, age)
    super(name, age)
    @advantage = "eagles are capable of flying and are powerful creatures"
  end

  def attack
    puts 'attacking with claws and beak'
  end

  def create_nest
    puts 'creating a nest'
  end

  def fly
    puts "flying"
  end

  def kill
    puts "killing prey"
  end

  def see_into_distance
    puts "checking the distance for threats"
  end
end

class PupFish < Organism
  def initialize(name, age)
    super(name, age)
    @advantage = "a pupfish can essentially live anywhere that has water, and can tolerate extremely harsh conditions"
  end

  def swim
    puts "swimming"
  end
end

class Fox < Organism
  def initialize(name, age)
    super(name, age)
    @advantage = "their species (Ruppell's fox) is one of the most heat-resistant animals on Earth"
  end

  def attack
    puts 'attacking'
  end

  def run
    puts 'running'
  end

  def scavenge
    puts 'scavenging food'
  end

  def walk
    puts 'walking'
  end
end
