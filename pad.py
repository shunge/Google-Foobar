import math
def answer(n):

	# dynamic programming/memoization
    max_square = int(math.sqrt(n))
    Matrix = [[x for x in range(n+1)] for y in range(max_square)]
    base = 1
    square = 1

    for i ,row in enumerate(Matrix):
        for j ,item in enumerate(Matrix[i]):
            if(item >= square):
                Matrix[i][j] = min(Matrix[i-1][j], Matrix[i][item-square]+1)
            else:
                Matrix[i][j] = min(Matrix[i-1][j], item)
        base = base+1
        square = base*base


	# return the last element in the matrix, which is our result
    return Matrix[max_square-1][n]