require 'minitest/autorun'
require_relative 'children'

class CreatureTest < Minitest::Test
  def setup
    @items = { apple: 3, book: 5, umbrella: 8 }
  end

  def test_initialize_returns_correct_object
    creature = Creature.new('Bob', @items)
    assert_kind_of(Creature, creature)
  end

  def test_initialize_set_attributes_initial_states
    creature = Creature.new('Bob', @items)
    assert_equal('Bob', creature.name)
    assert_equal(@items, creature.items)
    assert_equal('content', creature.mood)
    assert_equal(8, creature.avg_hours_awake)
  end

  def test_initialize_set_attributes_custom_states
    creature = Creature.new('Bob', @items, 'happy', 10)
    assert_equal('Bob', creature.name)
    assert_equal(@items, creature.items)
    assert_equal('happy', creature.mood)
    assert_equal(10, creature.avg_hours_awake)
  end

  def test_initialize_subclass_returns_correct_object
    mermaid = Merpeople.new('Ariel', @items)
    dwarf = Dwarf.new('Gimli', @items)
    yeti = Yeti.new('Yeto', @items)

    assert_instance_of(Merpeople, mermaid)
    assert_instance_of(Dwarf, dwarf)
    assert_instance_of(Yeti, yeti)
  end

  def test_dwarf_class_set_hungry_attribute_success
    dwarf = Dwarf.new('Gimli', @items)
    dwarf.hungry = true

    assert_equal(true, dwarf.hungry)
  end

  def test_dwarf_class_set_hungry_attribute_fail
    dwarf = Dwarf.new('Gimli', @items)

    assert_raises(RuntimeError) { dwarf.hungry = "true" }
  end

  def test_mermaid_class_initialize_correct_attributes_set
    fluency = { english: 'native speaker', french: 'beginner', "spanish": 'intermediate' }
    mermaid = Merpeople.new('Ariel', @items, 'shiny', fluency)

    assert_equal('Ariel', mermaid.name)
    assert_equal(@items, mermaid.items)
    assert_equal('content', mermaid.mood)
    assert_equal(8, mermaid.avg_hours_awake)
    assert_equal('shiny', mermaid.favorite_style)
    assert_equal(fluency, mermaid.fluency)
  end

  def test_dwarf_class_initialize_objects_equal
    dwarf1 = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })
    dwarf2 = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })

    assert_equal(dwarf2, dwarf1)
  end

  def test_yeti_class_initialize_objects_not_equal
    yeti1 = Yeti.new('Yeto', { apple: 5, hat: 1, snowboard: 3 }, "Let's go!", { snowboarding: 'expert', sledding: 'expert', hockey: 'intermediate' })
    yeti2 = Yeti.new('Yeto', { apple: 5, hat: 1, snowboard: 3 })

    refute_equal(yeti2, yeti1)
  end

  def test_give_item_success
    mermaid = Merpeople.new('Ariel', { fork: 2, plate: 3, seashells: 5, apple: 4 })
    dwarf = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })

    mermaid.give_item(dwarf, "apple", 2)
    assert_equal({ fork: 2, plate: 3, seashells: 5, apple: 2 }, mermaid.items)
    assert_equal({ apple: 4, beer: 4, sword: 1 }, dwarf.items)
  end

  def test_give_item_fail_receiver_does_not_own_item
    mermaid = Merpeople.new('Ariel', { fork: 2, plate: 3, seashells: 5, apple: 4 })
    dwarf = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })
    expected = "Error: Gimli isn't currently carrying forks, and as a result, can't give it to Ariel.\n"

    assert_output(expected) { mermaid.give_item(dwarf, "fork", 2) }
  end

  def test_give_item_fail_giver_does_not_own_item
    mermaid = Merpeople.new('Ariel', { fork: 2, plate: 3, seashells: 5, apple: 4 })
    dwarf = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })
    expected = "Error: Ariel isn't currently carrying swords, and as a result, can't give it to Gimli.\n"

    assert_output(expected) { mermaid.give_item(dwarf, 'sword', 2) }
  end

  def test_receive_item_fail_receiver_does_not_own_item
    mermaid = Merpeople.new('Ariel', { fork: 2, plate: 3, seashells: 5, apple: 4 })
    dwarf = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })
    expected = "Error: Gimli isn't currently carrying forks, and as a result, can't give it to Ariel.\n"

    assert_output(expected) { dwarf.receive_item(mermaid, 'fork', 2) }
  end

  def test_receive_item_fail_giver_does_not_own_item
    mermaid = Merpeople.new('Ariel', { fork: 2, plate: 3, seashells: 5, apple: 4 })
    dwarf = Dwarf.new('Gimli', { apple: 2, beer: 4, sword: 1 })
    expected = "Error: Ariel isn't currently carrying swords, and as a result, can't give it to Gimli.\n"

    assert_output(expected) { dwarf.receive_item(mermaid, 'sword', 2) }
  end

  def test_speak
    mermaid = Merpeople.new('Ariel', @items)
    expected = "Ariel is speaking\n"
    assert_output(expected) { mermaid.speak }
  end

  def test_move
    dwarf = Dwarf.new('Gimli', @items)
    expected = "Gimli is walking around\n"

    assert_output(expected) { dwarf.move }
  end

  def test_mine
    dwarf = Dwarf.new('Gimli', @items)
    dwarf.mine

    refute_nil(dwarf.jewels_found)
  end

  def test_home_module_build_home
    mermaid = Merpeople.new('Ariel', @items)
    number_rooms = 3
    expected = "Ariel has successfully built a home for themselves! \nCreated #{number_rooms} rooms!\n"
    assert_output(expected) { mermaid.build_home { number_rooms } }
  end

  def test_recreation_module_playing_instance_variable
    yeti = Yeti.new('Yeto', { apple: 5, hat: 1, snowboard: 3 })
    
    yeti.start_game("hockey")
    assert_equal(true, yeti.playing?)
    yeti.stop_game
    assert_equal(false, yeti.playing?)
  end

end
