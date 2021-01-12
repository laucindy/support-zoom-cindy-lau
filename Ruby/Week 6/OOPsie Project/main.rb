require_relative 'children'

# Test Creature class
creature1 = Creature.new("Bob", { apple: 3, book: 5, umbrella: 8 })

creature2 = Creature.new("Rob", { apple: 0, chocolate: 4, umbrella: 2 })

creature1.receive_item(creature2, "book", 1)
puts "Creature1: #{creature1.items}"
puts "Creature2: #{creature2.items}"
puts

# Test setter methods
creature1.mood = "delighted"
puts creature1.mood

creature1.avg_hours_awake = 12
puts creature1.avg_hours_awake
puts

# Test Merpeople subclass
ariel = Merpeople.new("Ariel", { fork: 2, plate: 3, seashells: 5, apple: 4 }, "shiny", { english: 'native speaker', french: 'beginner', "spanish": 'intermediate' })
ariel.diving_for_treasure
ariel.output_fluency_levels
puts

ariel.build_home{ 3 }
puts

puts "Currently playing game? #{ariel.playing?}"
ariel.start_game("tag")
puts "Currently playing game? #{ariel.playing?}"
ariel.stop_game
puts "Currently playing game? #{ariel.playing?}"
puts

# Test Dwarf class
gimli = Dwarf.new("Gimli", { apple: 2, beer: 4, sword: 1 })
gimli.hungry?
gimli.attack("sword")
gimli.defend
puts

gimli.build_home { 4 }
puts

gimli.mine
gimli.mine
gimli.mine
puts "List of jewelry found: #{gimli.jewels_found.inspect}"
puts

# Test Yeti class
yeto = Yeti.new("Yeto", { apple: 5, hat: 1, snowboard: 3 }, "Let's go!", {snowboarding: "expert", sledding: "expert", hockey: "intermediate"})

yeto.build_snowman
yeto.check_sports_proficiency
puts

puts "Currently playing game? #{yeto.playing?}"
yeto.start_game("hockey")
puts "Currently playing game? #{yeto.playing?}"
yeto.stop_game
puts "Currently playing game? #{yeto.playing?}"