require 'sinatra/base'
require 'securerandom'

class UrlShortenerApp < Sinatra::Application
  get '/' do
    erb :index
  end

  get '/:short_url' do
    short_url_code = params[:short_url]
    list_urls = UrlShortener.class_variable_get(:@@list_of_urls)

    if list_urls.key?(short_url_code)
      original_url = list_urls[short_url_code]
      redirect original_url
    else
      erb :not_found, :layout => :index
    end
  end

  post '/' do
    domain = request.env["HTTP_HOST"]
    original_url = params[:url][:original_url]

    list_urls = UrlShortener.class_variable_get(:@@list_of_urls)

    # ensure shortened url isn't currently being used for another url
    short_url_code = ""
    loop do
      short_url_code = UrlShortener.encode_url
      break if !list_urls.key?(short_url_code)
    end
    
    list_urls[short_url_code] = original_url
    UrlShortener.class_variable_set(:@@list_of_urls, list_urls)

    @new_url = domain + "/" + short_url_code
    erb :output, :layout => :index
  end
end

class UrlShortener
  # format for hash: { short_url => original_url }
  @@list_of_urls = {}

  def self.encode_url
    SecureRandom.alphanumeric(6)
  end
end