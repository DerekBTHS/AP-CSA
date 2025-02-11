# Derek, Ian, Alex, Moho 
values = {}

def series(n, branches):
    if n in values:
        return values[n]
    elif n == 0:
        return 0
    elif n == 1:
        return branches + 1
    values[n] = branches + 1/(1 + 1/series(n-1, branches))
    return values[n]

print (series(999, 2))

for i in range(10):
    print(series(i, 2))

print("We're the best team ever!")