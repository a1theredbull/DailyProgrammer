import random, signal, sys

def print_monkey_doc(signum, frame):
	print('\nThe monkey wrote this for you!')
	print(written_by_monkey)
	sys.exit(0)

signal.signal(signal.SIGINT, print_monkey_doc)

print('Theorem: If a monkey randomly mashes on a keyboard for an infinite amount of time, he/she will eventually' +
 ' write any piece of literature(i.e. Hamlet, but astronomically small chance).\n')

filename = input('Monkey will start typing once you give it a file of valid words: ')
file = open(filename, 'r')
valid_words = []
for line in file:
	valid_words.append(line.strip())

letters = 'abcdefghjklmnopqrstuvwxyz      '
gibberish = ''

print('Monkey is about to mash the keyboard...press Ctrl+C to exit!')
print('Be patient: Each valid word may take thousands of monkey attempts.')
written_by_monkey = ''
count = 0

while count < 30: #for this implementation, writes up to 30 valid 3+ letter words
	c = random.choice(letters)
	if c is ' ':
		if gibberish in valid_words:
			if len(gibberish) < 3:
				gibberish = ''
			else:
				print(gibberish)
				written_by_monkey += gibberish + ' '
				count += 1
				gibberish = ''
        elif len(gibberish) > 14: #too long gibberish
		gibberish = ''
	else:
		gibberish += c
