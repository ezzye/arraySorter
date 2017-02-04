def make_input(num, lst)
  num + "\n" + lst.tr(',', "\n") + "\n"
end

input = ''
shell_output = ''

When(/list of integers (.*) with (.*) of entries is input/) do |list, numbers|
  input = make_input(numbers, list)
end

# see http://ruby.bastardsbook.com/chapters/external-programs/
# for explanation about IO.popen
Then(/arraySorter sorts list/) do
  IO.popen('../../run', 'r+') do |pipe|
    pipe.puts(input)
    pipe.close_write
    shell_output = pipe.read
  end
  puts "\nThis is result \n#{shell_output}"
end

Then(/outputs sorter array that matches "(.*)"/) do |expected|
  length = expected.length
  puts "\nExpect result is: #{expected}"
  puts "\nActual result is: #{shell_output[-length - 1, length]}"
  expect(expected).to eq(shell_output[-length - 1, length])
end
