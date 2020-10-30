require 'minitest/autorun'

require_relative 'lego'

class LegoHatTest < Minitest::Test
  def setup
    @hat = LegoHat.new('small', 'red', 'beanie')
  end

  def test_initialize_creates_object
    assert_kind_of(LegoHat, @hat)
  end

  def test_initialize_correct_instance_variables
    assert_equal('small', @hat.size)
    assert_equal('red', @hat.colour)
    assert_equal('beanie', @hat.style)
  end

  # Fails, the `to_s` method defined incorrect variables
  def test_to_string
    assert_equal("a small red beanie", @hat.to_s)
  end

end

class LegoItemTest < Minitest::Test
  def test_initialize_creates_object
    sword = LegoItem.new('sword', 5)
    assert_kind_of(LegoItem, sword)
  end

  def test_initialize_correct_instance_variables
    sword = LegoItem.new('sword', 5.5)
    assert_equal('sword', sword.name)
    assert_equal(5.5, sword.weight)
  end

  def test_to_string
    sword = LegoItem.new('sword', 5.5)
    assert_equal("a 5.5 gram sword", sword.to_s)
  end

  def test_is_heavy_under_threshold
    sword = LegoItem.new('sword', 5.5)
    assert_equal(false, sword.is_heavy(10))
  end

  def test_is_heavy_over_threshold
    shield = LegoItem.new('shield', 12)
    assert_equal(true, shield.is_heavy(10))
  end
end

