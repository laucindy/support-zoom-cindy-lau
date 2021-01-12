require_relative 'organism'
require_relative 'spaceship'
require_relative 'kepler1649c'

alligator = Alligator.new("Chomp", 3)
eagle = Eagle.new("Bob", 2)
gorilla = Gorilla.new("Sophia", 32)
pupfish = PupFish.new("Finley", 2)
fox = Fox.new("Fitz", 4)

puts "\e[34mSELECTED ORGANISMS FOR THIS MISSION: \e[0m"
puts "\e[44m                                     \e[0m\n\n"
alligator.print_info
eagle.print_info
gorilla.print_info
pupfish.print_info
fox.print_info

spaceship = Spaceship.new(10)
kepler1649c = Kepler1649c.new

successfully_loaded = spaceship.load_onto_ship(alligator, eagle, gorilla, pupfish, fox)
puts "\e[34mLOAD ORGANISMS ONTO SHIP: #{successfully_loaded} \e[0m"
puts "\e[44m                                    \e[0m\n\n"

exit if successfully_loaded == "Failed"
spaceship.blast_off

puts "\e[34m\nLANDING... \e[0m"
puts "\e[44m           \e[0m\n\n"
spaceship.land_on(kepler1649c)
kepler1649c.transfer_organisms_from(spaceship)

puts
kepler1649c.jump_one_million_years