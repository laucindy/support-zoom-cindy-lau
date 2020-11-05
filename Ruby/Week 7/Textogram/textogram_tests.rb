require 'minitest/autorun'
require_relative 'textogram'

class TextogramTest < Minitest::Test
  def test_histogram_letters_case_sensitive_exclude_special_characters_include_vowels
    text = "HELLO World!"
    text_data = Textogram.new
    text_data.histogram(text)
    expected = "  *\n! *\nE *\nH *\nL **\nO *\nW *\nd *\nl *\no *\nr *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_case_insensitive_include_special_characters_include_vowels
    text = "HELLO World!"
    text_data = Textogram.new
    text_data.histogram(text, false)
    expected = "  *\n! *\nd *\ne *\nh *\nl ***\no **\nr *\nw *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_case_insensitive_include_special_characters_exclude_vowels
    text = 'HELLO World!'
    text_data = Textogram.new
    text_data.histogram(text, false, true, false)
    expected = "  *\n! *\nd *\nh *\nl ***\nr *\nw *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_empty_string
    text = ""
    text_data = Textogram.new
    text_data.histogram(text)
    expected = ""
    assert_output(expected) { text_data.to_s }
  end

  def test_string_containing_only_spaces_include_special_characters
    text = "  "
    text_data = Textogram.new
    text_data.histogram(text)
    expected = "  **\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_string_containing_only_spaces_exclude_special_characters
    text = "  "
    text_data = Textogram.new
    text_data.histogram(text, true, false)
    expected = ""
    assert_output(expected) { text_data.to_s }
  end
end