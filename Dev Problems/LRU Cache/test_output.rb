require_relative './cache'

cache = Cache.new(max_size: 3)
cache.to_h

cache.write('key1', 'value1')
cache.to_h

cache.write('key2', 'value2')
cache.to_h

cache.write('key3', 'value3')
cache.to_h

puts

cache.write('key4', 'value4')
cache.to_h

cache.read('key1')
cache.read('key2')
cache.to_h

puts

cache.write('key5', 'value5')
cache.write('key6', 'value6')
cache.to_h

puts

cache.count
cache.write('key5', 'value5-overwrite')
cache.read('key5')
cache.to_h

cache.clear
cache.to_h
