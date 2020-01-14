# Created by Eddie Garcia at 1/14/20

# Sudoku Solver.
# Solves the given Sudoku Puzzle.

# Should only be used once.
# Will be using a back tracking algorithm.


def solve_puzzle(arr):
    print("Works.")

    for row in range(0, 9):
        if not solve(row, 0, arr):
            return False
    return True, arr


def solve(row, col, arr):
    if col > len(arr):
        return False

    for value in range(1, 10):
        print(value)
        arr[row][col] = value
        if validPlacement(row, col, arr):
            if solve(row, col + 1, arr):
                return True

    return False


def validPlacement(row, col, arr):
    row_list = [False] * 9
    col_list = [False] * 9
    section = [False] * 9

    # Checks the columns.
    for temp_row in range(0, 9):
        if row_list[arr[temp_row][col]-1]:
            return False
        row_list[arr[temp_row][col]-1] = True

    # Checks the row.
    for temp_col in range(0, 9):
        if col_list[arr[row][temp_col]-1]:
            return False
        row_list[arr[row][temp_col]-1] = True

    # Checks the quadrant.
    if row > 3:
        row_list = [0, 1, 2]
    elif row > 6:
        row_list = [3, 4, 5]
    else:
        row_list = [6, 7, 8]

    if col > 3:
        col_list = [0, 1, 2]
    elif col > 6:
        col_list = [3, 4, 5]
    else:
        col_list = [6, 7, 8]

    for row_value in row_list:
        for col_value in col_list:
            if section[arr[row_value][col_value]-1]:
                return False
            section[arr[row_value][col_value]-1] = True
    return True
