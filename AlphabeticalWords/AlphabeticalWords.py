print('This program takes a file containing words and finds how many of' +
'those words are alphabetical.')

filename = input('Enter filename to analyze(.txt please): ')
file = open(filename).readlines()

count = 0
for word in file:
	word = word.strip()
	if list(word) == sorted(word): count += 1

print('Count: ', count)
