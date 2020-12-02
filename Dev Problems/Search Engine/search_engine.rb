require "json"

class FileReader
  def self.read_file(file_name:)
    products_file = File.read(file_name)
    JSON.parse(products_file)
  end
end

class SearchExact
  def find(term:, products_list:)
    results = []

    products_list.each do |item|
      results << item['name'] if include_term?(term: term, item_name: item["name"])
    end

    results
  end

  private

  def include_term?(term:, item_name:)
    item_name.downcase.include? term
  end
end

class SearchAND
  def find(term:, products_list:)
    words_array = term.split(" ").map(&:downcase)
    results = []

    products_list.each do |item|
      results << item["name"] if all_words_included?(words: words_array, item_name: item["name"])
    end

    results
  end

  private
  
  def all_words_included?(words:, item_name:)
    words.all? { |word| item_name.downcase.include? word }
  end
end

class SearchOR
  def find(term:, products_list:)
    words_array = term.split(' ').map(&:downcase)
    results = []

    products_list.each do |item|
      results << item['name'] if at_least_one_word_included?(words: words_array, item_name: item["name"])
    end

    results
  end

  private

  def at_least_one_word_included?(words:, item_name:)
    words.any? { |word| item_name.downcase.include? word }
  end
end

class SearchEngine
  attr_reader :products_list

  def initialize(file_name)
    @products_list = FileReader.read_file(file_name: file_name)
  end

  def search(term:, operator: nil)
     search = SearchExact.new

    if operator == "AND"
      search = SearchAND.new
    elsif operator == "OR"
      search = SearchOR.new
    end

    results = search.find(term: term, products_list: products_list)
    output_results(results)
  end

  def output_results(results)
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