require 'minitest/autorun'
require_relative '../clothes'

class ClothesTest < Minitest::Test
  def setup
    @clothes = Clothes.new("T-shirt", "green")
  end

  def test_clothes_initialized
    assert_equal("T-shirt", @clothes.name)
  end

  def test_to_s
    expected = "This is a green T-shirt.\n"
    assert_output(expected) { puts @clothes.to_s }
  end
end