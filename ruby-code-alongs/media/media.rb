module AcceptsComments
  def comments
    @comments ||= []
  end

  def add_comment(comment)
    comments << comment
  end
end

class Photo
  include AcceptsComments

  def initialize
    @format = 'JPEG'
  end
end

class Clip
  def play
    puts "Playing #{object_id}..."
  end
end

class Video < Clip
  include AcceptsComments
  attr_accessor :resolution
end

class Song < Clip
  include AcceptsComments
  attr_accessor :beats_per_minute
end

video = Video.new
video.add_comment("Cool slow motion effect!")
video.add_comment("Weird ending.")

song = Song.new
song.add_comment("Awesome beat.")

p video.comments, song.comments

photo = Photo.new
photo.add_comment("Beautiful colors")
p photo.comments