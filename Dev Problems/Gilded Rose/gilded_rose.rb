class GildedRose

  def initialize(items)
    @items = items
  end

  def update_quality()
    aged_brie = "Aged Brie"
    backstage_passes = "Backstage passes to a TAFKAL80ETC concert"
    conjured_mana_cake = 'Conjured Mana Cake'
    sulfuras = 'Sulfuras, Hand of Ragnaros'
    max_quality = 50

    items_that_increase_in_quality = [aged_brie, backstage_passes]
    legendary_items = [sulfuras]
    
    @items.each do |item|
      case item.name
      when aged_brie
        item.quality += 1
        item.quality += 1 if (item.sell_in <= 0) && (item.quality < max_quality)
        item.sell_in -= 1
      when backstage_passes
        if item.sell_in > 0
          item.quality += 1
          item.quality += 1 if (item.sell_in <= 10) && (item.quality < max_quality)
          item.quality += 1 if (item.sell_in <= 5) && (item.quality < max_quality)
          
          item.sell_in -= 1
        else
          item.quality = 0
          item.sell_in -= 1
        end
      when conjured_mana_cake
        quality_degradation = (item.sell_in > 0) ? 2 : 4
        item.quality -= quality_degradation if item.quality < max_quality
        item.sell_in -= 1
      when sulfuras
        item.quality = 80
      else
        item.quality -= 1 if item.quality < max_quality
        item.sell_in -= 1
      end
    end
  end
end

class Item
  attr_accessor :name, :sell_in, :quality

  def initialize(name, sell_in, quality)
    @name = name
    @sell_in = sell_in
    @quality = quality
  end

  def to_s()
    "#{@name}, #{@sell_in}, #{@quality}"
  end
end
