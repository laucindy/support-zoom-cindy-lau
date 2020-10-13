def accelerate
  puts "Stepping on the gas"
  puts "Speeding up"
end

def sound_horn
  puts "Pressing the horn button"
  puts "Beep beep!"
end

def use_headlights(brightness = "low-beam")
  puts "Turning on #{brightness}"
  puts "Watch out for deer!"
end

use_headlights
sound_horn
accelerate
use_headlights("high-beam")