def find_adjective(string)
  words = string.split(" ")
  index = words.find_index("is")
  words[index + 1]
end

lines = []

File.open("reviews.txt") do |review_file|
  lines = review_file.readlines
end

relevant_lines = lines.find_all { |line| line.include?("Truncated") }
reviews = relevant_lines.reject { |line| line.include?("--") }

string = reviews.first
words = string.split(" ")

adjectives = []

reviews.each do |review|
  adjectives << find_adjective(review)
end

puts adjectives
