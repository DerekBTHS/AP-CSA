f = lambda x : x**2 - 2
fprime = lambda x : 2*x

def newton(x, iterations):
    for i in range(iterations):
        x = x - f(x) / fprime(x)
        print(f'x{i+1} = {x}')
    return x

newton(1, 4)