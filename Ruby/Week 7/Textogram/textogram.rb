class Textogram
  attr_reader :histogram_hash, :text

  def initialize(text)
    @histogram_hash = Hash.new(0)
    @text = text
  end

  def histogram_words(case_sensitive = false, include_special_characters = false)
    text = self.text
    text = downcase_text(text) unless case_sensitive
    text = remove_special_characters_from_words(text) unless include_special_characters

    self.histogram_hash = text&.split(" ")&.sort!&.tally
  end

  def histogram_letters(case_sensitive = true, include_special_characters = true, include_vowels = true)
    text = self.text
    text = downcase_text(text) unless case_sensitive
    text = remove_special_characters(text) unless include_special_characters
    text = remove_vowels(text) unless include_vowels

    self.histogram_hash = text&.chars&.sort!&.tally
  end

  def to_s
    histogram_hash.each do |key, value| 
      number_asterisks = "*" * value
      puts "#{key} #{number_asterisks}"
    end
  end

  private

  attr_writer :histogram_hash

  def downcase_text(text)
    text.downcase
  end

  def remove_special_characters(text)
    text.gsub(/[^0-9A-Za-z]/, '')
  end

  def remove_special_characters_from_words(text)
    text.gsub(/[^\-\s'0-9A-Za-z]/, '')
  end

  def remove_vowels(text)
    text.gsub(/[aeiou]/, '')
  end
end

=begin
# Read book from Project Gutenberg, get histogram of words
book = File.read("book.txt").strip
text_data = Textogram.new(book)
text_data.histogram_words
puts text_data.histogram_hash
#text_data.to_s
=end