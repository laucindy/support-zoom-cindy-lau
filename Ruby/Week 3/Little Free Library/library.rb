class Book
  attr_reader :title, :page_count

  def initialize(title, page_count)
    @title = title
    @page_count = page_count
  end
end

class User
  attr_accessor :current_books
  attr_reader :name

  def initialize(name)
    @current_books = []
    @name = name
  end

  def current_books
    if @current_books.length > 0
      puts "#{@name} has checked out the following book#{@current_books.length == 1 ? '' : 's'}:"
      @current_books.each { |book| puts book.title }
      puts
    else
      puts "#{@name} currently does not have any books checked out."
    end
  end

  def add_book_to_currently_reading_list(title, page_count)
    @current_books << Book.new(title, page_count)
    puts "Added #{title} to your current reading list"
  end

  def take_book(title, library)
    book_to_take = library.take(title)

    if book_to_take.nil?
      puts "#{title} can't be found in the library"
    else
      @current_books << book_to_take
      puts "Successfully checked out #{book_to_take.title}"
    end
  end

  def place_book(title, library)
    book_to_put_back = @current_books.find { |book| book.title.downcase == title.downcase }

    if book_to_put_back.nil?
      puts "Can't find #{title} in #{@name}'s list of currently reading books"
      return
    end

    successfully_put_back_book = library.place?(book_to_put_back)

    if successfully_put_back_book
      @current_books.delete_at(@current_books.find_index { |book| book.title.downcase == title.downcase })
    end
  end
end

class Library
  attr_reader :books

  def initialize(books)
    @books = books
    @max_books = 18
  end

  def look
    puts "There are #{@books.length} books available in the library:"
    @books.each { |book| puts "\t#{book.title} - #{book.page_count} pages" }
    puts
  end

  def take(title)
    book_to_take = @books.find { |book| book.title.downcase == title.downcase }
    @books.delete_at(@books.find_index{ |book| book.title.downcase == title.downcase }) if !book_to_take.nil?

    book_to_take
  end

  def place?(book)
    if @books.length < @max_books
      @books << book
      puts "Successfully put #{book.title} into the library"
      true
    else
      puts "Library is full, cannot put #{book.title} into the library."
      false
    end
  end
end

def print_menu_options
  puts "Please select an option: "
  puts "\t1. Take a book from the library"
  puts "\t2. Place book into the library"
  puts "\t3. Add a book to your currently reading list"
  puts "\t4. Look at all available library books"
  puts "\t5. Check your currently reading list"
  puts "\t6. Exit"
end

def go_to_option(input, user, library)
  case input
  when 1
    print "Enter book title to take: "
    title = gets.chomp

    user.take_book(title, library)
  when 2
    print "Which book? "
    title = gets.chomp

    user.place_book(title, library)
  when 3
    print "Enter the book title: "
    currently_reading_title = gets.chomp
    
    print "Enter the page count: "
    currently_reading_page_count = gets.chomp.to_i

    user.add_book_to_currently_reading_list(currently_reading_title, currently_reading_page_count)
  when 4
    library.look
  when 5
    user.current_books
  end
end

books = []
books.insert(0, 
  Book.new('The Hobbit', 310),
  Book.new('The Fellowship of the Ring', 423),
  Book.new('The Two Towers', 352),
  Book.new('The Return of the King', 416),
  Book.new('To Kill a Mockingbird', 324),
  Book.new('Pride and Prejudice', 279),
  Book.new('The Great Gatsby', 200),
  Book.new('Jane Eyre', 532),
  Book.new('The Catcher in the Rye', 277),
  Book.new('1984', 237),
  Book.new('Animal Farm', 141),
  Book.new('Lord of the Flies', 182),
  Book.new('Frankenstein', 288),
  Book.new('1984', 237),
  Book.new('Of Mice and Men', 103),
  Book.new('Wuthering Heights', 464),
)

little_free_library = Library.new(books)

print 'Enter your name: '
name = gets.chomp
puts

user = User.new(name)

puts "Welcome to the little free library, #{name}! \n\n"
little_free_library.look

loop do 
  print_menu_options

  input = gets.chomp.to_i

  puts
  go_to_option(input, user, little_free_library)
  puts

  break if input == 6
end
