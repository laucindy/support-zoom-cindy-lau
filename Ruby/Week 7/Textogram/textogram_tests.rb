require 'minitest/autorun'
require_relative 'textogram'

class TextogramTest < Minitest::Test
  def test_histogram_letters_case_sensitive_exclude_special_characters_include_vowels
    text = "HELLO World!"
    text_data = Textogram.new(text)
    text_data.histogram_letters
    expected = "  *\n! *\nE *\nH *\nL **\nO *\nW *\nd *\nl *\no *\nr *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_case_insensitive_include_special_characters_include_vowels
    text = "HELLO World!"
    text_data = Textogram.new(text)
    text_data.histogram_letters(false)
    expected = "  *\n! *\nd *\ne *\nh *\nl ***\no **\nr *\nw *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_case_insensitive_include_special_characters_exclude_vowels
    text = "HELLO World!"
    text_data = Textogram.new(text)
    text_data.histogram_letters(false, true, false)
    expected = "  *\n! *\nd *\nh *\nl ***\nr *\nw *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_empty_string
    text = ""
    text_data = Textogram.new(text)
    text_data.histogram_letters
    expected = ""
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_string_containing_only_spaces_include_special_characters
    text = "  "
    text_data = Textogram.new(text)
    text_data.histogram_letters
    expected = "  **\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_letters_string_containing_only_spaces_exclude_special_characters
    text = "  "
    text_data = Textogram.new(text)
    text_data.histogram_letters(true, false)
    expected = ""
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_words_case_insensitive_exclude_special_characters
    text = "HELLO World!"
    text_data = Textogram.new(text)
    text_data.histogram_words
    expected = "hello *\nworld *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_words_case_sensitive_exclude_special_characters
    text = "HELLO World!"
    text_data = Textogram.new(text)
    text_data.histogram_words(true)
    expected = "HELLO *\nWorld *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_words_case_insensitive_include_special_characters
    text = "HELLO World!"
    text_data = Textogram.new(text)
    text_data.histogram_words(false, true)
    expected = "hello *\nworld! *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_words_case_sensitive_include_special_characters
    text = 'HELLO World!'
    text_data = Textogram.new(text)
    text_data.histogram_words(true, true)
    expected = "HELLO *\nWorld! *\n"
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_words_empty_string
    text = ""
    text_data = Textogram.new(text)
    text_data.histogram_words
    expected = ""
    assert_output(expected) { text_data.to_s }
  end

  def test_histogram_words_string_containing_only_spaces
    text = "  "
    text_data = Textogram.new(text)
    text_data.histogram_words
    expected = ""
    assert_output(expected) { text_data.to_s }
  end
end