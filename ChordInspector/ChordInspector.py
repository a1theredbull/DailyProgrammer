import re

scale = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
tones_dict = {None:[0,4,7], 'm':[0,3,7], '7':[0,4,7,10], 'm7':[0,3,7,10], 'maj7':[0,4,7,11]}

def chord_to_note(chord):
	pattern = re.compile('([a-g]#?)(maj7|m7|m|7)?')
	note = re.match(pattern, chord).groups()

	position = scale.index(note[0].upper())
	tones = tones_dict[note[1]]
	resultNotes = tones

	for i in range(len(tones)):
		resultNotes[i] = scale[(position+tones[i]) % len(scale)]
	return resultNotes

chord = input('Enter a chord: ').lower()
print('Notes in', chord, ':', chord_to_note(chord))

