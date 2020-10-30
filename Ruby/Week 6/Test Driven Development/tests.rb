require 'minitest/autorun'

require_relative 'part1'

class AsciiArtTest < Minitest::Test
  def setup

  end

  def test_outputs_triangle_of_asterisks_left_aligned
    ascii_art = AsciiArt.new
    expected = "*\n**\n***\n"
    actual = ascii_art.draw(3)
    assert_equal(expected, actual)
  end
end