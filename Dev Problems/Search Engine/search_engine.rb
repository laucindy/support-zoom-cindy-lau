require "json"

class FileReader
  def self.read_file(file_name:)
    products_file = File.read(file_name)
    JSON.parse(products_file)
  end
end

class SearchEngine
  attr_reader :products_list
  attr_accessor :inverted_index

  def initialize(file_name)
    @products_list = FileReader.read_file(file_name: file_name)
    @inverted_index = index_items()
  end

  def index_items
    inverted_index = {}

    products_list.each do |item|
      product_name_split_into_words = item['name'].split(' ')

      product_name_split_into_words.each do |word|
        word = word.downcase!
        inverted_index[word] ||= []
        inverted_index[word] << item['id']
      end
    end

    inverted_index
  end

  def search(term:, operator: nil)
    results = []
    term_split_into_words = term.split(' ')
    matching_item_ids = inverted_index[term_split_into_words[0]]

    if operator == 'AND'
      term_split_into_words[1..-1].each do |word|
        matching_item_ids = matching_item_ids & inverted_index[word]
      end
    elsif operator == 'OR'
      term_split_into_words[1..-1].each do |word|
        matching_item_ids << inverted_index[word]
      end

      matching_item_ids.flatten!
      matching_item_ids.uniq!
    end

    matching_item_ids.each do |id|
      product = products_list.find { |item| item["id"] == id }
      results << product["name"]
    end

    output_results(results)
  end

  def output_results(results)
    results.sort!
    puts "#{results.size} results found: "
    results.each { |item| puts "   #{item}" }
    puts
  end

end

search_engine = SearchEngine.new("products_small.json")

# find all product names that match `keyboard`
search_engine.search(term: "keyboard")

# implement `AND` condition (eg, `steel keyboard` should match product names that match both `steel` and `keyboard`)
search_engine.search(term: "steel keyboard", operator: "AND")

# implement `OR` condition
search_engine.search(term: "steel keyboard", operator: "OR")