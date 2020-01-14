# Created by Eddie Garcia at 1/14/20

# Main File

from Python.sudoku.solver.sudoku_solver import solve_puzzle


def main():
    print("Hello World")
    arr = []

    for row in range(0, 9):
        arr.append([])
        for col in range(0, 9):
            arr[row].append(col)

    print_board(arr)
    solve_puzzle(arr)
    print_board(arr)


def print_board(arr):
    value = ""
    for row_value in range(len(arr)):
        for col_value in range(len(arr[row_value])):
            value += str(arr[row_value][col_value]) + " "
        value += "\n"
    print(value)


main()
