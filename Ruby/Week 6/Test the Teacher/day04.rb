class PassphraseChecker
  def self.sorted_words(phrase)
    phrase.split(' ').sort
  end

  def self.valid?(phrase)
    words = sorted_words(phrase)
    valid = true
    words.each_with_index do |word, index|
      if index == words.length - 1
        break
      elsif word == words[index + 1]
        valid = false
        break
      end
    end
    valid
  end

  def self.num_valid(phrases)
    phrases.count { |phrase| valid?(phrase) }
  end
end

class AnagramPassphraseChecker < PassphraseChecker
  def self.sorted_words(phrase)
    sorted = phrase.split(' ').sort
    sorted.each_with_index do |_word, index|
      sorted[index] = sorted[index].chars.sort.join
    end
    sorted.sort
  end
end

#input = File.read('day04-input.txt').strip.split("\n")
#puts "#{PassphraseChecker.num_valid(input)} phrases are valid"
#puts "#{AnagramPassphraseChecker.num_valid(input)} phrases are valid"
