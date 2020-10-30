require 'minitest/autorun'
require_relative 'ascii_art'

class AsciiArtTest < Minitest::Test
  def setup

  end

  def test_outputs_triangle_of_asterisks_left_aligned
    ascii_art = AsciiArt.new.extend LeftTriangle
    expected_3_stars = "*\n**\n***\n"
    expected_4_stars = "*\n**\n***\n****\n"

    assert_output(expected_3_stars) { puts ascii_art.draw(3) }
    assert_output(expected_4_stars) { puts ascii_art.draw(4) }
  end

  def test_empty_output_triangle_of_asterisks_left_aligned
    ascii_art = AsciiArt.new.extend LeftTriangle
    expected = "\n"
    assert_output(expected) { puts ascii_art.draw(0) }
  end

  def test_outputs_triangle_of_asterisks_right_aligned
    ascii_art = AsciiArt.new.extend RightTriangle
    expected_3_stars = "  *\n **\n***\n\n"
    expected_4_stars = "   *\n  **\n ***\n****\n\n"

    assert_output(expected_3_stars) { puts ascii_art.draw(3) }
    assert_output(expected_4_stars) { puts ascii_art.draw(4) }
  end

  def test_empty_output_triangle_of_asterisks_right_aligned
    ascii_art = AsciiArt.new.extend RightTriangle
    expected = "\n"
    assert_output(expected) { puts ascii_art.draw(0) }
  end
end