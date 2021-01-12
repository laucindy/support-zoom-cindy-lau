module Home
  def build_home
    number_rooms = block_given? ? yield : create_rooms
    puts "#{@name} has successfully built a home for themselves! \nCreated #{number_rooms} rooms!"
  end

  def create_rooms
    rooms_required = rand(3) + 2
  end
end

module Recreation
  def initialize(*args)
    @playing = false
    super(args[0], args[1], args[2], args[3])
  end

  def start_game(game)
    @playing = true
    @game = game
  #  puts "#{@name} has started playing #{@game}"
  end

  def playing?
    @playing
  end

  def stop_game
    @playing = false
  #  puts "#{@name} has stopped playing #{@game}"
  end
end

module Fight
  def attack(weapon)
    puts "Attacking enemy with #{weapon}"
  end

  def defend
    puts "Defending self"
  end
end