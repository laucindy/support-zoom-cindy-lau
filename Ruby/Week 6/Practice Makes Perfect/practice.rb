def simulate_studying(subject)
  study_efficiency = 0
  study_session = 1

  puts "Studying for a #{subject}"

  while study_efficiency < 8 && block_given?
    study_efficiency += yield(study_session) if block_given?

    puts "Finished study session ##{study_session}. The study efficiency was: #{study_efficiency}"
    sleep 0.5     # take a break/rest from studying

    study_session += 1
    puts
  end

  puts "Done studying, after #{study_session - 1} study sessions!\n\n"
end

# Test code
#simulate_studying("spelling test") { |study_session| (study_session * rand(0..10)) % 11 }

#simulate_studying("music exam") { |study_session| study_session + 3 }
