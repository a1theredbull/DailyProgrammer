def calc_mean(data):
	return sum(data)/len(data)

def calc_var(data):
	mean = calc_mean(data)
	total = 0
	for num in data:
		total += (num-mean)**2
	return total/len(data)

def calc_stdvar(data):
	return calc_var(data) ** 0.5

filename = input('Enter filename to analyze(.txt please): ')
file = open(filename, 'r')
data = []
for line in file:
	data.append(float(line))

print("Mean: ", calc_mean(data) )
print("Variance: ", calc_var(data) )
print("Standard Deviation: ", calc_stdvar(data) )