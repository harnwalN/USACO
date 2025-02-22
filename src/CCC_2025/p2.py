word = str(input())
index = int(input())

numbers = [f"{i}" for i in range(10)]

letters = []

for i in range(len(word)):
    if word[i] not in numbers:
        letters.append(i)
letters.append(len(word))

size = 0
for i in range(len(letters)-1):
    cur = letters[i]
    next = letters[i+1]
    size+=int(word[cur+1:next])

last_s = ""
index %= size

cur_index = 0
for i in range(len(letters)-1):
    cur = letters[i]
    next = letters[i+1]

    s = word[cur]
    last_s = s
    num = int(word[cur+1:next])
    cur_index+=num-1
    if cur_index>=index:
        break
    cur_index+=1

print(last_s)
