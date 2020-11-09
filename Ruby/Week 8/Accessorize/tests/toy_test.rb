require 'minitest/autorun'
require_relative '../toy'

class ToyTest < Minitest::Test
  def setup
    @toy = Toy.new('Lego Figure')
  end

  def test_toy_initialized
    assert_equal("Lego Figure", @toy.name)
  end

  def test_to_s
    expected = "This is a Lego Figure.\n"
    assert_output(expected) { puts @toy.to_s }
  end
end