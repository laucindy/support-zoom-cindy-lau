require 'minitest/autorun'
require_relative 'gilded_rose'

class GildedRoseTest < Minitest::Test
  def setup

  end

  def test_aged_brie_before_sell_in_date
    items = [Item.new(name="Aged Brie", sell_in=2, quality=0)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(1, items[0].sell_in)
    assert_equal(1, items[0].quality)
  end

  def test_aged_brie_after_sell_in_date
    items = [Item.new(name="Aged Brie", sell_in=0, quality=5)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(-1, items[0].sell_in)
    assert_equal(7, items[0].quality)
  end

  def test_sulfuras
    items = [Item.new(name="Sulfuras, Hand of Ragnaros", sell_in=4, quality=80)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(4, items[0].sell_in)
    assert_equal(80, items[0].quality)
  end

  def test_backstage_passes_greater_than_10_days
    items = [Item.new(name="Backstage passes to a TAFKAL80ETC concert", sell_in=15, quality=20)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(14, items[0].sell_in)
    assert_equal(21, items[0].quality)
  end

  def test_backstage_passes_less_than_10_days_greater_than_5
    items = [Item.new(name="Backstage passes to a TAFKAL80ETC concert", sell_in=7, quality=20)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(6, items[0].sell_in)
    assert_equal(22, items[0].quality)
  end

  def test_backstage_passes_less_than_5_days_greater_than_0
    items = [Item.new(name = 'Backstage passes to a TAFKAL80ETC concert', sell_in = 3, quality = 20)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(2, items[0].sell_in)
    assert_equal(23, items[0].quality)
  end

  def test_backstage_passes_0_days_left
    items = [Item.new(name = 'Backstage passes to a TAFKAL80ETC concert', sell_in = 0, quality = 20)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(-1, items[0].sell_in)
    assert_equal(0, items[0].quality)
  end

  def test_conjured_before_sell_in_date
    items = [Item.new(name="Conjured Mana Cake", sell_in=3, quality=6)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(2, items[0].sell_in)
    assert_equal(4, items[0].quality)
  end

  def test_conjured_after_sell_in_date
    items = [Item.new(name="Conjured Mana Cake", sell_in=0, quality=6)]
    gilded_rose = GildedRose.new(items)
    gilded_rose.update_quality
    assert_equal(-1, items[0].sell_in)
    assert_equal(2, items[0].quality)
  end

end