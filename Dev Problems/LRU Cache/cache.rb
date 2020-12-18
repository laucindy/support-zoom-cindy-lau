class Item
  @@rank = 0

  attr_reader :key_value_pair 
  attr_accessor :rank

  def initialize(key:, value:)
    @key_value_pair = {key => value}
    @rank = @@rank
    increment_rank
  end

  def increment_rank
    @@rank = @@rank + 1
  end

  def self.increment_rank
    @@rank = @@rank + 1
  end

  def self.rank
    @@rank
  end
end

class Cache
  def initialize(max_size:)
    @data = []
    @max_size = max_size
  end

  def write(key, value)
    # check if item key already exists
    item = @data.find { |item| item.key_value_pair.keys.first == key }

    # if item key already exists in the cache, then update its value and return
    unless item.nil?
      item.key_value_pair[key] = value
      return
    end

    if @data.count == @max_size
      # remove least recently used key-value pair
      lowest_index = least_recently_used_index
      @data.delete_at(lowest_index)
    end

    item = Item.new(key: key, value: value)
    @data << item
  end

  def read(key)
    # update its rank
    item = @data.find { |item| item.key_value_pair.keys.first == key }

    unless item.nil?
      item.rank = Item.rank
      Item.increment_rank
    end

    p item&.key_value_pair&.values&.first
  end

  def delete(key:)
    @data.delete(key)
  end

  def clear
    @data = {}
  end

  def count
    puts @data.count
  end

  def to_h
    @hash = {}

    @data.each do |item|
      item = item.key_value_pair
      @hash[item.keys.first] = item.values.first
    end

    p @hash
  end

  private
  
  def least_recently_used_index
    lowest_rank = Item.rank
    lowest_index = 0

    @data.each_with_index do |item, index|
      if item.rank < lowest_rank
        lowest_rank = item.rank
        lowest_index = index
      end
    end

    lowest_index
  end
end