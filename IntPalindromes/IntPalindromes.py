frstart = int(input('1st Range Start: '))
frend = int(input('1st Range End: ')) + 1
srstart = int(input('2nd Range Start: '))
srend = int(input('2nd Range End: ')) + 1

def findPalindrome(a1, a2, b1, b2):
	found = False;
	result = [];
	for i in range(a1, a2):
		for j in range(b1, b2):
			product = i*j
			if str(product)[::-1] == str(product):
				result.append(str(i) + ' x ' + str(j) + ' = ' + str(product))
				found = True
	return result

palindromes = findPalindrome(frstart, frend, srstart, srend)
print('---=== Palindromes ===--- ')
for palindrome in palindromes:
	print(palindrome)