class LegoMinifigureTest < Minitest::Test
  def setup
    @hat = LegoHat.new('small', 'red', 'beanie')
    @sword = LegoItem.new('sword', 5.5)
    @shield = LegoItem.new('shield', 12)
  end

  def test_initialize_creates_object
    figure = LegoMinifigure.new('Emmet')
    assert_kind_of(LegoMinifigure, figure)
  end

  def test_initialize_no_items
    figure = LegoMinifigure.new('Emmet')
    assert_nil(figure.hat)
    assert_nil(figure.left_item)
    assert_nil(figure.right_item)
  end

  def test_initialize_all_items
    figure = LegoMinifigure.new('Emmet', @hat, @sword, @shield)
    assert_kind_of(LegoHat, figure.hat)
    assert_kind_of(LegoItem, figure.left_item)
    assert_kind_of(LegoItem, figure.right_item)
  end

  def test_to_string_no_items
    figure = LegoMinifigure.new('Emmet')
    expected = "A Lego minifigure named Emmet."
    assert_equal(expected, figure.to_s)
  end

  # This will fail, since the LegoHat `to_s` method hasn't been set up properly
  def test_to_string_all_items
    figure = LegoMinifigure.new('Emmet', @hat, @sword, @shield)
    expected = 'A Lego minifigure named Emmet, who is wearing a small red beanie and is holding a 5.5 gram sword in the left hand and a 12 gram shield in the right hand.'
    assert_equal(expected, figure.to_s)
  end

  def test_hat_words_no_hat
    figure = LegoMinifigure.new('Emmet')
    expected = ""
    assert_equal(expected, figure.hat_words)
  end

  # This will fail, since the LegoHat `to_s` method hasn't been set up properly
  def test_hat_words_with_hat
    figure = LegoMinifigure.new('Emmet', @hat)
    expected = ', who is wearing a small red beanie'
    assert_equal(expected, figure.hat_words)
  end

  def test_left_item_words_no_items
    figure = LegoMinifigure.new('Emmet')
    expected = ""
    assert_equal(expected, figure.left_item_words)
  end

  def test_left_item_words_left_item_only
    figure = LegoMinifigure.new('Emmet', nil, @sword)
    expected = ", who is holding a 5.5 gram sword in the left hand"
    assert_equal(expected, figure.left_item_words)
  end

  def test_left_item_words_hat_and_left_item
    figure = LegoMinifigure.new('Emmet', @hat, @sword)
    expected = ' and is holding a 5.5 gram sword in the left hand'
    assert_equal(expected, figure.left_item_words)
  end

  def test_right_item_words_no_items
    figure = LegoMinifigure.new('Emmet')
    expected = ''
    assert_equal(expected, figure.right_item_words)
  end

  # Failing test, outputs "holdinga (weight) (item)" instead of "holding a (weight) (item)"
  def test_right_item_words_right_item_only
    figure = LegoMinifigure.new('Emmet', nil, nil, @sword)
    expected = ', who is holding a 5.5 gram sword in the right hand'
    assert_equal(expected, figure.right_item_words)
  end

  # Failing test, outputs "holdinga (weight) (item)" instead of "holding a (weight) (item)"
  def test_right_item_words_hat_and_right_item
    figure = LegoMinifigure.new('Emmet', @hat, nil, @sword)
    expected = ' and is holding a 5.5 gram sword in the right hand'
    assert_equal(expected, figure.right_item_words)
  end

  def test_right_item_words_left_and_right_items
    figure = LegoMinifigure.new('Emmet', nil, @sword, @shield)
    expected = ' and a 12 gram shield in the right hand'
    assert_equal(expected, figure.right_item_words)
  end

  def test_right_item_words_all_items
    figure = LegoMinifigure.new('Emmet', @hat, @sword, @shield)
    expected = ' and a 12 gram shield in the right hand'
    assert_equal(expected, figure.right_item_words)
  end

  def test_is_stylish_return_true
    figure = LegoMinifigure.new('Emmet', @hat)
    assert_equal(true, figure.is_stylish?)
  end

  def test_is_stylish_return_false
    hat = LegoHat.new("small", "black", "beanie")
    figure = LegoMinifigure.new('Emmet', hat)
    assert_equal(false, figure.is_stylish?)
  end

  def test_swap_hands
    figure = LegoMinifigure.new('Emmet', @hat, @sword, @shield)
    figure.swap_hands
    assert_same(@shield, figure.left_item)
    assert_same(@sword, figure.right_item)
  end

  def test_swap_hands_left_hand_empty
    figure = LegoMinifigure.new('Emmet', @hat, nil, @shield)
    figure.swap_hands
    assert_same(@shield, figure.left_item)
    assert_nil(figure.right_item)
  end

  def test_swap_hands_right_hand_empty
    figure = LegoMinifigure.new('Emmet', @hat, @sword, nil)
    figure.swap_hands
    assert_nil(figure.left_item)
    assert_same(@sword, figure.right_item)
  end

  def test_wear_hat_not_currently_wearing_hat
    figure = LegoMinifigure.new('Emmet')
    figure.wear_hat(@hat)
    assert_same(@hat, figure.hat)
  end

  def test_wear_hat_replace_hat
    figure = LegoMinifigure.new('Emmet', @hat)
    new_hat = LegoHat.new("medium", "blue", "cap")
    figure.wear_hat(new_hat)
    assert_same(new_hat, figure.hat)
  end

  def test_remove_hat
    figure = LegoMinifigure.new('Emmet', @hat)
    new_hat = nil
    figure.wear_hat(new_hat)
    assert_nil(figure.hat)
  end

  def test_place_in_left_hand_currently_no_item
    figure = LegoMinifigure.new('Emmet')
    figure.place_in_left_hand(@sword)
    assert_same(@sword, figure.left_item)
  end

  def test_place_in_left_hand_replace_item
    figure = LegoMinifigure.new('Emmet', nil, @sword)
    new_item = LegoItem.new("cat", 14)
    figure.place_in_left_hand(new_item)
    assert_same(new_item, figure.left_item)
  end

  def test_remove_item_in_left_hand
    figure = LegoMinifigure.new('Emmet', nil, @sword)
    new_item = nil
    figure.place_in_left_hand(new_item)
    assert_nil(new_item, figure.left_item)
  end

  def test_place_in_right_hand_currently_no_item
    figure = LegoMinifigure.new('Emmet')
    figure.place_in_right_hand(@sword)
    assert_same(@sword, figure.right_item)
  end

  def test_place_in_right_hand_replace_item
    figure = LegoMinifigure.new('Emmet', nil, nil, @sword)
    new_item = LegoItem.new('cat', 14)
    figure.place_in_right_hand(new_item)
    assert_same(new_item, figure.right_item)
  end

  def test_remove_item_in_right_hand
    figure = LegoMinifigure.new('Emmet', nil, nil, @sword)
    new_item = nil
    figure.place_in_right_hand(new_item)
    assert_nil(new_item, figure.right_item)
  end

  def test_is_strong_return_true
    figure = LegoMinifigure.new('Emmet', nil, @sword, @shield)
    assert_equal(true, figure.is_strong?)
  end

  def test_is_strong_return_false
    apple = LegoItem.new("apple", 2)
    figure = LegoMinifigure.new('Emmet', nil, @sword, apple)
    assert_equal(false, figure.is_strong?)
  end

  # Failing test, the `is_strong?` method should be modified to check if the left or right item is nil before proceeding
  def test_is_strong_only_one_item_in_hand
    figure = LegoMinifigure.new('Emmet', nil, @sword)
    assert_equal(false, figure.is_strong?)
  end
end