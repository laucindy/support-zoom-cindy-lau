require 'minitest/autorun'
require_relative 'day04'


class PassphraseCheckerTest < Minitest::Test
  def test_sorted_words_already_sorted
    expected = ["aa", "bb", "cc", "dd"]
    assert_equal(expected, PassphraseChecker.sorted_words("aa bb cc dd"))
  end

  def test_sorted_words_unsorted
    expected = ["aa", "bb", "cc", "dd"]
    assert_equal(expected, PassphraseChecker.sorted_words("dd cc bb aa"))
  end

  def test_no_duplicate_words_returns_true
    assert(PassphraseChecker.valid?("aa bb cc dd"))
  end

  def test_no_duplicate_words_returns_false
    refute(PassphraseChecker.valid?("aa bb cc dd aa"))
  end

  def test_no_duplicate_words_accepts_similar_words_returns_true
    assert(PassphraseChecker.valid?("aa bb cc dd aaa"))
  end

  # Failing test. A passphrase that is an empty string should not be valid.
  def test_passphrase_is_empty_returns_false
    refute(PassphraseChecker.valid?(""))
  end

  def test_passphrase_each_word_is_made_of_symbols_returns_true
    assert(PassphraseChecker.valid?("!@# $%^ &*()"))
  end

  def test_passphrase_each_word_is_made_of_symbols_returns_false
    refute(PassphraseChecker.valid?("!@# $%^ &*() !@#"))
  end

  def test_spaces_at_beginning_and_end_of_passphrase_returns_true
    assert(PassphraseChecker.valid?(" aa bb cc dd "))
  end

  def test_all_caps_passphrase_returns_true
    assert(PassphraseChecker.valid?("AA BB CC DD"))
  end

  def test_all_caps_passphrase_returns_false
    refute(PassphraseChecker.valid?("AA BB CC DD AA"))
  end

  # Not clear in the problem description whether the same word in all caps should be valid or not
  # Assume it is valid for now
  def test_same_word_appears_twice_but_one_is_all_caps_returns_true
    assert(PassphraseChecker.valid?("aa bb cc dd AA"))
  end

  def test_number_of_valid_passphrases
    expected = 3
    assert_equal(expected, PassphraseChecker.num_valid(["aa bb cc dd", "aa bb cc dd aa", "aa bb cc dd aaa", "this is a password"]))
  end

  def test_number_of_valid_passphrases_empty_array
    expected = 0
    assert_equal(expected, PassphraseChecker.num_valid([]))
  end
end

class AnagramPassphraseCheckerTest < Minitest::Test
  def test_words_are_sorted
    expected = ["a", "a", "act", "aht", "in"]
    assert_equal(expected, AnagramPassphraseChecker.sorted_words("a cat in a hat"))
  end

  def test_anagram_passphrase_return_true
    assert(AnagramPassphraseChecker.valid?("abcde fghij"))
  end

  def test_anagram_passphrase_return_false
    refute(AnagramPassphraseChecker.valid?("abcde xyz ecdab"))
  end

  def test_anagram_passphrase_similar_words_return_true
    assert(AnagramPassphraseChecker.valid?("a ab abc abd abf abj"))
  end

  def test_anagram_passphrase_similar_number_of_letters_in_words_return_true
    assert(AnagramPassphraseChecker.valid?("iiii oiii ooii oooi oooo"))
  end

  def test_anagram_passphrase_same_number_of_letters_in_words_return_false
    refute(AnagramPassphraseChecker.valid?("oiii ioii iioi iiio"))
  end

  def test_number_of_valid_passphrases
    expected = 3
    assert_equal(expected, AnagramPassphraseChecker.num_valid(["abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj", "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio"]))
  end

  def test_number_of_valid_passphrases_empty_array
    expected = 0
    assert_equal(expected, AnagramPassphraseChecker.num_valid([]))
  end
end
