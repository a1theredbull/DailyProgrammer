import random, signal, sys

def print_monkey_doc(signum, frame):
	print('\nThe monkey wrote this for you!')
	print(written_by_monkey)
	sys.exit(0)

print('Theorem: If a monkey randomly mashes on a keyboard for an infinite amount of time, he/she will eventually' +
 ' write any piece of literature(i.e. Hamlet, but astronomically small chance).\n')

filename = input('Monkey will start typing once you give it a file of valid words: ')
file = open(filename, 'r')
valid_words = []
for line in file:
	valid_words.append(line.strip().lower())

letters = 'aaabbccddeeeffgghhiiijkllmmnnoooppqrrssttuuuvwwxyyz           '
gibberish = ''

print('Monkey is about to mash the keyboard...press Ctrl+C to exit!')
signal.signal(signal.SIGINT, print_monkey_doc)
print('Be patient: Each valid word may take thousands of monkey attempts.')
written_by_monkey = ''
count = 0

while count < 100: #for this implementation, writes up to 100 valid 3+ letter words
	c = random.choice(letters)
	if c is ' ' and gibberish in valid_words:
		if len(gibberish) >= 3:
			if len(gibberish) == 3 and random.randrange(0, 8) != 0: #1/8 the chance of 3-letter words
				gibberish = ''										#since they are the most typed
				continue
			print(gibberish)
			written_by_monkey += gibberish + ' '
			count += 1
			sys.stdout.flush()
		gibberish = ''
	elif len(gibberish) > 12: #too long
		gibberish = ''
	else:
		gibberish += c

print('\nThe monkey wrote this for you!')
print(written_by_monkey)
