class Textogram
  def initialize
    @histogram_hash = Hash.new(0)
  end

  def histogram(text, case_sensitive = true, include_special_characters = true, include_vowels = true)
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

  attr_accessor :histogram_hash

  def downcase_text(text)
    text.downcase
  end

  def remove_special_characters(text)
    text.gsub(/[^0-9A-Za-z]/, '')
  end

  def remove_vowels(text)
    text.gsub(/[aeiou]/, '')
  end
end