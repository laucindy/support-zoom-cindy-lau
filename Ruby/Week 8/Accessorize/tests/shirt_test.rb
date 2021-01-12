require 'minitest/autorun'
require_relative '../shirt'

class ShirtTest < Minitest::Test
  def setup
    @shirt = Shirt.new('Tshirt', 'green')
  end

  def test_shirt_initialized
    assert_equal('Tshirt', @shirt.name)
  end

  def test_add_accessory
    @shirt.add_accessory('necklace')
    expected = ['necklace']
    assert_equal(expected, @shirt.accessories)
  end

  def test_add_multiple_accessories
    @shirt.add_accessory('necklace')
    @shirt.add_accessory('gold bracelet')
    @shirt.add_accessory('silver bracelet')

    expected = ['necklace', 'gold bracelet', 'silver bracelet']
    assert_equal(expected, @shirt.accessories)
  end

  def test_remove_accessory
    @shirt.add_accessory('necklace')
    @shirt.remove_accessory('necklace')
    expected = []
    assert_equal(expected, @shirt.accessories)
  end

  def test_remove_accessory_that_does_not_exist
    @shirt.remove_accessory('necklace')
    expected = nil
    assert_nil(@shirt.accessories)
  end

  def test_accessories_string
    @shirt.add_accessory('necklace')
    @shirt.add_accessory('bracelet')

    expected = "accessories:\n\t- necklace\n\t- bracelet"
    assert_equal(expected, @shirt.accessories_to_s)
  end

  def test_accessories_string_empty
    assert_nil(@shirt.accessories_to_s)
  end

  def test_to_s
    @shirt.add_accessory('necklace')
    @shirt.add_accessory('bracelet')

    expected = "A green Tshirt, with accessories:\n\t- necklace\n\t- bracelet"
    assert_equal(expected, @shirt.to_s)
  end
end
