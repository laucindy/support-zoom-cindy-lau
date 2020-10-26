def find_adjective(string)
  words = string.split(" ")
  index = words.find_index("is")
  
  if words[index + 1].chars.last == ":"
    words[index + 1] = words[index + 1].slice(0, words[index + 1].length - 1)
  end
  
  words[index + 1]
end

lines = []

File.open("reviews.txt") do |review_file|
  lines = review_file.readlines
end

relevant_lines = lines.find_all { |line| line.include?("Truncated") }
reviews = relevant_lines.reject { |line| line.include?("--") }

adjectives = reviews.map do |review| 
  adjective = find_adjective(review)
  "'#{adjective.capitalize}'"
end

puts "The critics agree, Truncated is:"
puts adjectives
